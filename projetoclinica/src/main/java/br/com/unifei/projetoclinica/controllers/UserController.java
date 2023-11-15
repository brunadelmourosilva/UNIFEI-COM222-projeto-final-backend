package br.com.unifei.projetoclinica.controllers;

import java.util.List;

import br.com.unifei.projetoclinica.dto.request.UserLoginRequest;
import br.com.unifei.projetoclinica.dto.request.UserRequest;
import br.com.unifei.projetoclinica.dto.request.UpdateUserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

  @PostMapping("/clinic/{clinicId}")
  public ResponseEntity<Void> createUser(
      @PathVariable String clinicId, @RequestBody UserRequest userRequest) {

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PostMapping("/login")
  public ResponseEntity<Void> login(@RequestBody UserLoginRequest userLoginRequest) {

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping("/{userId}")
  public ResponseEntity<Void> updateUser(
      @PathVariable String userId, @RequestBody UpdateUserRequest userUpdateRequest) {

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/{userId}")
  public ResponseEntity<Void> deleteUser(@PathVariable String userId) {

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping
  public ResponseEntity<List<Object>> getAllUsers() {

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
