package com.microservices.spring.sci.paper.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SciPaper {
    @Id
    private String id;
    @NotNull
    private String author;
    @NotNull
    private String title;
    private List<Section> sections;

}
