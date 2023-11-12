package br.com.unifei.projetoclinica.controllers;

import br.com.unifei.projetoclinica.dto.request.VeterinarianRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarians")
public class VeterinarianController {

    @PostMapping
    public ResponseEntity<Void> createVeterinarian(@RequestBody VeterinarianRequest veterinarianRequest) {

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAllVeterinarians() {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
