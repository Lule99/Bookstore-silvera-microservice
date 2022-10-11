package com.microservices.spring.sci.paper.repository;

import com.microservices.spring.sci.paper.model.SciPaper;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SciPaperRepository extends MongoRepository<SciPaper, String> {
}
