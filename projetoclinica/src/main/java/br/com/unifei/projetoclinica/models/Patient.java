package br.com.unifei.projetoclinica.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PATIENT")
public class Patient {

    @Column(name = "PATIENT_ID")
    @Id
    @UuidGenerator
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BREED")
    private String breed;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name = "ADDITIONAL_INFO")
    private String additionalInfo;

    @ManyToOne
    @JoinColumn(name = "CLINIC_ID")
    private Clinic clinic;

    @ManyToOne
    @JoinColumn(name = "GUARDIAN_ID")
    private Guardian guardian;
}
