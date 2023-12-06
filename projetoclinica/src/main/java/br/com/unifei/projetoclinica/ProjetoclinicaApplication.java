package br.com.unifei.projetoclinica;

import br.com.unifei.projetoclinica.enums.SchedulingStatus;
import br.com.unifei.projetoclinica.models.*;
import br.com.unifei.projetoclinica.repositories.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProjetoclinicaApplication implements CommandLineRunner {

  @Autowired ClinicRepository clinicRepository;

  @Autowired UserRepository userRepository;

  @Autowired VeterinarianRepository veterinarianRepository;

  @Autowired PatientRepository patientRepository;

  @Autowired GuardianRepository guardianRepository;

  @Autowired SchedulingRepository schedulingRepository;

  @Autowired ConsultingRepository consultingRepository;

  @Autowired RoleRepository roleRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public static void main(String[] args) {
    SpringApplication.run(ProjetoclinicaApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Clinic clinicOne =
        Clinic.builder().name("UniVet").phone("359998751").address("Rua D. A. Chaves, 315").build();

    Clinic clinicTwo =
        Clinic.builder().name("PetLover").address("Rua treze de maio").phone("9898932323").build();

    clinicRepository.saveAll(List.of(clinicOne, clinicTwo));

    User user = User.builder().name("Márcia").email("marcia@gmail.com").password(passwordEncoder.encode("123")).clinic(clinicOne).build();

    // relationship is bidirectional and JPA/Hibernate can manage the relationship based on the
    // annotation
    // is not required, but it can be helpful for comprehension
    // clinic.getUsers().add(user);

    userRepository.save(user);

    // ----------------------
    Role role = Role.builder().roleName("ROLE_ADMIN").user(user).build();
    roleRepository.save(role);

    // ----------------------

    Veterinarian veterinarian =
        Veterinarian.builder().name("Júlia").specialty("Dogs").clinic(clinicOne).build();

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
            .clinic(clinicOne)
            .guardian(guardian)
            .build();

    patientRepository.save(patient);

    // ----------------------

    Scheduling scheduling =
        Scheduling.builder()
            .status(SchedulingStatus.PENDENTE)
            .patient(patient)
            .veterinarian(veterinarian)
            .build();

    schedulingRepository.save(scheduling);

    // ----------------------

    Consulting consulting =
        Consulting.builder().patient(patient).veterinarian(veterinarian).build();

    consultingRepository.save(consulting);
  }
}
