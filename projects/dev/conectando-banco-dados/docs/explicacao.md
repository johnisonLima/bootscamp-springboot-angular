# 📌 Conceito de Conexão do Spring Boot ao MySQL
O **Spring Boot** facilita a conexão com bancos de dados como **MySQL** através do **Spring Data JPA** e **Hibernate**. A configuração do banco pode ser feita diretamente no `application.properties` ou `application.yml`, como no exemplo fornecido.

## 🔹 **Explicação da Configuração**
```properties
# Opcionais: Exibir as consultas SQL no console
spring.jpa.show-sql=true
# Opcionais: Exibir as consultas SQL no console
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update


# Dialeto do MySQL (define como o Hibernate traduz as queries para MySQL)
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
# Configuração do driver JDBC
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
# URL de conexão ao banco
spring.datasource.url=jdbc:mysql://localhost:3306/dio_exemplo?createDatabaseIfNotExist=true
# Credenciais de acesso ao banco
spring.datasource.username=root
spring.datasource.password=root
```

## 🔹 **Como Funciona no Spring Boot?**
1. O **Spring Boot** lê as configurações do `application.properties.`
2. O **Spring Data JPA** usa essas configurações para inicializar a conexão com o MySQL.
3. O **Hibernate** traduz os objetos Java (entidades) em tabelas do banco.
4. O **Spring Boot** gerencia automaticamente as transações e conexões.

## 🔹 **Exemplo de Uso**
### 📌 1️⃣ **Criando uma Entidade**
```java
import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    private String email;

    // Getters e Setters
}
```


## 📌 2️⃣ **Criando um Repository**
```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
```

## 📌 2️⃣ **Criando um Repository**
```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
```

## 📌 3️⃣ **Criando um Service**
```java
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }
}
```

## 📌 4️⃣ **Criando um Controller**
```java
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cliente> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return service.salvar(cliente);
    }
}
```

## 🚀 Resumo
Configuração | O que faz?
------------- | ------------------------------------------------------------------
`spring.datasource.url` |	Define a URL do banco MySQL.
`spring.datasource.username` |	Usuário do banco.
`spring.datasource.password` |	Senha do banco.
`spring.jpa.hibernate.ddl-auto` |	Define como o Hibernate gerencia as tabelas.
`spring.jpa.show-sql` |	Mostra queries SQL no console.

Essa configuração **simplifica** a conexão com o MySQL e permite usar **JPA** + **Hibernate** sem precisar de configurações complexas. 🚀