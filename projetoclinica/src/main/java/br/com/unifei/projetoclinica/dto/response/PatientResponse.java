package br.com.unifei.projetoclinica.dto.response;

import java.time.OffsetDateTime;

public record PatientResponse(
    String id,
    String name,
    String breed,
    String imageUrl,
    OffsetDateTime dateOfBirth,
    String additionalInfo) {}
