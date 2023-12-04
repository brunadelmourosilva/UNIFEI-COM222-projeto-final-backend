package br.com.unifei.projetoclinica.controllers;

import java.util.List;

import br.com.unifei.projetoclinica.dto.request.UserLoginRequest;
import br.com.unifei.projetoclinica.dto.request.UserRequest;
import br.com.unifei.projetoclinica.dto.request.UpdateUserRequest;
import br.com.unifei.projetoclinica.dto.response.UpdateUserResponse;
import br.com.unifei.projetoclinica.models.User;
import br.com.unifei.projetoclinica.repositories.ClinicRepository;
import br.com.unifei.projetoclinica.repositories.RoleRepository;
import br.com.unifei.projetoclinica.repositories.UserRepository;
import br.com.unifei.projetoclinica.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/clinic/{clinicId}")
  public ResponseEntity<?> createUser(
      @PathVariable String clinicId, @RequestBody UserRequest userRequest) {

    userService.createUser(userRequest, clinicId);
    return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
  }

  /* Using the default login endpoint from Spring Security */
  /* localhost:8080/login */
//  @PostMapping("/login")
//  public ResponseEntity<Void> login(@RequestBody UserLoginRequest userLoginRequest) {
//
//    return new ResponseEntity<>(HttpStatus.OK);
//  }

  @PutMapping("/{userId}")
  public ResponseEntity<UpdateUserResponse> updateUser(
      @PathVariable String userId, @RequestBody UpdateUserRequest userUpdateRequest) {

    return new ResponseEntity<>(userService.updateUser(userUpdateRequest, userId), HttpStatus.OK);
  }

  @DeleteMapping("/{userId}")
  public ResponseEntity<Void> deleteUser(@PathVariable String userId) {

    userService.deleteUser(userId);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping
  public ResponseEntity<List<UpdateUserResponse>> getAllUsers() {

    return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
  }
}
