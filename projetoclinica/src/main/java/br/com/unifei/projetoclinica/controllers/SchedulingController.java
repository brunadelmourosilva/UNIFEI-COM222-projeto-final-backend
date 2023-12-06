package br.com.unifei.projetoclinica.controllers;

import br.com.unifei.projetoclinica.dto.request.SchedulingRequest;
import br.com.unifei.projetoclinica.dto.request.UpdateSchedulingRequest;
import br.com.unifei.projetoclinica.dto.response.SchedulingResponse;
import br.com.unifei.projetoclinica.dto.response.UpdateSchedulingResponse;
import br.com.unifei.projetoclinica.enums.SchedulingStatus;
import br.com.unifei.projetoclinica.services.SchedulingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scheduling")
public class SchedulingController {

  @Autowired private SchedulingService schedulingService;

  @PostMapping("/veterinarian/{vetId}/patient/{patientId}")
  public ResponseEntity<Void> createScheduling(
      @PathVariable String vetId,
      @PathVariable String patientId,
      @RequestBody SchedulingRequest schedulingRequest) {

    schedulingService.createScheduling(schedulingRequest, vetId, patientId);

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping("/{schedulingId}")
  public ResponseEntity<UpdateSchedulingResponse> updateSchedulingStatus(
          @PathVariable String schedulingId, @RequestParam SchedulingStatus status) {

    return new ResponseEntity<>(
        schedulingService.updateSchedulingStatus(status, schedulingId), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<SchedulingResponse>> getAllScheduling() {

    return new ResponseEntity<>(schedulingService.getAllScheduling(), HttpStatus.OK);
  }
}
