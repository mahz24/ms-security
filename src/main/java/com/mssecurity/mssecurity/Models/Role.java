package com.mssecurity.mssecurity.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * Role
 */
@Data
@Document()
public class Role {

  @Id
  private String _id;
  private String name;
  private String description;

  public Role(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}