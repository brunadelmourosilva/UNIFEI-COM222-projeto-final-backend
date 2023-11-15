package br.com.unifei.projetoclinica.mappers;

import br.com.unifei.projetoclinica.dto.request.PatientRequest;
import br.com.unifei.projetoclinica.dto.response.PatientResponse;
import br.com.unifei.projetoclinica.models.Patient;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface PatientMapper {

  Patient mapPatientRequestToPatientEntity(PatientRequest request);

  List<PatientResponse> mapPatientEntityToPatientResponse(
      List<Patient> patients);
}
