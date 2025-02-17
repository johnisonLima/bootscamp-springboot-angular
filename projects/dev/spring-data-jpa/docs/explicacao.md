# 📌 Conceitos de ORM, JPA e Spring Data JPA

## 🔹 **1. ORM (Object-Relational Mapping)**
**ORM (Mapeamento Objeto-Relacional)** é um conceito que permite converter dados entre **objetos Java** e **bancos de dados relacionais** sem precisar escrever SQL manualmente.

✔ Benefícios:
- Evita SQL manual, tornando o código mais limpo.
- Facilita a manutenção e a portabilidade do banco de dados.
- Trabalha com entidades e relações no banco como objetos Java.

✔ Exemplos de ferramentas ORM:
- Hibernate (mais popular no Java)
- EclipseLink
- TopLink

## 🔹 **2. JPA (Java Persistence API)**
A **JPA (Java Persistence API)** é uma especificação da **Java EE** que define um conjunto de APIs para **persistência de dados** usando ORM.

### 📌 **Importante:**
* **JPA não é uma implementação**, mas sim um padrão que outras ferramentas seguem.
* O **Hibernate** é a implementação mais usada da JPA.

✔ **Principais anotações da JPA:**
```java
@Entity // Define que a classe é uma entidade do banco de dados
@Table(name = "clientes") // Especifica o nome da tabela no banco de dados
public class Cliente {

    @Id // Define a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento
    private Long id;

    @Column(name = "nome", nullable = false, length = 100) // Define detalhes da coluna
    private String nome;
}
```

## 🔹 3. Spring Data JPA
O **Spring Data JPA** é um **módulo do Spring** que facilita o uso da JPA, reduzindo ainda mais o código necessário para operações no banco de dados.

### 📌 **Benefícios:**
- [x] Reduz a necessidade de escrever queries SQL.
- [x] Oferece métodos prontos para CRUD (save, findById, delete, etc.).
- [x] Integração fácil com Hibernate e outros ORMs.

✔ Exemplo de Repository com Spring Data JPA:
```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // O Spring Data JPA já fornece métodos como save(), findById(), findAll(), deleteById()
}
```
Agora podemos usar o ClienteRepository para acessar o banco sem escrever SQL!

## 🚀 Resumo
Tecnologia	| O que é? | Exemplo
----------- | --------- | ------------
ORM |	Conceito para mapear objetos Java para bancos de dados |	Hibernate, EclipseLink
JPA |	Especificação Java para persistência de dados |	`@Entity`,` @Id`, `@Table`
Spring Data JPA |	Módulo do Spring que simplifica a JPA |	`JpaRepository<Cliente, Long>`

**Spring Data JPA** é a melhor opção para projetos Spring Boot, pois **reduz o código boilerplate** e **facilita a manutenção** da aplicação. 🚀🔥