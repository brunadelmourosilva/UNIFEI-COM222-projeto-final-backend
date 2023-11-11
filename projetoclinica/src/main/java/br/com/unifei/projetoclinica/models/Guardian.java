package br.com.unifei.projetoclinica.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "GUARDIAN")
public class Guardian {

    @Column(name = "GUARDIAN_ID")
    @Id
    @UuidGenerator
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "ADDRESS")
    private String address;

    @OneToMany(mappedBy = "guardian")
    private List<Patient> patients = new ArrayList<>();
}
