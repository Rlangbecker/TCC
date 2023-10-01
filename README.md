# Carlos Auto-Peças - Sistema de consulta de peças

A Aplicação foi desenvolvida com o foco de poder consultar peças do estoque da loja de forma remota facilitando o atendimento seja ele no local da loja física ou outro local externo .

## Como rodar a Aplicação Localmente

* Clone este repositório.
* Escolha a sua IDE de preferência ( Neste tutorial usarei referências para IntelliJ ).
* Abra o projeto com o IntelliJ, e verifique se a "application.properties" ( src> main > resources > application.properties ) está configurado conforme [Application.properties](https://github.com/Rlangbecker/TCC/blob/main/src/main/resources/application.properties)
ou no caso queira trocar a PORTA onde está rodando, basta alterar a propriedade __server.port__ para o valor que deseja.

## Testando a aplicação

* Para utilizar o Swagger para testar e ler a documentação, acesse http://localhost:5000/swagger-ui/index.html. ( Caso tenha trocado a porta na etapa anterior, trocar a porta na URL)

* Utilizando Postman ou outra ferramenta os endpoints e corpos de requisição são os seguintes:
  Obs: Lembre-se de trocar a porta caso tenha alterado no applications.properties.

[POST] "/auth/register"


 __ROLE__ pode ser composta por dois tipos: ROLE_ADMIN ou ROLE_ATENDENTE
```json
{
  "login": "ricardo",
  "senha": "123456",
  "nome": "Ricardo Langbecker",
  "role": "ROLE_ADMIN"
}
```

[POST] "/auth/login"


```json
{
    "login":"Ricardo",
    "senha":"123456"
}
```


[GET] "/pecas"
Retornará a lista de peças existentes no banco de forma paginada.


[GET] "/pecas/codigo/1001"
Retornará a peça pelo seu código.

[GET] "/pecas/descricao/bucha"
Retornará uma lista de peças que contenham a palavra "bucha".

[GET] "/pecas/referencia/40307"
Retornará uma lista de peças que contenham a referencia "40307".

[GET] "/user"
Retornará a lista de usuarios existentes no banco.

[GET] "/user/ricardo"
Retornará as informações do usuario com o login "ricardo".

[GET] "/user/change-password"
```json
{
  "login": "ricardo",
  "senha": "123456",
  "novaSenha": "123456NovaSenha"
}
```

[GET] "/user/change-password-from-user"
```json
{
  "login": "ricardo",
  "senha": "NovaSenha"
}
```





## Tecnolocias Utilizadas
* __Java 17__
  
* __Maven__: é uma poderosa ferramenta de gerenciamento de construção e automação de projetos amplamente utilizada na indústria de desenvolvimento de software. Ele permite que os desenvolvedores definam, construam, testem e gerenciem projetos de software Java (e outras linguagens) de maneira eficiente e padronizada.

* __Spring Boot__: é um framework em Java que simplifica o desenvolvimento de aplicações autônomas e robustas. Ele fornece configurações padrão e uma estrutura de projeto que facilita a criação de aplicativos Java de alta qualidade.

* __Spring Data JPA__:  é uma parte do ecossistema Spring que simplifica a interação com bancos de dados relacionais usando Java Persistence API (JPA). Ele fornece um conjunto de abstrações que tornam mais fácil escrever consultas de banco de dados e operações CRUD.

* __Spring Security__: é um módulo do Spring que fornece recursos de segurança para autenticação e autorização em aplicações Java. Ele ajuda a proteger as aplicações contra ameaças comuns, como acesso não autorizado.

* __Json Web Tokens__: é um padrão aberto para representar informações seguras entre duas partes como um objeto JSON. É frequentemente usado para autenticação e troca segura de informações entre sistemas.
