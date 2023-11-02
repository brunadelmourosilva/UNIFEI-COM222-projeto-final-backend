package br.com.unifei.projetoclinica.model;

import lombok.Data;

@Data
public class Veterinarian {

    private Long id;
    private String name;
    private String phone;
    private String specialty;
}
