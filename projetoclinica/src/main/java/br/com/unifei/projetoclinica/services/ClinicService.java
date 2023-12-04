package br.com.unifei.projetoclinica.services;

import br.com.unifei.projetoclinica.dto.response.ClinicResponse;
import br.com.unifei.projetoclinica.mappers.ClinicMapper;
import br.com.unifei.projetoclinica.repositories.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicService {

  @Autowired private ClinicRepository clinicRepository;

  @Autowired private ClinicMapper clinicMapper;

  public List<ClinicResponse> getAllClinics() {

    return clinicMapper.map(clinicRepository.findAll());
  }
}
