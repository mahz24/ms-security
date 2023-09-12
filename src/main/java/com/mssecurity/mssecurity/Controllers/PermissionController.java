package com.mssecurity.mssecurity.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mssecurity.mssecurity.Models.Permission;
import com.mssecurity.mssecurity.Repositories.PermissionRepository;

@CrossOrigin
@RestController
@RequestMapping("/permissions")
public class PermissionController {

  @Autowired
  private PermissionRepository permissionRepository;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("")
  public List<Permission> index() {
    return this.permissionRepository.findAll();
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("")
  public Permission store(@RequestBody Permission newPermission) {
    return this.permissionRepository.save(newPermission);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("{id}")
  public Permission show(@PathVariable String id) {
    Permission current = this.permissionRepository.findById(id).orElse(null);
    return current;
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping("{id}")
  public Permission update(@PathVariable String id, @RequestBody Permission newPermission) {
    Permission current = this.permissionRepository.findById(id).orElse(null);
    if (current != null) {
      current.setUrl(newPermission.getUrl());
      current.setMenuItems(newPermission.getMenuItems());
      current.setMethod(newPermission.getMethod());
      return current;
    } else {
      return null;
    }
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("{id}")
  public void delete(@PathVariable String id) {
    Permission current = this.permissionRepository.findById(id).orElse(null);
    if (current != null) {
      this.permissionRepository.delete(current);
    }
  }
}