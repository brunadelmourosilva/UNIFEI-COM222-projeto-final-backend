package br.com.unifei.projetoclinica.repositories;

import br.com.unifei.projetoclinica.models.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarianRepository extends JpaRepository<Veterinarian, String> {
}
