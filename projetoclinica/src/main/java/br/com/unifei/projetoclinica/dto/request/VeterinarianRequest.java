package br.com.unifei.projetoclinica.dto.request;


/** https://medium.com/experiencecode/usando-records-em-java-9afecf7495b3 */
public record VeterinarianRequest(
    String name, String phone, String specialty) {}
