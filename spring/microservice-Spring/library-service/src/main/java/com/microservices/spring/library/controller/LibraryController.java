package com.microservices.spring.library.controller;

import com.microservices.spring.library.model.LibraryEntry;
import com.microservices.spring.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @GetMapping("/")
    public List<LibraryEntry> getAll() {
        return libraryService.getAllEntries();
    }
}
