package br.com.unifei.projetoclinica.controllers;

import br.com.unifei.projetoclinica.dto.request.ConsultingRequest;
import br.com.unifei.projetoclinica.dto.response.ConsultingResponse;
import br.com.unifei.projetoclinica.services.ConsultingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulting")
public class ConsultingController {

  @Autowired private ConsultingService consultingService;

  @PostMapping("/veterinarian/{vetId}/patient/{patientId}")
  public ResponseEntity<Void> createConsulting(
      @PathVariable String vetId,
      @PathVariable String patientId,
      @RequestBody ConsultingRequest consultingRequest) {

    consultingService.createConsulting(consultingRequest, vetId, patientId);

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<ConsultingResponse>> getAllConsulting() {

    return new ResponseEntity<>(consultingService.getAllConsulting(), HttpStatus.OK);
  }
}
