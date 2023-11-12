package br.com.unifei.projetoclinica.controllers;

import br.com.unifei.projetoclinica.dto.request.SchedulingRequest;
import java.util.List;

import br.com.unifei.projetoclinica.dto.request.UpdateSchedulingRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scheduling")
public class SchedulingController {

  @PostMapping("/veterinarian/{vetId}/patient/{patientId}")
  public ResponseEntity<Void> createScheduling(
      @PathVariable String vetId,
      @PathVariable String patientId,
      @RequestBody SchedulingRequest schedulingRequest) {

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  // TODO: 11/12/2023 return scheduling updated
  @PutMapping("/{schedulingId}")
  public ResponseEntity<Object> updateSchedulingStatus(
      @PathVariable String schedulingId, @RequestBody UpdateSchedulingRequest schedulingRequest) {

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Object>> getAllScheduling() {

    return new ResponseEntity<>(HttpStatus.OK);
  }

  //// TODO: 11/12/2023 maybe filter scheduling by patient name
}
