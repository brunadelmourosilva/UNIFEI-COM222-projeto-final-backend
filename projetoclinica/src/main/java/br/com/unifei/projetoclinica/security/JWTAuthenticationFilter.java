package br.com.unifei.projetoclinica.security;

import br.com.unifei.projetoclinica.models.User;
import br.com.unifei.projetoclinica.repositories.UserRepository;
import br.com.unifei.projetoclinica.services.UsuarioSS;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;
    private JWTUtil jwtUtil;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {

        try {
            Credentials creds = new ObjectMapper().readValue(req.getInputStream(), Credentials.class);

            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(
                            creds.getEmail(), creds.getPassword(), new ArrayList<>());

            Authentication auth = authenticationManager.authenticate(authToken);

            return auth;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth)
            throws IOException, ServletException {

        UsuarioSS usuario = (UsuarioSS) auth.getPrincipal();

        String token = jwtUtil.generateToken(usuario);

        User user = userRepository.findByEmail(usuario.getEmail()).get();

        RetornoLogin retornoLogin = jwtUtil.constroiRetornoLogin(user.getEmail(), user.getId(), token);

        setHttpResponseConfigs(res, retornoLogin);
    }

    private void setHttpResponseConfigs(HttpServletResponse res, RetornoLogin retorno) {

        String json;
        try {
            json = new ObjectMapper().writeValueAsString(retorno);

            res.setStatus(HttpStatus.OK.value());
            res.setContentType("application/json");
            res.setCharacterEncoding("UTF-8");
            res.getWriter().write(json);
            res.flushBuffer();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
