#  Trabalho final para a disciplina COM222.2 – Programação Web

## API Back-End - Sistema de Gerenciamento Para Clínicas Veterinárias

---

### Descrição do Projeto

O projeto de gerenciamento para clínicas veterinárias visa oferecer uma solução que proporciona uma gestão eficiente de agendamentos de consultas, cadastros de pacientes, veterinários, tutores e entre outros.

### Tecnologias utilizadas no back-end

* Java 17
* Spring Boot 2.7.4
* Spring Data JPA
* Autenticação/Autorização com Spring Security e JWT
* Maven
* H2 (banco de dados em memória)
* Lombok
* MapStruct
* OpenAPI (Swagger 3)
* Google Formatter Plugin

### Tecnologias utilizadas no front-end

* React Native
* Tailwind
* Axios para a realização de requisições HTTP

---

### Problema que o projeto tenta resolver

O gerenciamento eficiente de uma clínica veterinária envolve diversos aspectos, como o agendamento eficaz de consultas, o controle de pacientes e suas informações, e não menos importante, a necessidade de um sistema seguro para proteger dados sensíveis. Todas essas questões podem ser facilmente gerenciáveis através de um sistema no qual oferece confiabilidade e segurança para que as clínicas veterinárias.

---

### Diagrama de relacionamento entre tabelas

O diagrama de relacionamento entre tabelas abaixo oferece uma visão resumida das interações entre as principais entidades em nosso banco de dados.

![image](https://github.com/brunadelmourosilva/UNIFEI-COM222-projeto-final-backend/assets/61791877/54d4b46c-8c91-46df-97f5-2752e49a9f5d)

---

### Histórico de planejamento para o desenvolvimento do sistema

- Definição das ideias iniciais e futuras descritas no aplicativo draw.io:
  - https://drive.google.com/file/d/1W3CYmlUEpcAA2-vNheQlusY2Em2pA4uw/view?usp=sharing
- OK criação e definição dos relacionamentos entre as entidades;
- OK definição das rotas para o front-end(endpoints);
- OK criação dos services(regras de negócio);
- OK criação da rota de criação do usuário(não autenticado);
- OK criação da rota de login(não autenticado);
- OK implementação de segurança das demais rotas(spring security)(user autenticado);
- OK tratamento de exceções.
