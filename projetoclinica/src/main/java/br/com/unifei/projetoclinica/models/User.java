package br.com.unifei.projetoclinica.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
@Table(name = "USERS")
public class User {

    //@Column todo for all classes
    @Column(name = "USER_ID")
    @Id
    @UuidGenerator
    private String id;
    private String name;
    private String email;
    private String password;
    private String creationDate; //// TODO: 11/2/2023
    //// TODO: 11/2/2023 role(clinic, vet, owner)?

    @ManyToOne
    @JoinColumn(name = "CLINIC_ID")
    private Clinic clinic; //// TODO: 11/2/2023 terminar outros relacionamentos
}
