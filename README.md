# Personal_API_Rest_DIO

<h2>Digital Innovation: Expert class - Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring Boot</h2>

Neste projeto vamos desenvolver um pequeno sistema para o gerenciamento de pessoas de uma empresa através de uma API REST, criada com o Spring Boot.

Durante o projeto, serão desenvolvidos e abordados os seguintes tópicos:

* Setup inicial de projeto com o Spring Boot Initialzr 
* Criação de modelo de dados para o mapeamento de entidades em bancos de dados
* Desenvolvimento de operações de gerenciamento de usuários (Cadastro, leitura, atualização e remoção de pessoas de um sistema).
* Relação de cada uma das operações acima com o padrão arquitetural REST, e a explicação de cada um dos conceitos REST envolvidos durante o desenvolvimento do projeto.
* Desenvolvimento de testes unitários para validação das funcionalidades
* Implantação do sistema na nuvem através do Heroku

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

Enviar dados para a API, atravez de uma metodo POST para:
```
http://localhost:8080/api/v1/people
```
com o sequinte padrão:

```
{
  "nm_FirstName": "Ronaldo",
  "nm_LastName": "Lima",
  "cd_Cpf":"581.556.080-42",
  "dt_BirthDate":"23-03-1988" ,
  "phones": [
    {
    "type": "MOBILE",
    "number": "(11)998516257"
    }
  ]
}
```


Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto mostrando que ira retornar os Usuarios Cadastrados:

```
http://localhost:8080/api/v1/people
```


São necessários os seguintes pré-requisitos para a execução do projeto desenvolvido :

* Java 11 ou versões superiores.
* Maven 3.6.3 ou versões superiores.
* Intellj IDEA ou sua IDE favorita.
* Muita vontade de aprender e compartilhar conhecimento :)


<h3> Link da aplicação na nuvem para teste </h3>

```
https://people-api-digital-inovation.herokuapp.com/api/v1/people
```

