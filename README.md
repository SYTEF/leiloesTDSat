<h1 align="center">Sistema de Leilões</h1>

<p align="center">
  Aplicação desktop desenvolvida em Java para cadastro,
  gerenciamento e acompanhamento de produtos em um sistema de leilões.
</p>

<p align="center">
  <code>Java</code> ·
  <code>Java Swing</code> ·
  <code>MySQL</code> ·
  <code>JDBC</code> ·
  <code>NetBeans</code>
</p>

---

> Projeto acadêmico desenvolvido durante a formação em Desenvolvimento de Sistemas, com foco em orientação a objetos, persistência de dados, arquitetura DAO/DTO e integração Java/MySQL.

## Objetivo do Projeto

Desenvolver uma aplicação desktop para gerenciamento de produtos em uma casa de leilões.

O projeto permite aplicar conceitos de desenvolvimento Java, banco de dados, interfaces gráficas e separação de responsabilidades através das camadas DAO e DTO.

---

## Funcionalidades

### Cadastro de Produtos

* Cadastro de novos produtos
* Registro do nome do produto
* Registro do valor
* Definição do status do produto
* Persistência das informações no banco de dados

### Listagem de Produtos

* Consulta dos produtos cadastrados
* Exibição dos dados em tabela
* Visualização de ID, nome, valor e status

### Venda de Produtos

* Alteração do status do produto para `Vendido`
* Atualização do registro diretamente no banco de dados
* Identificação dos produtos vendidos

### Consulta de Vendas

* Listagem exclusiva de produtos vendidos
* Exibição das vendas em tabela
* Consulta de ID, nome, valor e status

---

## Tecnologias Utilizadas

| Tecnologia   | Aplicação no projeto                   |
| ------------ | -------------------------------------- |
| Java         | Desenvolvimento da aplicação           |
| Java Swing   | Construção das interfaces gráficas     |
| MySQL        | Persistência dos dados                 |
| JDBC         | Comunicação entre Java e MySQL         |
| NetBeans     | Desenvolvimento e construção das telas |
| Git / GitHub | Versionamento do código                |

---

## Organização do Código

O projeto utiliza uma separação simples de responsabilidades entre dados, acesso ao banco e interface gráfica.

### Principais classes

* `ProdutosDTO.java` — representação e transporte dos dados dos produtos
* `ProdutosDAO.java` — operações relacionadas ao banco de dados
* `conectaDAO.java` — conexão da aplicação com o MySQL
* `cadastroVIEW.java` — interface de cadastro de produtos
* `listagemVIEW.java` — visualização e gerenciamento dos produtos
* `vendasVIEW.java` — consulta dos produtos vendidos

---

## Persistência de Dados

A aplicação utiliza JDBC para comunicação com o banco de dados MySQL.

As principais operações implementadas incluem:

* `INSERT` para cadastro de produtos
* `SELECT` para consulta dos produtos
* `UPDATE` para alteração do status de venda
* Consulta filtrada de produtos com status `Vendido`

O acesso ao banco é realizado através da classe `ProdutosDAO`.

---

## Fluxo Principal

O fluxo principal da aplicação pode ser resumido da seguinte forma:

**Cadastro do produto → Produto disponível → Venda registrada → Status alterado para Vendido → Produto exibido na consulta de vendas**

Esse fluxo permite acompanhar o ciclo básico dos produtos dentro do sistema.

---

## Conceitos Aplicados

Durante o desenvolvimento foram utilizados conceitos de:

* Programação orientada a objetos
* Java
* Java Swing
* CRUD
* JDBC
* SQL
* MySQL
* DAO
* DTO
* Interfaces gráficas
* Persistência de dados
* Regras de negócio
* Git e GitHub

---

## Como Executar

### Pré-requisitos

* Java JDK 8 ou superior
* NetBeans IDE
* MySQL Server
* MySQL Connector/J

### Execução

1. Clone o repositório:

`git clone https://github.com/SYTEF/leiloesTDSat.git`

2. Abra o projeto no NetBeans.

3. Configure o banco de dados MySQL.

4. Verifique a configuração de conexão na classe:

`src/conectaDAO.java`

5. Execute o projeto pelo NetBeans.

---

## Contexto Acadêmico

Projeto desenvolvido como parte dos estudos do curso **Técnico em Desenvolvimento de Sistemas — Senac-SP**.

O projeto foi utilizado para praticar integração entre aplicação Java, banco de dados MySQL e versionamento utilizando Git/GitHub.

---

## Autor

**Enzo Borsato**

Desenvolvimento Java e Banco de Dados
