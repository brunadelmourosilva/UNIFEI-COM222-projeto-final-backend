package br.com.unifei.projetoclinica.dto.request;

import br.com.unifei.projetoclinica.enums.SchedulingStatus;

/** https://medium.com/experiencecode/usando-records-em-java-9afecf7495b3 */
public record UpdateSchedulingRequest(SchedulingStatus status) {}
