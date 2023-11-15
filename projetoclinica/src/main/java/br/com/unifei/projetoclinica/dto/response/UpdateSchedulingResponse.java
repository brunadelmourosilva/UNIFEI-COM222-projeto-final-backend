package br.com.unifei.projetoclinica.dto.response;

import br.com.unifei.projetoclinica.enums.SchedulingStatus;
import java.time.OffsetDateTime;

public record UpdateSchedulingResponse(String id, SchedulingStatus status) {}
