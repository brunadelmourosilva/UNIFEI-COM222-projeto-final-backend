package br.com.unifei.projetoclinica;

import br.com.unifei.projetoclinica.models.Clinic;
import br.com.unifei.projetoclinica.models.User;
import br.com.unifei.projetoclinica.repositories.ClinicRepository;
import br.com.unifei.projetoclinica.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProjetoclinicaApplication implements CommandLineRunner {

    @Autowired
    ClinicRepository clinicRepository;

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjetoclinicaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Clinic clinic = new Clinic();
        clinic.setName("AA");

        clinicRepository.save(clinic);

        User user = new User();
        user.setName("Bruna");
        user.setClinic(clinic);

        // relationship is bidirectional and JPA/Hibernate can manage the relationship based on the annotation
        // is not required, but it can be helpful for comprehension
        //clinic.getUsers().add(user);

        userRepository.save(user);
    }

}
