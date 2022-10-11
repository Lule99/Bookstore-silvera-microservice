/**
    THIS IS GENERATED CODE AND SHOULD NOT BE CHANGED MANUALLY!!!

    Generated by: silvera
    Date: 2022-05-07 18:49:21
*/

package com.silvera.Library.domain.model;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.*;
public class LibraryEntryDto {

    
    @Id
    private String id;
    
    
    
    @NotBlank(message="Field 'paperId' cannot be empty!")
    private java.lang.String paperId;
    
    
    @NotBlank(message="Field 'title' cannot be empty!")
    private java.lang.String title;
    
    
    @NotBlank(message="Field 'author' cannot be empty!")
    private java.lang.String author;


    
    public java.lang.String getPaperId() {
        return this.paperId;
    }

    public void setPaperId(java.lang.String paperId) {
        this.paperId = paperId;
    }
    
    public java.lang.String getTitle() {
        return this.title;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }
    
    public java.lang.String getAuthor() {
        return this.author;
    }

    public void setAuthor(java.lang.String author) {
        this.author = author;
    }
    

    
    public String getId(){
        return this.id;
    }
    

}