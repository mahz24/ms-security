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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mssecurity.mssecurity.Repositories.RolePermissionRepository;

import com.mssecurity.mssecurity.Repositories.RoleRepository;
import com.mssecurity.mssecurity.Models.Permission;
import com.mssecurity.mssecurity.Models.Role;
import com.mssecurity.mssecurity.Models.RolePermission;
import com.mssecurity.mssecurity.Repositories.PermissionRepository;

@CrossOrigin
@RestController
@RequestMapping("/role-permissions")
public class RolePermissionController {

  @Autowired
  private RolePermissionRepository rolePermissionRepository;

  @Autowired
  RoleRepository RoleRepository;

  @Autowired
  PermissionRepository permissionRepository;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("")
  public List<RolePermission> index() {
    return this.rolePermissionRepository.findAll();
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/role/{role_id}/permission/{permission_id}")
  public RolePermission store(@PathVariable String role_id, @PathVariable String permission_id) {
    Role role = this.RoleRepository.findById(role_id).orElse(null);
    Permission permission = this.permissionRepository.findById(permission_id).orElse(null);
    if (role != null && permission != null) {
      RolePermission created = new RolePermission(role, permission);
      return this.rolePermissionRepository.save(created);
    } else {
      return null;
    }
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("{id}")
  public RolePermission show(@PathVariable String id) {
    RolePermission current = this.rolePermissionRepository.findById(id).orElse(null);
    return current;
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping("{id}/role/{role_id}/permission/{permission_id}")
  public RolePermission udpate(@PathVariable String id, @PathVariable String role_id,
      @PathVariable String permission_id) {
    RolePermission current = this.rolePermissionRepository.findById(id).orElse(null);
    Role role = this.RoleRepository.findById(role_id).orElse(null);
    Permission permission = this.permissionRepository.findById(permission_id).orElse(null);
    if (current != null && role != null && permission != null) {
      current.setPermission(permission);
      current.setRole(role);
      return this.rolePermissionRepository.save(current);
    } else {
      return null;
    }
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("{id}")
  public void destroy(@PathVariable String id) {
    RolePermission current = this.rolePermissionRepository.findById(id).orElse(null);
    if (current != null) {
      this.rolePermissionRepository.delete(current);
    }
  }

}