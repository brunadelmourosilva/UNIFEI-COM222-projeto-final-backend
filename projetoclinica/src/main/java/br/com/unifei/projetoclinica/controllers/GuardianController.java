package br.com.unifei.projetoclinica.controllers;

import br.com.unifei.projetoclinica.dto.request.GuardianRequest;
import br.com.unifei.projetoclinica.dto.response.GuardianResponse;
import br.com.unifei.projetoclinica.services.GuardianService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guardians")
public class GuardianController {

  @Autowired private GuardianService guardianService;

  @PostMapping
  public ResponseEntity<Void> createGuardian(@RequestBody GuardianRequest guardianRequest) {

    guardianService.createGuardian(guardianRequest);

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<GuardianResponse>> getAllGuardians() {

    return new ResponseEntity<>(guardianService.getAllGuardians(), HttpStatus.OK);
  }
}
