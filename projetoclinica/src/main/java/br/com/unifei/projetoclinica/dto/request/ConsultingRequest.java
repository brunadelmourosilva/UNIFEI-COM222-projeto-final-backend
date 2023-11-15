package br.com.unifei.projetoclinica.dto.request;


import java.time.OffsetDateTime;

/** https://medium.com/experiencecode/usando-records-em-java-9afecf7495b3 */
public record ConsultingRequest(OffsetDateTime appointmentDate, String diagnostic, String prescription) {}
