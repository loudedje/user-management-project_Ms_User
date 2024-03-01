# MS User

## Descrição
Este é o repositório para o projeto MS User, parte do desafio durante meu estágio na Compass UOL, com o objetivo de criar conexões entre MSs. No meu GitHub, você também encontrará MS Address e MS Notification.

## Pré-requisitos
- Java 17
- Maven
- MySQL
- RabbitMQ

## Configuração

### Banco de Dados MySQL
- Certifique-se de ter um servidor MySQL em execução.
- Atualize as configurações do banco de dados no arquivo `application.yml`.

### RabbitMQ
- Certifique-se de ter o RabbitMQ instalado e em execução.
- Configure as propriedades do RabbitMQ no arquivo `application.yml`.

## Como Executar
1. Clone o repositório: `git clone https://github.com/seu-usuario/ms-user.git`
2. Navegue até o diretório do projeto: `cd ms-user`
3. Execute o projeto: `mvn spring-boot:run`

O aplicativo estará disponível em `http://localhost:8081` por padrão.

## Endpoints

### Usuários
- `POST /v1/users`: Cria um novo usuário.
- `GET /v1/users/{id}`: Obtém informações sobre um usuário específico.
- `PUT /v1/users/{id}`: Atualiza o usuário por e-mail e CEP como requisito.
