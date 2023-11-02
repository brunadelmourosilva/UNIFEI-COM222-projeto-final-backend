package br.com.unifei.projetoclinica.models;

import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Data
public class Veterinarian {

    @Id
    @UuidGenerator
    private String id;
    private String name;
    private String phone;
    private String specialty;
}
