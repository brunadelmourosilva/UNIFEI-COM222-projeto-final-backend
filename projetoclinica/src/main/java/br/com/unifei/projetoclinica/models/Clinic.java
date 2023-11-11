package br.com.unifei.projetoclinica.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CLINIC")
public class Clinic {

    @Column(name = "CLINIC_ID")
    @Id
    @UuidGenerator
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE")
    private String phone;

    @OneToMany(mappedBy = "clinic")
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "clinic")
    private List<Veterinarian> veterinarians = new ArrayList<>();

    @OneToMany(mappedBy = "clinic")
    private List<Patient> patients = new ArrayList<>();
}
