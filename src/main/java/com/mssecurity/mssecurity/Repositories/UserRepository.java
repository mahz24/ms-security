package com.mssecurity.mssecurity.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mssecurity.mssecurity.Models.User;

/**
 * UserRepository
 */
public interface UserRepository extends MongoRepository<User, String> {

}