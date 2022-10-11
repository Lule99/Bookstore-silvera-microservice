package com.microservices.spring.sci.paper.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryEntryDto {

    private String paperId;
    private String title;
    private String author;

    @Override
    public String toString() {
        return  "paperId:\t'" + paperId + '\'' +
                ", title:\t'" + title + '\'' +
                ", author:\t'" + author + '\'' ;
    }
}
