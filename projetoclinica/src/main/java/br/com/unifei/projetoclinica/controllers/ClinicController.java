package br.com.unifei.projetoclinica.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clinics")
public class ClinicController {

  @GetMapping
  public ResponseEntity<List<Object>> getAllClinics() {

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
