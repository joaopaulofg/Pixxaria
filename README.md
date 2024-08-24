# Sistema de Pixxaria

Um sistema de gerenciamento para pizzarias desenvolvido com Java, Spring Boot, JPA e MySQL para persistência, além do Spring Security e JWT para implementação da lógica de segurança, autenticação e autorização da API. O projeto permite que clientes façam pedidos, enquanto os funcionários podem gerenciar o cardápio e os pedidos.

## Tecnologias Utilizadas

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Spring Web](https://img.shields.io/badge/Spring%20Web-6DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000.svg?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

- **Java**: Como linguagem de programação principal.
- **Spring**: Como framework principal.
- **Spring Data JPA**: Para a persistência de dados.
- **Spring Web**: Para a criação de APIs REST.
- **Spring Security**: Para a segurança da aplicação.
- **JWT**: Para o uso de tokens e validação de usuário.
- **MySQL**: Para o armazenamento de dados.
- **Docker**: Para a containerização da aplicação e gerenciamento de ambientes.


## Estrutura do Projeto

- **src/main/java/me/dio**: Código-fonte da aplicação.
  - **controllers**: Controles de endpoints da API.
  - **infra**: Classes com a implementação da lógica de segurança, autenticação e autorização do sistema.
  - **models**: Entidades e modelos de dados.
  - **repositories**: Repositórios para acesso ao banco de dados.
  - **services**: Lógica de negócios e serviços.
  - **dtos**: Objetos de Transferência de Dados (DTOs).
  - **enums**: Classes auxiliares.
  - **exception**: Exceções personalizadas.
- **src/main/resources**: Recursos da aplicação.
  - **application.properties**: Configurações da aplicação, incluindo conexão com o banco de dados.

## Instalação

### Usando Docker e Docker Compose

1. **Clone o repositório**

    ```bash
    git clone https://github.com/joaopaulofg/Pixxaria.git
    cd Pixxaria
    ```

2. **Construir e executar o projeto com Docker Compose**

   Certifique-se de que você tem o Docker e o Docker Compose instalados. Então, execute os seguintes comandos para construir as imagens e iniciar os contêineres:

    ```bash
    docker-compose up --build
    ```

   Isso irá construir a imagem Docker para a aplicação e iniciar tanto o contêiner da aplicação quanto o contêiner do banco de dados MySQL.

3. **Acessar a aplicação**

   Após iniciar os contêineres, a aplicação estará acessível em `http://localhost:8080/swagger-ui/index.html`.

### Configuração Manual (Sem Docker)

Se você preferir executar o projeto manualmente, você precisará configurar o banco de dados e ajustar as propriedades:

1. **Configure o banco de dados**

   Edite o arquivo `src/main/resources/application.properties` para ajustar as configurações do banco de dados MySQL.

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/pixxaria
    spring.datasource.username=root
    spring.datasource.password=87432863
    ```

2. **Compile e execute a aplicação**

    ```bash
    mvn clean package
    java -jar target/pixxaria-0.0.1-SNAPSHOT.jar
    ```

## Endpoints Principais

- **Autenticação**
  - `POST /login` - Realizar login com usuário e senha.
  - `POST /register` - Realizar cadastro com usuário, senha, email e role.

- **Pedidos**
  - `POST /pedidos` - Criar um novo pedido
  - `GET /pedidos/{idPedido}` - Consultar detalhes de um pedido
  - `PUT /pedidos/{idPedido}` - Atualizar o status de um pedido

- **Pizza**
  - `POST /pizzas` - Adicionar uma nova pizza ao cardápio. (Apenas usuários com a role FUNCIONARIO têm autorização)
  - `GET /pizzas/{idPizza}` - Consultar detalhes de uma pizza.
  - `GET /pizzas` - Listar o cardápio com as pizzas cadastradas.
  - `DELETE /pizzas/{idPizza}` - Deletar uma pizza do cardápio. (Apenas usuários com a role FUNCIONARIO têm autorização)
  - `PUT /pizzas/{idPizza}` - Atualizar uma pizza no cardápio. (Apenas usuários com a role FUNCIONARIO têm autorização)

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
