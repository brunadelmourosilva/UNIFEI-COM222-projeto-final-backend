package br.com.unifei.projetoclinica.controllers;

import br.com.unifei.projetoclinica.dto.request.VeterinarianRequest;
import java.util.List;

import br.com.unifei.projetoclinica.services.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veterinarians")
public class VeterinarianController {

  @Autowired
  private VeterinarianService veterinarianService;

  @PostMapping("/clinic/{clinicId}")
  public ResponseEntity<Void> createVeterinarian(
      @RequestBody VeterinarianRequest veterinarianRequest, @PathVariable String clinicId) {

    veterinarianService.createVeterinarian(veterinarianRequest, clinicId);

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Object>> getAllVeterinarians() {

    //// TODO: 11/14/2023 retornar vet e clinica

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
