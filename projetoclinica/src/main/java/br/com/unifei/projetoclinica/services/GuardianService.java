package br.com.unifei.projetoclinica.services;

import br.com.unifei.projetoclinica.dto.request.GuardianRequest;
import br.com.unifei.projetoclinica.dto.response.GuardianResponse;
import br.com.unifei.projetoclinica.mappers.GuardianMapper;
import br.com.unifei.projetoclinica.models.Guardian;
import br.com.unifei.projetoclinica.repositories.GuardianRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuardianService {

  @Autowired private GuardianRepository guardianRepository;

  @Autowired private GuardianMapper guardianMapper;

  public void createGuardian(GuardianRequest request) {

    var guardians = guardianRepository.findAll();

    for (var guardian : guardians) {
      var isUniqueEmail = checkUniqueGuardianEmail(guardian.getEmail(), request.email());

      if(!isUniqueEmail) {
        throw new RuntimeException("Email already exists!");
      }
    }

    var guardianEntity = guardianMapper.mapGuardianRequestToGuardianEntity(request);

    guardianRepository.save(guardianEntity);
  }

  private boolean checkUniqueGuardianEmail(String savedEmail, String requestEmail) {
     return !savedEmail.equals(requestEmail);
  }

  public List<GuardianResponse> getAllGuardians() {

    return guardianMapper.mapGuardianEntityToGuardianResponse(guardianRepository.findAll());
  }
}
