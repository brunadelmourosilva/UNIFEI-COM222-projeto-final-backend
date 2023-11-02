package br.com.unifei.projetoclinica.repositories;

import br.com.unifei.projetoclinica.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
