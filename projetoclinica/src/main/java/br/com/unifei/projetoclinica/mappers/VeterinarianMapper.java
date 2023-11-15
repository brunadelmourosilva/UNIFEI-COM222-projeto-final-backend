package br.com.unifei.projetoclinica.mappers;

import br.com.unifei.projetoclinica.dto.request.VeterinarianRequest;
import br.com.unifei.projetoclinica.dto.response.VeterinarianResponse;
import br.com.unifei.projetoclinica.models.Veterinarian;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface VeterinarianMapper {

  Veterinarian mapVeterinarianRequestToVeterinarianEntity(VeterinarianRequest request);

  List<VeterinarianResponse> mapVeterinarianEntityToVeterinarianResponse(
      List<Veterinarian> veterinarian);
}
