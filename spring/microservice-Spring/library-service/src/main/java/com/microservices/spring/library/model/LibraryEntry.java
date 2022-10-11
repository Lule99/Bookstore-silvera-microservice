package com.microservices.spring.library.model;

import com.microservices.spring.library.model.dto.LibraryEntryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryEntry {

    @Id
    private String id;
    private String paperId;
    private String title;
    private String author;

    public LibraryEntry(LibraryEntryDto dto) {
        this.author = dto.getAuthor();
        this.paperId = dto.getPaperId();
        this.title=dto.getTitle();
    }
}
