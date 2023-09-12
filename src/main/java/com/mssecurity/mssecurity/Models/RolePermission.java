package com.mssecurity.mssecurity.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
  @DBRef
  private Role role;
  @DBRef
  Permission permission;

  public void setRole(Role role) {
    this.role = role;
  }

  public void setPermission(Permission permission) {
    this.permission = permission;
  }

  public Role getRole() {
    return this.role;
  }

  public Permission getPermission() {
    return this.permission;
  }

  public RolePermission(Role role, Permission permission) {
    this.role = role;
    this.permission = permission;
  }
}
