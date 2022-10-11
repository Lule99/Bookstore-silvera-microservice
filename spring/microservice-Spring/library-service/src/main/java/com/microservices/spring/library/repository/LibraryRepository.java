package com.microservices.spring.library.repository;

import com.microservices.spring.library.model.LibraryEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibraryRepository extends MongoRepository<LibraryEntry, String> {
}
