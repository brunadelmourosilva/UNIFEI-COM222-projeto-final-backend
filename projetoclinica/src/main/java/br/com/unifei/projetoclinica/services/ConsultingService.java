package br.com.unifei.projetoclinica.services;

import br.com.unifei.projetoclinica.dto.request.ConsultingRequest;
import br.com.unifei.projetoclinica.dto.response.ConsultingResponse;
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

  // TODO: 11/14/2023 talvez criar interfaces para as assinaturas dos métodos
  public void createConsulting(ConsultingRequest request, String vetId, String patientId) {
    var veterinarian =
        veterinarianRepository
            .findById(vetId)
            .orElseThrow(
                () ->
                    new RuntimeException(
                        "Veterinarian not found.")); // // TODO: 11/14/2023 replace to BR

    var patient =
        patientRepository
            .findById(patientId)
            .orElseThrow(
                () ->
                    new RuntimeException(
                        "Patient not found.")); // // TODO: 11/14/2023 replace to BR

    var consultingEntity = consultingMapper.mapConsultingRequestToConsultingEntity(request);
    consultingEntity.setPatient(patient);
    consultingEntity.setVeterinarian(veterinarian);

    consultingRepository.save(consultingEntity);
  }

  public List<ConsultingResponse> getAllConsulting() {

    return consultingMapper.mapConsultingEntityToConsultingResponse(consultingRepository.findAll());
  }
}
