package br.com.unifei.projetoclinica.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "USERS")
public class User {

    @Column(name = "USER_ID")
    @Id
    @UuidGenerator
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "CREATION_DATE")
    private String creationDate; //// TODO: 11/2/2023

    //// TODO: 11/2/2023 role(clinic, vet, owner)?

    @ManyToOne
    @JoinColumn(name = "CLINIC_ID")
    private Clinic clinic;
}
