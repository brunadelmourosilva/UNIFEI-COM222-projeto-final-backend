# UNIFEI-COM222-projeto-final

---

PLANEJAMENTO - BACK-END

- OK criação e definição dos relacionamentos entre as entidades;
- OK definição das rotas para o front-end(endpoints);
- OK criação dos services(regras de negócio);
  - patient flow: tratar recebimento da imagem;
  - terminar todos + validar/atualizar de acordo com os requisitos do front; 
- criação da rota de criação do usuário(não autenticado);
  - @Email annotation
- criação da rota de login(não autenticado);
- implementação de segurança das demais rotas(spring security)(user autenticado);
- se houver tempo:
  - upload das imagens dos pets no S3 e montagem da URL do S3 para salvar no banco(campo imageUrl);
  - envio de e-mail com SNS ou Spring e-mail quando o usuário criar uma conta + tutor;
  - tratamento de exceções;
  - validation;
