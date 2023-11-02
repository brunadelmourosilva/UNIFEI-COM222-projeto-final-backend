package br.com.unifei.projetoclinica.repositories;

import br.com.unifei.projetoclinica.models.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, String> {
}
