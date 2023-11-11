package br.com.unifei.projetoclinica.repositories;

import br.com.unifei.projetoclinica.models.Consulting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultingRepository extends JpaRepository<Consulting, String> {
}
