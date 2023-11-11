package br.com.unifei.projetoclinica.repositories;

import br.com.unifei.projetoclinica.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * https://stackoverflow.com/questions/14014086/what-is-difference-between-crudrepository-and-jparepository-interfaces-in-spring
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {}
