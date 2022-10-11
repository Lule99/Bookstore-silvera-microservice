package com.microservices.spring.library.listener;

import com.microservices.spring.library.model.dto.LibraryEntryDto;
import com.microservices.spring.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @Autowired
    LibraryService libraryService;


    @KafkaListener(
            topics = "PUBLISH_PAPER",
            groupId = "groupid",
            containerFactory = "kafkaListenerContainerFactory"
    )
    void listener(LibraryEntryDto data) {
        libraryService.saveEntry(data);
    }
}
