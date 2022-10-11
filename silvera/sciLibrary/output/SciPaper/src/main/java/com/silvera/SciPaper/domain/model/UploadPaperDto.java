/**
    THIS IS GENERATED CODE AND SHOULD NOT BE CHANGED MANUALLY!!!

    Generated by: silvera
    Date: 2022-05-07 18:49:21
*/

package com.silvera.SciPaper.domain.model;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.*;
public class UploadPaperDto {

    
    @Id
    private String id;
    
    
    
    @NotBlank(message="Field 'title' cannot be empty!")
    private java.lang.String title;
    
    
    @NotNull(message="Field 'sections' is mandatory!")
    private java.util.List<Section> sections= java.util.Collections.emptyList();


    
    public java.lang.String getTitle() {
        return this.title;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }
    
    public java.util.List<Section> getSections() {
        return this.sections;
    }

    public void setSections(java.util.List<Section> sections) {
        this.sections = sections;
    }
    

    
    public String getId(){
        return this.id;
    }
    

}