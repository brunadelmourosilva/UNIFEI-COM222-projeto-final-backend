package br.com.unifei.projetoclinica.dto.request;

import java.time.OffsetDateTime;

/** https://medium.com/experiencecode/usando-records-em-java-9afecf7495b3 */
public record PatientRequest(
    String name, String breed, OffsetDateTime dateOfBirth, String additionalInfo) {}
