package com.microservices.spring.library.service;

import com.microservices.spring.library.model.LibraryEntry;
import com.microservices.spring.library.model.dto.LibraryEntryDto;
import com.microservices.spring.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    LibraryRepository libraryRepository;

    public LibraryEntry publishPaper() {
        return null;
    }

    public List<LibraryEntry> getAllEntries() {
        return libraryRepository.findAll();
    }

    public void saveEntry(LibraryEntryDto data) {
        LibraryEntry newEntry = new LibraryEntry(data);
        libraryRepository.save(newEntry);
    }
}
