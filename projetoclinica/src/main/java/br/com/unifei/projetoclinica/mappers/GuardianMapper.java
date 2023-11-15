package br.com.unifei.projetoclinica.mappers;

import br.com.unifei.projetoclinica.dto.request.GuardianRequest;
import br.com.unifei.projetoclinica.dto.response.GuardianResponse;
import br.com.unifei.projetoclinica.models.Guardian;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface GuardianMapper {

  Guardian mapGuardianRequestToGuardianEntity(GuardianRequest request);

  List<GuardianResponse> mapGuardianEntityToGuardianResponse(List<Guardian> guardians);
}
