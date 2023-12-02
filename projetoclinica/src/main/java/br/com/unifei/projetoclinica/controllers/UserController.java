package br.com.unifei.projetoclinica.controllers;

import java.util.List;

import br.com.unifei.projetoclinica.dto.request.UserLoginRequest;
import br.com.unifei.projetoclinica.dto.request.UserRequest;
import br.com.unifei.projetoclinica.dto.request.UpdateUserRequest;
import br.com.unifei.projetoclinica.models.User;
import br.com.unifei.projetoclinica.repositories.ClinicRepository;
import br.com.unifei.projetoclinica.repositories.RoleRepository;
import br.com.unifei.projetoclinica.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ClinicRepository clinicRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @PostMapping("/clinic/{clinicId}")
  public ResponseEntity<?> createUser(
      @PathVariable String clinicId, @RequestBody UserRequest userRequest) {

    if(userRepository.findByEmail(userRequest.email()).isPresent()){
      return new ResponseEntity<>("User already exists.", HttpStatus.BAD_REQUEST);
    }

    var clinic = clinicRepository.findById(clinicId);
    if(clinic.isEmpty()){
      return new ResponseEntity<>("Clinic not found.", HttpStatus.BAD_REQUEST);
    }

    var user = User.builder()
            .name(userRequest.name())
            .email(userRequest.email())
            .password(passwordEncoder.encode(userRequest.password()))
            .clinic(clinic.get())
            .build();

    var roles = roleRepository.findByRoleName("ROLE_ADMIN").get();
    user.setRoles(List.of(roles));

    userRepository.save(user);

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
  public ResponseEntity<Void> updateUser(
      @PathVariable String userId, @RequestBody UpdateUserRequest userUpdateRequest) {

    //// TODO: 30/11/2023

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/{userId}")
  public ResponseEntity<Void> deleteUser(@PathVariable String userId) {

    //// TODO: 30/11/2023

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping
  public ResponseEntity<List<Object>> getAllUsers() {

    //// TODO: 30/11/2023

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
