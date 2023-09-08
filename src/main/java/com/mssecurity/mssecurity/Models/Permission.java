package com.mssecurity.mssecurity.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * Permission
 */
@Data
@Document()
public class Permission {

  @Id
  private String _id;
  private String url;
  private String method;
  private String menuItems;

  public Permission(String url, String method, String menuItems) {
    this.url = url;
    this.method = method;
    this.menuItems = menuItems;
  }

  public String getUrl() {
    return this.url;
  }

  public String getMethod() {
    return this.method;
  }

  public String getMenuItems() {
    return this.menuItems;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public void setMenuItems(String menuItems) {
    this.menuItems = menuItems;
  }
}