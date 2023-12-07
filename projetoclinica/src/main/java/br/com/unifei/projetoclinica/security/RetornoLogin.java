package br.com.unifei.projetoclinica.security;

import br.com.unifei.projetoclinica.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetornoLogin {

    private String email;
    private String token;
    private String userId;
}
