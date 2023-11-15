package br.com.unifei.projetoclinica.dto.response;

import java.time.OffsetDateTime;

public record ConsultingResponse(
    String id, OffsetDateTime appointmentDate, String diagnostic, String prescription) {}
