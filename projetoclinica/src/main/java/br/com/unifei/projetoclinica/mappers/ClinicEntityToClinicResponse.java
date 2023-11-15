package br.com.unifei.projetoclinica.mappers;

import br.com.unifei.projetoclinica.dto.response.ClinicResponse;
import br.com.unifei.projetoclinica.models.Clinic;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ClinicEntityToClinicResponse {

  List<ClinicResponse> map(List<Clinic> clinic);
}
