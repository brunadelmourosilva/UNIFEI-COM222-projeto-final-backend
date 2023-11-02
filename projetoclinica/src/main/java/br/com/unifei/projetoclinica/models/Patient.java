package br.com.unifei.projetoclinica.models;

import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;

@Data
public class Patient {

    @Id
    @UuidGenerator
    private String id;
    private String name;
    private String breed;
    private String phone;
    private Date dateOfBirth;
    private String additionalInfo;
}
