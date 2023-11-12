package br.com.unifei.projetoclinica.dto.request;

/** https://medium.com/experiencecode/usando-records-em-java-9afecf7495b3 */
public record UserUpdateRequest(String name, String email, String password) {}
