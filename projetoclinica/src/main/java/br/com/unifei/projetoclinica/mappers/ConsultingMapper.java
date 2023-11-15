package br.com.unifei.projetoclinica.mappers;

import br.com.unifei.projetoclinica.dto.request.ConsultingRequest;
import br.com.unifei.projetoclinica.dto.response.ConsultingResponse;
import br.com.unifei.projetoclinica.models.Consulting;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface ConsultingMapper {

  Consulting mapConsultingRequestToConsultingEntity(ConsultingRequest request);

  List<ConsultingResponse> mapConsultingEntityToConsultingResponse(List<Consulting> consultings);
}
