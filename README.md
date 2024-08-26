
# Gerenciamento de Tarefas API

## Descrição
Este projeto é uma API para gerenciamento de tarefas, desenvolvida utilizando Spring Boot. A API permite a criação, atualização, visualização e exclusão de tarefas, além de gerenciar pessoas associadas a essas tarefas.

## Endpoints

### Pessoa
- **POST /pessoas**: Cria uma nova pessoa.
- **PUT /pessoas/{id}**: Atualiza os dados de uma pessoa existente.
- **GET /pessoas**: Retorna a lista de todas as pessoas.
- **DELETE /pessoas/{id}**: Remove uma pessoa.
- **GET pessoas/gastos**: Buscar pessoas por nome e período, retorna média de horas gastas por tarefa. (NÃO FINALIZADO)


### Tarefa
- **POST /tarefas**: Cria uma nova tarefa.
- **PUT /tarefas/alocar/{id}**: Aloca pessoa a tarefa.
- **PUT /tarefas/finalizar/{id}**: Finaliza tarefa.


## Tecnologias Usadas
- **Java 15**: Linguagem de programação utilizada.
- **Spring Boot**: Framework principal usado para a construção da aplicação.
- **Maven**: Ferramenta de gerenciamento de dependências.
- **Docker**: Usado para conteinerização da aplicação.
- **PostgreSQL**: Banco de dados utilizado para persistência dos dados.

## Estrutura do Projeto

- **/src/main/java/com/viniciussantos**
    - **/controller**: Contém os controladores que definem os endpoints da API.
    - **/dto**: Contém classes que representam os objetos de transferência de dados.
    - **/enums**: Define enumerações utilizadas na aplicação.
    - **/exception**: Contém classes de exceções personalizadas.
    - **/handler**: Define os manipuladores de exceções globais.
    - **/repository**: Contém as interfaces de repositórios que interagem com o banco de dados.
    - **/service**: Contém a lógica de negócios da aplicação.

## Padrões Usados
- **MVC (Model-View-Controller)**: O projeto segue o padrão de arquitetura MVC.
- **RESTful**: A API segue os princípios REST para a definição dos endpoints.
- **Testes Unitários**: O projeto inclui testes unitários para garantir a qualidade do código.

## Como Executar

1. Certifique-se de que o Docker está instalado e configurado corretamente.
2. Execute o comando `docker-compose up` para iniciar os containers necessários.
3. A aplicação estará disponível em `http://localhost:8080`.

---

