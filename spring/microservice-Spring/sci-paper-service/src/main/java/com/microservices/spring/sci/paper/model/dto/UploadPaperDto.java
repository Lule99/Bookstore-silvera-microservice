package com.microservices.spring.sci.paper.model.dto;

import com.microservices.spring.sci.paper.model.Section;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadPaperDto {

    @NotNull
    private String title;
    private List<Section> sections;
}
