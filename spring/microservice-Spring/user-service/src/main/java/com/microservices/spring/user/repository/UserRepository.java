package com.microservices.spring.user.repository;

import com.microservices.spring.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
