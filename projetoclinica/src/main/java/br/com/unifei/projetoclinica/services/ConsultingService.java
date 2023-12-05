package br.com.unifei.projetoclinica.services;

import br.com.unifei.projetoclinica.dto.request.ConsultingRequest;
import br.com.unifei.projetoclinica.dto.response.ConsultingResponse;
import br.com.unifei.projetoclinica.exceptions.NotFoundException;
import br.com.unifei.projetoclinica.mappers.ConsultingMapper;
import br.com.unifei.projetoclinica.repositories.ConsultingRepository;
import br.com.unifei.projetoclinica.repositories.PatientRepository;
import br.com.unifei.projetoclinica.repositories.VeterinarianRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultingService {

  @Autowired private VeterinarianRepository veterinarianRepository;
  @Autowired private PatientRepository patientRepository;
  @Autowired private ConsultingRepository consultingRepository;

  @Autowired private ConsultingMapper consultingMapper;

  public void createConsulting(ConsultingRequest request, String vetId, String patientId) {
    var veterinarian =
        veterinarianRepository
            .findById(vetId)
            .orElseThrow(
                () ->
                    new NotFoundException(
                        "Veterinarian not found."));

    var patient =
        patientRepository
            .findById(patientId)
            .orElseThrow(
                () ->
                    new NotFoundException(
                        "Patient not found."));

    var consultingEntity = consultingMapper.mapConsultingRequestToConsultingEntity(request);
    consultingEntity.setPatient(patient);
    consultingEntity.setVeterinarian(veterinarian);

    consultingRepository.save(consultingEntity);
  }

  public List<ConsultingResponse> getAllConsulting() {

    return consultingMapper.mapConsultingEntityToConsultingResponse(consultingRepository.findAll());
  }
}
