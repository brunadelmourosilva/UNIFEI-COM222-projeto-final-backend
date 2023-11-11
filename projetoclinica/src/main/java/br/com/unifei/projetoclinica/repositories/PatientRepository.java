package br.com.unifei.projetoclinica.repositories;

import br.com.unifei.projetoclinica.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
}
