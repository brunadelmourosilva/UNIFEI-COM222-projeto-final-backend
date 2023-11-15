package br.com.unifei.projetoclinica.mappers;

import br.com.unifei.projetoclinica.dto.request.SchedulingRequest;
import br.com.unifei.projetoclinica.dto.response.SchedulingResponse;
import br.com.unifei.projetoclinica.dto.response.UpdateSchedulingResponse;
import br.com.unifei.projetoclinica.models.Scheduling;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface SchedulingMapper {

  Scheduling mapSchedulingRequestToSchedulingEntity(SchedulingRequest request);

  UpdateSchedulingResponse mapSchedulingEntityToSchedulingResponse(Scheduling scheduling);

  List<SchedulingResponse> mapSchedulingEntityToSchedulingResponse(List<Scheduling> schedulings);
}
