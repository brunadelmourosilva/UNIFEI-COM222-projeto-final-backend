package br.com.unifei.projetoclinica.controllers;

import br.com.unifei.projetoclinica.dto.request.VeterinarianRequest;
import br.com.unifei.projetoclinica.dto.response.VeterinarianResponse;
import br.com.unifei.projetoclinica.services.VeterinarianService;
import java.util.List;
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
  public ResponseEntity<List<VeterinarianResponse>> getAllVeterinarians() {

    return new ResponseEntity<>(veterinarianService.getAllVeterinarians(), HttpStatus.OK);
  }
}
