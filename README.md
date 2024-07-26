# Sistema de Pizzaria

Um sistema de gerenciamento para pizzarias desenvolvido com Java, Spring Boot e MySQL. O projeto permite que clientes façam pedidos, enquanto os funcionários podem gerenciar o cardápio e os pedidos.

## Funcionalidades

- **Clientes**:
  - Cadastro de clientes
  - Criação de pedidos
  - Visualização do histórico de pedidos (opcional)

- **Funcionários**:
  - Cadastro de pizzas no cardápio
  - Finalização de pedidos
  - Consulta do valor total no caixa (opcional)

## Tecnologias Utilizadas

- **Backend**: Java, Spring Boot
- **Banco de Dados**: MySQL
- **Documentação da API**: Swagger
- **Gerenciamento de Dependências**: Maven

## Estrutura do Projeto

- **src/main/java/me/dio**: Código-fonte da aplicação.
  - **controllers**: Controles de endpoints da API.
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

3. **Compile e execute o projeto**

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Uso da API

A API está documentada com Swagger. Após iniciar a aplicação, acesse a documentação da API em:

http://localhost:8080/swagger-ui.html

## Endpoints Principais

- **Clientes**
  - `POST /clientes` - Cadastrar um novo cliente
  - `GET /clientes/{id}` - Consultar informações de um cliente

- **Pedidos**
  - `POST /pedidos` - Criar um novo pedido
  - `GET /pedidos/{id}` - Consultar detalhes de um pedido

- **Pizza**
  - `POST /pizzas` - Adicionar uma nova pizza ao cardápio
  - `GET /pizzas/{id}` - Consultar detalhes de uma pizza
  - `GET /pizzas` - Listar o cardápio com as pizzas cadastradas

## Contribuição

1. **Faça um fork do projeto**
2. **Crie uma nova branch**

    ```bash
    git checkout -b minha-nova-funcionalidade
    ```

3. **Faça suas alterações**
4. **Commit suas mudanças**

    ```bash
    git commit -am 'Adiciona nova funcionalidade'
    ```
5. **Envie para o repositório remoto**

    ```bash
    git push origin minha-nova-funcionalidade
    ```
6. **Crie um Pull Request**

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.


