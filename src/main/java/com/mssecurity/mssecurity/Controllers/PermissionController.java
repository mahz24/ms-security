package com.mssecurity.mssecurity.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

  @ResponseStatus(HttpStatus.FOUND)
  @GetMapping("")
  public List<Permission> index() {
    return this.permissionRepository.findAll();
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("")
  public Permission store(@RequestBody Permission newPermission) {
    return this.permissionRepository.save(newPermission);
  }

}