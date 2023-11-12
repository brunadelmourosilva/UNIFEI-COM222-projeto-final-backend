package br.com.unifei.projetoclinica.controllers;

import br.com.unifei.projetoclinica.dto.request.VeterinarianRequest;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veterinarians")
public class VeterinarianController {

  @PostMapping("/clinic/{clinicId}")
  public ResponseEntity<Void> createVeterinarian(
      @RequestBody VeterinarianRequest veterinarianRequest, @PathVariable String clinicId) {

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Object>> getAllVeterinarians() {

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
