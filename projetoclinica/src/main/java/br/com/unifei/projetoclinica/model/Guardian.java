package br.com.unifei.projetoclinica.model;

import lombok.Data;

@Data
public class Guardian {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
