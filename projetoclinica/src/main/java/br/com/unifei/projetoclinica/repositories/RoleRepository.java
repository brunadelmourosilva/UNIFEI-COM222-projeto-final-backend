package br.com.unifei.projetoclinica.repositories;

import br.com.unifei.projetoclinica.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * https://stackoverflow.com/questions/14014086/what-is-difference-between-crudrepository-and-jparepository-interfaces-in-spring
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

    Optional<Role> findByRoleName(String name);
}
