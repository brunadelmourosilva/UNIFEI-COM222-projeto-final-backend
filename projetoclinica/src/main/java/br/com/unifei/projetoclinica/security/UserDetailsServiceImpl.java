package br.com.unifei.projetoclinica.security;

import br.com.unifei.projetoclinica.exceptions.BadRequestException;
import br.com.unifei.projetoclinica.models.User;
import br.com.unifei.projetoclinica.repositories.UserRepository;
import br.com.unifei.projetoclinica.services.UsuarioSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user =
        userRepository
            .findByEmail(email)
            .orElseThrow(() -> new BadRequestException("User not found."));

    return new UsuarioSS(
        user.getId(), user.getEmail(), user.getPassword(), user.rolesAsGrantedAuthorities());
  }
}
