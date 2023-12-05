package br.com.unifei.projetoclinica.services;

import br.com.unifei.projetoclinica.dto.request.PatientRequest;
import br.com.unifei.projetoclinica.dto.response.PatientResponse;
import br.com.unifei.projetoclinica.exceptions.NotFoundException;
import br.com.unifei.projetoclinica.mappers.PatientMapper;
import br.com.unifei.projetoclinica.repositories.ClinicRepository;
import br.com.unifei.projetoclinica.repositories.GuardianRepository;
import br.com.unifei.projetoclinica.repositories.PatientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PatientService {

  @Autowired private PatientRepository patientRepository;
  @Autowired private ClinicRepository clinicRepository;
  @Autowired private GuardianRepository guardianRepository;

  @Autowired private PatientMapper patientMapper;

  public void createPatient(
      PatientRequest request, MultipartFile file, String clinicId, String guardianId) {

    var clinic =
        clinicRepository
            .findById(clinicId)
            .orElseThrow(
                () ->
                    new NotFoundException("Clinic not found."));

    var guardian =
        guardianRepository
            .findById(guardianId)
            .orElseThrow(
                () ->
                    new NotFoundException("Guardian not found."));

    var patientEntity = patientMapper.mapPatientRequestToPatientEntity(request);
    patientEntity.setClinic(clinic);
    patientEntity.setGuardian(guardian);
    //// TODO: 11/15/2023 save image on S3 and create an url to send to front

    patientRepository.save(patientEntity);
  }

  public List<PatientResponse> getAllPatients() {

    return patientMapper.mapPatientEntityToPatientResponse(patientRepository.findAll());
  }
}
