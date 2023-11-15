package br.com.unifei.projetoclinica.mappers;

import br.com.unifei.projetoclinica.dto.request.VeterinarianRequest;
import br.com.unifei.projetoclinica.models.Clinic;
import br.com.unifei.projetoclinica.models.Veterinarian;
import org.mapstruct.Mapper;

@Mapper
public interface VeterinarianMapper {

  Veterinarian map(VeterinarianRequest request);
}
