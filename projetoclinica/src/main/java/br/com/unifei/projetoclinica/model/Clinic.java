package br.com.unifei.projetoclinica.model;

import lombok.Data;

@Data
public class Clinic {

    private Long id;
    private String name;
    private String address;
    private String phone;
}
