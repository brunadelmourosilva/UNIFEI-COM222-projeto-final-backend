package br.com.unifei.projetoclinica.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Data
@Table(name = "CLINIC")
public class Clinic {

    @Column(name = "CLINIC_ID")
    @Id
    @UuidGenerator
    private String id;
    private String name;
    private String address;
    private String phone;

    @OneToMany(mappedBy = "clinic")
    private List<User> users;
}
