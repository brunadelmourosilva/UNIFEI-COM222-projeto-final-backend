package br.com.unifei.projetoclinica.dto.response;

public record GuardianResponse(
    String id, String name, String email, String phone, String address) {}
