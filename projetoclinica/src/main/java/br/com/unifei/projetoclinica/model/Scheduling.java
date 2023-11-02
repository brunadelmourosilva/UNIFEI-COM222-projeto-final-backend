package br.com.unifei.projetoclinica.model;

import lombok.Data;

import java.util.Date;

@Data
public class Scheduling {

    private Long id;
    private Date appointmentDate;
    private String status; //// TODO: 11/2/2023 enum
}
