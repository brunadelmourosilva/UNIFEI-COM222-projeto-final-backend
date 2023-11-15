package br.com.unifei.projetoclinica.dto.request;

import br.com.unifei.projetoclinica.enums.SchedulingStatus;

import java.time.OffsetDateTime;

/** https://medium.com/experiencecode/usando-records-em-java-9afecf7495b3 */
public record SchedulingRequest(OffsetDateTime appointmentDate, SchedulingStatus status) {}
