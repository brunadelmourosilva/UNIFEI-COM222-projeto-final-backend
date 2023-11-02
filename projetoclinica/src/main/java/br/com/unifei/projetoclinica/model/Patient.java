package br.com.unifei.projetoclinica.model;

import lombok.Data;

import java.util.Date;

@Data
public class Patient {

    private Long id;
    private String name;
    private String breed;
    private String phone;
    private Date dateOfBirth;
    private String additionalInfo;
}
