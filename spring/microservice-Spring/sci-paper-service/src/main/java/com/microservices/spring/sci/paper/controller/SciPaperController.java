package com.microservices.spring.sci.paper.controller;

import com.microservices.spring.sci.paper.model.SciPaper;
import com.microservices.spring.sci.paper.model.dto.UploadPaperDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.microservices.spring.sci.paper.service.SciPaperService;

import java.util.List;

@RestController
@RequestMapping("/scipaper")
public class SciPaperController {

    @Autowired
    SciPaperService sciPaperService;

    @PostMapping("/{username}")
    public SciPaper uploadSciPaper(@PathVariable String username, @Validated @RequestBody UploadPaperDto dto) {
        return sciPaperService.uploadSciPaper(username, dto);
    }

    @GetMapping("/")
    public List<SciPaper> getAll() {
        return sciPaperService.getAll();
    }

    @GetMapping("/{id}")
    public SciPaper getOne(@PathVariable String id) {
        return sciPaperService.getOne(id);
    }


}
