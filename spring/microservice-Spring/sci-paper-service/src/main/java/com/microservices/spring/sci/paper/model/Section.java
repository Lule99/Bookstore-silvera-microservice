package com.microservices.spring.sci.paper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Section {

    @Id
    @NotNull
    private String name;
    @NotNull
    private String content;

}
