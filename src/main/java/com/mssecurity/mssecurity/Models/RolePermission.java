package com.mssecurity.mssecurity.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * RolePermission
 */
@Data
@Document()
public class RolePermission {

  @Id
  private String _id;
}