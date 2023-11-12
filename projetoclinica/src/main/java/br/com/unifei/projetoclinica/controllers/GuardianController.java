package br.com.unifei.projetoclinica.controllers;

import br.com.unifei.projetoclinica.dto.request.GuardianRequest;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guardians")
public class GuardianController {

  @PostMapping
  public ResponseEntity<Void> createGuardian(@RequestBody GuardianRequest guardianRequest) {

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Object>> getAllGuardians() {

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
