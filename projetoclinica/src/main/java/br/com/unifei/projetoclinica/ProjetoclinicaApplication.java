package br.com.unifei.projetoclinica;

import br.com.unifei.projetoclinica.models.*;
import br.com.unifei.projetoclinica.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProjetoclinicaApplication implements CommandLineRunner {

  @Autowired ClinicRepository clinicRepository;

  @Autowired UserRepository userRepository;

  @Autowired VeterinarianRepository veterinarianRepository;

  @Autowired PatientRepository patientRepository;

  @Autowired GuardianRepository guardianRepository;

  @Autowired SchedulingRepository schedulingRepository;

  @Autowired ConsultingRepository consultingRepository;

  public static void main(String[] args) {
    SpringApplication.run(ProjetoclinicaApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    //// TODO: 11/11/2023 password
    Clinic clinic =
        Clinic.builder().name("UniVet").phone("359998751").address("Rua D. A. Chaves, 315").build();

    clinicRepository.save(clinic);

    User user = User.builder().name("Márcia").email("marcia@gmail.com").clinic(clinic).build();

    // relationship is bidirectional and JPA/Hibernate can manage the relationship based on the
    // annotation
    // is not required, but it can be helpful for comprehension
    // clinic.getUsers().add(user);

    userRepository.save(user);

    // ----------------------

    Veterinarian veterinarian =
        Veterinarian.builder().name("Júlia").specialty("Dogs").clinic(clinic).build();

    veterinarianRepository.save(veterinarian);

    // ----------------------

    Guardian guardian = Guardian.builder().name("Bruna").email("bruna@gmail.com").build();

    guardianRepository.save(guardian);

    // ----------------------

    Patient patient =
        Patient.builder()
            .name("Spike")
            .breed("Mixed")
            .imageUrl("S3_URL")
            .clinic(clinic)
            .guardian(guardian)
            .build();

    patientRepository.save(patient);

    // ----------------------

    Scheduling scheduling =
        Scheduling.builder().patient(patient).veterinarian(veterinarian).build();

    schedulingRepository.save(scheduling);

    // ----------------------

    Consulting consulting =
        Consulting.builder().patient(patient).veterinarian(veterinarian).build();

    consultingRepository.save(consulting);
  }
}
