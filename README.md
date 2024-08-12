# Sistema de Pixxaria

Um sistema de gerenciamento para pizzarias desenvolvido com Java, Spring Boot e utilizando JPA e MySQL para persistência. O projeto permite que clientes façam pedidos, enquanto os funcionários podem gerenciar o cardápio e os pedidos.

## Tecnologias Utilizadas

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Spring Web](https://img.shields.io/badge/Spring%20Web-6DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000.svg?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)

- **Java**: Como linguagem de programação principal.
- **Spring**: Como framework principal.
- **Spring Data JPA**: Para a persistência de dados.
- **Spring Web**: Para a criação de APIs REST.
- **Spring Security**: Para a segurança da aplicação.
- **JWT**: Para o uso de tokens e validação de usuário.
- **MySQL**: Para o armazenamento de dados.

## Estrutura do Projeto

- **src/main/java/me/dio**: Código-fonte da aplicação.
  - **controllers**: Controles de endpoints da API.
  - **infra**: Classes com a implementação da lógica de segurança, autenticação e autorização do sistema.
  - **models**: Entidades e modelos de dados.
  - **repositories**: Repositórios para acesso ao banco de dados.
  - **services**: Lógica de negócios e serviços.
  - **dtos**: Objetos de Transferência de Dados (DTOs).
  - **enums**: Classes auxiliares.
  - **exception**: Excecoes personalizadas.
- **src/main/resources**: Recursos da aplicação.
  - **application.properties**: Configurações da aplicação, incluindo conexão com o banco de dados.

## Instalação

1. **Clone o repositório**

    ```bash
    git clone https://github.com/joaopaulofg/santander-bootcamp-java-pixxaria.git
    ```

2. **Configure o banco de dados**

    Edite o arquivo `src/main/resources/application.properties` para ajustar as configurações do banco de dados MySQL.

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/sua_base_de_dados
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    ```

## Endpoints Principais

- **Autenticação**
    - `POST /login` - Realizar login com usuario e senha.
    - `POST /register` - Realizar cadastro com usuario, senha, email e role.

- **Pedidos**
  - `POST /pedidos` - Criar um novo pedido
  - `GET /pedidos/{idPedido}` - Consultar detalhes de um pedido
  - `PUT /pedidos/{idPedido}` - Atualizar o status de um pedido

- **Pizza**
  - `POST /pizzas` - Adicionar uma nova pizza ao cardápio.
  - `GET /pizzas/{idPizza}` - Consultar detalhes de uma pizza.
  - `GET /pizzas` - Listar o cardápio com as pizzas cadastradas.
  - `DELETE /pizzas/{idPizza}` - Deletar uma pizza do cardápio.
  - `PUT /pizzas/{idPizza}` - Atualizar uma pizza no cardápio.


## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.


