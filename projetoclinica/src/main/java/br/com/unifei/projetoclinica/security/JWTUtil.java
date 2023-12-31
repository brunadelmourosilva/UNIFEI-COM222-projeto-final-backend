package br.com.unifei.projetoclinica.security;

import br.com.unifei.projetoclinica.models.User;
import br.com.unifei.projetoclinica.services.UsuarioSS;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken(UsuarioSS usuario) {
        return Jwts.builder()
                .claim("id", usuario.getId())
                .claim("username", usuario.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

    public boolean tokenValido(String token) {
        Claims claims = getClaims(token);
        if (claims != null) {
            String username = (String) claims.get("username");
            Date expirationDate = claims.getExpiration();
            Date now = new Date(System.currentTimeMillis());
            if (username != null && expirationDate != null && now.before(expirationDate)) {
                return true;
            }
        }
        return false;
    }

    public String getUsername(String token) {
        Claims claims = getClaims(token);
        if (claims != null) {
            return (String) claims.get("username");
        }
        return null;
    }

    private Claims getClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }
    }

    public RetornoLogin constroiRetornoLogin(String email, String userId, String token) {
        RetornoLogin retornoLogin = new RetornoLogin();

        retornoLogin.setEmail(email);
        retornoLogin.setToken(token);
        retornoLogin.setUserId(userId);

        return retornoLogin;
    }
}