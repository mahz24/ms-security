package com.mssecurity.mssecurity.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mssecurity.mssecurity.Models.Permission;

/**
 * PermissionRepository
 */
public interface PermissionRepository extends MongoRepository<Permission, String> {

}