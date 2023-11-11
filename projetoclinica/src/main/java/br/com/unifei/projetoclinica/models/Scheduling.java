package br.com.unifei.projetoclinica.models;

import br.com.unifei.projetoclinica.enums.SchedulingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.OffsetDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "SCHEDULING")
public class Scheduling {

    @Column(name = "SCHEDULING_ID")
    @Id
    @UuidGenerator
    private String id;

    @Column(name = "APPOINTMENT_DATE")
    private OffsetDateTime appointmentDate;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private SchedulingStatus status;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "VETERINARIAN_ID")
    private Veterinarian veterinarian;
}
