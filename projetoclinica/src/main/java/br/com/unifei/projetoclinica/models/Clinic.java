package br.com.unifei.projetoclinica.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
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
