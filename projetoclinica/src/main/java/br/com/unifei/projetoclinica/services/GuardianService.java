package br.com.unifei.projetoclinica.services;

import br.com.unifei.projetoclinica.dto.request.GuardianRequest;
import br.com.unifei.projetoclinica.dto.response.GuardianResponse;
import br.com.unifei.projetoclinica.mappers.GuardianMapper;
import br.com.unifei.projetoclinica.repositories.GuardianRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuardianService {

  @Autowired private GuardianRepository guardianRepository;

  @Autowired private GuardianMapper guardianMapper;

  public void createGuardian(GuardianRequest request) {
    checkUniqueGuardianEmail(request.email());

    var guardianEntity = guardianMapper.mapGuardianRequestToGuardianEntity(request);

    guardianRepository.save(guardianEntity);
  }

  private void checkUniqueGuardianEmail(String requestEmail) {
    var isUniqueEmail = guardianRepository.findByEmail(requestEmail);

    if (isUniqueEmail.isPresent()) {
      throw new RuntimeException("Email already exists!");
    }
  }

  public List<GuardianResponse> getAllGuardians() {

    return guardianMapper.mapGuardianEntityToGuardianResponse(guardianRepository.findAll());
  }
}
