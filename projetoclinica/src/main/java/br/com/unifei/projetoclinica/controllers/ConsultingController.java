package br.com.unifei.projetoclinica.controllers;

import br.com.unifei.projetoclinica.dto.request.ConsultingRequest;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulting")
public class ConsultingController {

  @PostMapping("/veterinarian/{vetId}/patient/{patientId}")
  public ResponseEntity<Void> createConsulting(
      @PathVariable String vetId,
      @PathVariable String patientId,
      @RequestBody ConsultingRequest consultingRequest) {

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Object>> getAllConsulting() {

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
