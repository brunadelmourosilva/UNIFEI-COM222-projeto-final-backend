package br.com.unifei.projetoclinica.models;

import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;

@Data
public class Consulting {

    @Id
    @UuidGenerator
    private String id;
    private Date appointmentDate;
    private String diagnostic;
    private String prescription;
}
