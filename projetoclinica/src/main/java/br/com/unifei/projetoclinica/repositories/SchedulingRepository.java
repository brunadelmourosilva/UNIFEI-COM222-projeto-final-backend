package br.com.unifei.projetoclinica.repositories;

import br.com.unifei.projetoclinica.models.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, String> {
}
