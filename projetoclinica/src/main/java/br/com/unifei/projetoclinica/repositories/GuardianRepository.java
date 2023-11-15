package br.com.unifei.projetoclinica.repositories;

import br.com.unifei.projetoclinica.models.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuardianRepository extends JpaRepository<Guardian, String> {

    Optional<Guardian> findByEmail(String email);
}
