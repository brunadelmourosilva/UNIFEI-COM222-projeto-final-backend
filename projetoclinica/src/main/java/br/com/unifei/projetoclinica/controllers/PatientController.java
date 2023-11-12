package br.com.unifei.projetoclinica.controllers;

import br.com.unifei.projetoclinica.dto.request.PatientRequest;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/patients")
public class PatientController {

  @PostMapping(
      value = "/clinic/{clinicId}/guardian/{guardianId}",
          consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}
     )
  public ResponseEntity<Void> createPatient(
      /** front: need to set content type as application/json for patientRequest */
      /** https://stackoverflow.com/questions/21329426/spring-mvc-multipart-request-with-json */
      @RequestPart PatientRequest patientRequest,
      @RequestPart MultipartFile file,
      @PathVariable String clinicId,
      @PathVariable String guardianId) {

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Object>> getAllPatients() {

    return new ResponseEntity<>(HttpStatus.OK);
  }
}