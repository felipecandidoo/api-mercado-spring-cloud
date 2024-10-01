# API de Estoque - Mercadinho

## Descrição
Esta API fornece funcionalidades para gerenciar o estoque de produtos em um mercadinho. A API é construída utilizando Spring Boot, JPA, Lombok e PostgreSQL, além de implementar microserviços com Eureka e Spring Cloud Gateway.

## Estrutura do Projeto

### Dependências
- Spring Web
- Spring JPA
- Spring Boot DevTools
- Lombok
- PostgreSQL Driver
- Spring Cloud OpenFeign
- Spring Cloud Eureka
- Spring Cloud Gateway


# Documentação da API Fornecedor

## Fornecedor

### Endpoints

- **GET /fornecedores/{id}**
  - **Descrição**: Obtém os detalhes de um fornecedor pelo ID.
  - **Response**: 
    ```json
    {
      "codFornec": 1,
      "fornecedor": "Fornecedor Exemplo",
      "cnpj": "12.345.678/0001-90",
      "endereco": "Rua Exemplo, 123",
      "telefone": "(11) 91234-5678",
      "email": "fornecedor@example.com"
    }
    ```

- **POST /fornecedores/save**
  - **Descrição**: Salva um novo fornecedor.
  - **Request Body**: 
    ```json
    {
      "fornecedor": "Fornecedor Novo",
      "cnpj": "98.765.432/0001-01",
      "endereco": "Avenida Nova, 456",
      "telefone": "(11) 98765-4321",
      "email": "novofornecedor@example.com"
    }
    ```
  - **Response**: `HTTP 200 OK`.

---

# Documentação da API de Produto

### Endpoints

- **POST /produtos**
  - **Descrição**: Cria um novo produto.
  - **Request Body**: 
    ```json
    {
      "descricao": "Produto Exemplo",
      "codFornec": 1,
      "unidade": "unidade",
      "peso": 0.5,
      "dtvencimento": "2024-12-31"
    }
    ```
  - **Response**: `HTTP 201 Created`.

- **GET /produtos**
  - **Descrição**: Obtém a lista de todos os produtos.
  - **Response**: 
    ```json
    [
      {
        "codProd": 1,
        "descricao": "Produto Exemplo 1",
        "codFornec": 1,
        "unidade": "unidade",
        "peso": 0.5,
        "dtvencimento": "2024-12-31"
      },
      {
        "codProd": 2,
        "descricao": "Produto Exemplo 2",
        "codFornec": 2,
        "unidade": "unidade",
        "peso": 1.0,
        "dtvencimento": "2024-11-30"
      }
    ]
    ```

- **GET /produtos/{id}**
  - **Descrição**: Obtém os detalhes de um produto pelo ID.
  - **Response**: 
    ```json
    {
      "result": {
        "codProd": 1,
        "descricao": "Produto Exemplo",
        "codFornec": 1,
        "unidade": "unidade",
        "peso": 0.5,
        "dtvencimento": "2024-12-31"
      },
      "port": "8080" // Exemplo da porta do serviço
    }
    ```

- **GET /produtos/find/{id}**
  - **Descrição**: Encontra um produto pelo ID.
  - **Response**: 
    ```json
    {
      "codProd": 1,
      "descricao": "Produto Exemplo",
      "codFornec": 1,
      "unidade": "unidade",
      "peso": 0.5,
      "dtvencimento": "2024-12-31"
    }
    ```

- **GET /produtos/{id}/estoque**
  - **Descrição**: Obtém o estoque associado a um produto pelo ID.
  - **Response**: 
    ```json
    {
      "codProd": 1,
      "quantidade": 100,
      "precoUnitario": 10.50
    }
    ```

# Documentação da API de Estoque

## Endpoints

- **GET /estoque**
  - **Descrição**: Obtém todos os itens no estoque.
  - **Response**: 
    ```json
    [
      {
        "codProd": 1,
        "quantidade": 100,
        "precoUnitario": 10.50
      },
      {
        "codProd": 2,
        "quantidade": 200,
        "precoUnitario": 15.75
      }
    ]
    ```

- **GET /estoque/{codProd}**
  - **Descrição**: Retorna o item no estoque com base no código do produto.
  - **Response**: 
    ```json
    {
      "codProd": 1,
      "quantidade": 100,
      "precoUnitario": 10.50
    }
    ```

- **PUT /estoque/entrada/{codProd}**
  - **Descrição**: Registra uma entrada de mercadoria no estoque.
  - **Request Params**:
    - `qtd`: Quantidade a ser adicionada.
    - `preco`: Preço unitário do produto.
  - **Response**: 
    ```json
    {
      "codProd": 1,
      "quantidade": 150,
      "precoUnitario": 10.50
    }
    ```

- **POST /estoque/criar**
  - **Descrição**: Cria um novo registro de estoque para um produto.
  - **Request Params**:
    - `codProd`: Código do produto.
  - **Response**: `HTTP 200 OK`.

- **PUT /estoque/precificar/{codProd}**
  - **Descrição**: Atualiza o preço unitário de um produto no estoque.
  - **Request Params**:
    - `preco`: Novo preço unitário.
  - **Response**: 
    ```json
    {
      "codProd": 1,
      "quantidade": 100,
      "precoUnitario": 12.00
    }
    ```

- **GET /estoque/valor-total**
  - **Descrição**: Retorna o valor total de cada item no estoque.
  - **Response**: 
    ```json
    [
      {
        "ProdutoID: 1": 1050.00
      },
      {
        "ProdutoID: 2": 3150.00
      }
    ]
    ```

- **GET /estoque/peso-total**
  - **Descrição**: Retorna o peso total por item no estoque.
  - **Response**: 
    ```json
    [
      {
        "ProdutoID: 1": 50.0
      },
      {
        "ProdutoID: 2": 100.0
      }
    ]
    ```

- **GET /estoque/relatorio**
  - **Descrição**: Retorna um relatório básico dos itens em estoque.
  - **Response**: 
    ```json
    [
      {
        "codprod": 1,
        "descricao": "Produto A",
        "quantidade": 100,
        "peso": 10.0,
        "precounit": 10.50,
        "valortotal": 1050.00,
        "pesototal": 1000.00,
        "dtvencimento": "2024-12-31",
        "diaParaVencer": 30
      },
      {
        "codprod": 2,
        "descricao": "Produto B",
        "quantidade": 200,
        "peso": 15.0,
        "precounit": 15.75,
        "valortotal": 3150.00,
        "pesototal": 3000.00,
        "dtvencimento": "2024-12-31",
        "diaParaVencer": 45
      }
    ]
    ```



# Eureka
## Eureka Server rodando na porta 8761 com as API's registradas

![image](https://github.com/user-attachments/assets/ed29ddba-bdd2-461a-9868-d164f169133d)

#Load Balance
## Exemplo do Load Balance funcionado, a cada requisição ele regula em qual instância será requisitado

![Demonstração da Aplicação](.C:\Users\felip\Downloads\2024-10-01-02-55-00.gif)


