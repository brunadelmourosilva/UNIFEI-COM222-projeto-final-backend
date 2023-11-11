package br.com.unifei.projetoclinica.models;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CONSULTING")
public class Consulting {

    @Column(name = "CONSULTING_ID")
    @Id
    @UuidGenerator
    private String id;
    
    @Column(name = "APPOINTMENT_DATE")
    private OffsetDateTime appointmentDate;
    
    @Column(name = "DIAGNOSTIC")
    private String diagnostic;

    @Column(name = "PRESCRIPTION")
    private String prescription;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "VETERINARIAN_ID")
    private Veterinarian veterinarian;
}
