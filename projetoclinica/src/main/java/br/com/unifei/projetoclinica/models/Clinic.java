package br.com.unifei.projetoclinica.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "CLINIC")
public class Clinic {

    @Id
    @UuidGenerator
    private String id;
    private String name;
    private String address;
    private String phone;

    @OneToMany(mappedBy = "clinic")
    private List<User> users = new ArrayList<>();
}
