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

import com.mssecurity.mssecurity.Models.*;
import com.mssecurity.mssecurity.Repositories.*;

/**
 * UserControlle
 */
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserControlle {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleRepository roleRepository;

  @GetMapping("")
  public List<User> index() {
    return this.userRepository.findAll();
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("")
  public User store(@RequestBody User newUser) {
    return this.userRepository.save(newUser);
  }

  @GetMapping("{id}")
  public User show(@PathVariable String id) {
    User user = this.userRepository.findById(id).orElse(null);
    return user;
  }

  @PutMapping("{id}")
  public User update(@PathVariable String id, @RequestBody User newUser) {
    User current = this.userRepository
        .findById(id)
        .orElse(null);
    if (current != null) {
      current.setName(newUser.getName());
      current.setEmail(newUser.getEmail());
      current.setPassword(newUser.getPassword());
      return this.userRepository.save(current);
    } else {
      return null;
    }
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("{id}")
  public void destroy(@PathVariable String id) {
    User theUser = this.userRepository
        .findById(id)
        .orElse(null);
    if (theUser != null) {
      this.userRepository.delete(theUser);

    }
  }

  @PutMapping("{user_id}/role/{role_id}")
  public User match(@PathVariable String user_id, @PathVariable String role_id) {
    User current = this.userRepository.findById(user_id).orElse(null);
    Role role = this.roleRepository.findById(role_id).orElse(null);
    if (current != null && role != null) {
      current.setRole(role);
      return this.userRepository.save(current);
    } else {
      return null;
    }
  }

  @PutMapping("{user_id}/role/")
  public User match(@PathVariable String user_id) {
    User current = this.userRepository.findById(user_id).orElse(null);
    if (current != null) {
      current.setRole(null);
      return this.userRepository.save(current);
    } else {
      return null;
    }
  }

}