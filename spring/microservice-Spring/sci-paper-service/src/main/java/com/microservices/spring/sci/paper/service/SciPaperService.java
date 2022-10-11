package com.microservices.spring.sci.paper.service;

import com.microservices.spring.sci.paper.exception.NoSuchSciPaperException;
import com.microservices.spring.sci.paper.exception.NotFoundException;
import com.microservices.spring.sci.paper.exception.UserNotLoggedInException;
import com.microservices.spring.sci.paper.model.SciPaper;
import com.microservices.spring.sci.paper.model.dto.LibraryEntryDto;
import com.microservices.spring.sci.paper.model.dto.UploadPaperDto;
import com.microservices.spring.sci.paper.repository.SciPaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SciPaperService {

    @Autowired
    SciPaperRepository sciPaperRepository;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    KafkaTemplate<String, LibraryEntryDto> kafkaTemplate;

    public SciPaper uploadSciPaper(String username, UploadPaperDto dto) {
        if (!checkIfLoggedIn(username)) {
            throw new UserNotLoggedInException("Please log in first");
        }
        String author = getAuthor(username);
        SciPaper sci = SciPaper.builder()
                .author(author)
                .title(dto.getTitle())
                .sections(dto.getSections())
                .build();
        SciPaper retVal = sciPaperRepository.save(sci);
        publish(retVal);
        return retVal;
    }

    private String getAuthor(String username) {
        String author = restTemplate.getForObject(
                "http://localhost:9191/user/get-name/" + username,
                String.class);
        if (author == null)
            throw new NotFoundException("Author not found");
        return author;
    }

    private boolean checkIfLoggedIn(String username) {
        return Boolean.TRUE.equals(restTemplate.getForObject(
                "http://localhost:9191/user/is-logged-in/" + username,
                Boolean.class));
    }

    public SciPaper publish(SciPaper sciPaper) {


        LibraryEntryDto dto = LibraryEntryDto.builder()
                .paperId(sciPaper.getId())
                .title(sciPaper.getTitle())
                .author(sciPaper.getAuthor())
                .build();

        ListenableFuture<SendResult<String, LibraryEntryDto>> future =
                kafkaTemplate.send("PUBLISH_PAPER", dto);
        ;

        future.addCallback(new ListenableFutureCallback<>() {

            @Override
            public void onSuccess(SendResult<String, LibraryEntryDto> result) {
                LibraryEntryDto entry = result.getProducerRecord().value();
                System.out.println("Publish successfull!\t" + entry +
                        "\t with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=[" + dto + "] due to : " + ex.getMessage());
            }
        });
        return sciPaper;
    }

    public SciPaper getOne(String id) {
        return sciPaperRepository.findById(id).orElseThrow(NoSuchSciPaperException::new);
    }

    public List<SciPaper> getAll() {
        return sciPaperRepository.findAll();
    }

}
