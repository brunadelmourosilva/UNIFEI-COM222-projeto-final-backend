package br.com.unifei.projetoclinica.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {

    private String message;

    @JsonFormat(pattern = "dd/MM/yyyy H:mm:ss", locale = "pt_BR", timezone = "Brazil/East")
    private Date timestamp;
}
