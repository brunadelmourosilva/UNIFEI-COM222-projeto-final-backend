package br.com.unifei.projetoclinica.model;

import lombok.Data;

import java.util.Date;

@Data
public class Consulting {

    private Long id;
    private Date appointmentDate;
    private String diagnostic;
    private String prescription;
}
