package br.com.unifei.projetoclinica.services;

import br.com.unifei.projetoclinica.dto.request.SchedulingRequest;
import br.com.unifei.projetoclinica.dto.response.SchedulingResponse;
import br.com.unifei.projetoclinica.dto.response.UpdateSchedulingResponse;
import br.com.unifei.projetoclinica.enums.SchedulingStatus;
import br.com.unifei.projetoclinica.exceptions.NotFoundException;
import br.com.unifei.projetoclinica.mappers.SchedulingMapper;
import br.com.unifei.projetoclinica.repositories.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchedulingService {

  @Autowired private PatientRepository patientRepository;
  @Autowired private VeterinarianRepository veterinarianRepository;
  @Autowired private SchedulingRepository schedulingRepository;

  @Autowired private SchedulingMapper schedulingMapper;

  public void createScheduling(
          SchedulingRequest request, String vetId, String patientId) {

    var veterinarian =
        veterinarianRepository
            .findById(vetId)
            .orElseThrow(
                () ->
                    new NotFoundException("Veterinarian not found."));

    var patient =
        patientRepository
            .findById(patientId)
            .orElseThrow(
                () ->
                    new NotFoundException("Patient not found."));

    var schedulingEntity = schedulingMapper.mapSchedulingRequestToSchedulingEntity(request);
    schedulingEntity.setVeterinarian(veterinarian);
    schedulingEntity.setPatient(patient);

    schedulingRepository.save(schedulingEntity);
  }

  public UpdateSchedulingResponse updateSchedulingStatus(SchedulingStatus status, String schedulingId){
    var scheduling = schedulingRepository.findById(schedulingId).orElseThrow(
            () -> new NotFoundException("Scheduling not found."));

    scheduling.setStatus(status);

    var updatedScheduling = schedulingRepository.save(scheduling);

    return schedulingMapper.mapSchedulingEntityToSchedulingResponse(updatedScheduling);
  }

  public List<SchedulingResponse> getAllScheduling() {

    return schedulingMapper.mapSchedulingEntityToSchedulingResponse(schedulingRepository.findAll());
  }
}
