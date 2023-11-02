package br.com.unifei.projetoclinica.model;

import lombok.Data;

@Data
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String creationDate; //// TODO: 11/2/2023
    //// TODO: 11/2/2023 role(clinic, vet, owner)?
}
