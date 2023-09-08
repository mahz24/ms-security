package com.mssecurity.mssecurity.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mssecurity.mssecurity.Models.RolePermission;

/**
 * RolePermissionRepository
 */
public interface RolePermissionRepository extends MongoRepository<RolePermission, String> {

}