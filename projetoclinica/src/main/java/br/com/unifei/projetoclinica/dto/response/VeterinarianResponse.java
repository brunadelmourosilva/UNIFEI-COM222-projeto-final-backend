package br.com.unifei.projetoclinica.dto.response;

import br.com.unifei.projetoclinica.models.Clinic;

public record VeterinarianResponse(
    String id, String name, String phone, String specialty) {}
