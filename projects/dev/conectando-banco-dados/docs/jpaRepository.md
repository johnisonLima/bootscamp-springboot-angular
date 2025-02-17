# 📌 Conceito de JpaRepository no Spring Boot
O **JpaRepository** é uma interface do Spring Data JPA que fornece métodos prontos para manipulação de entidades no banco de dados. Ele estende a interface `CrudRepository`, oferecendo operações mais avançadas, como paginação e ordenação.

## 🔹 Principais Características
- [x] **Reduz a necessidade de código boilerplate** (menos código para operações CRUD).
- [x] **Suporte a paginação e ordenação** embutidos.
- [x] **Criação automática de queries com palavras-chave** no nome do método (Query Methods).
- [x] **Integração com Hibernate** para manipulação do banco de dados.

## 🔹 Tabela com as Principais Palavras-Chave do JpaRepository
No **JpaRepository**, você pode criar métodos personalizados apenas nomeando-os corretamente. O **Spring Data JPA** interpreta essas palavras e gera queries automaticamente.

| Palavra-Chave | Descrição | Exemplo |
|---------------|-----------|---------|
| `findBy`        | Busca registros pelo campo especificado | `findByNome(String nome)` |
| `existsBy`      | Verifica se um registro existe pelo campo | `existsByEmail(String email)` |
| `countBy`       | Conta registros com base em um critério | `countByCidade(String cidade)` |
| `deleteBy`      | Deleta registros com base em um critério | `deleteById(Long id)` |
| `OrderBy`       | Ordena resultados por um campo | `findByNomeOrderByIdDesc()` |
| `Top` ou `First`  | Retorna apenas os primeiros registros | `findTop3ByOrderByDataCadastroDesc()` |
| `And`           | Faz múltiplas condições na busca | `findByNomeAndEmail(String nome, String email)` |
| `Or`            | Busca com condição OU | `findByNomeOrCidade(String nome, String cidade)` |
| `Between`       | Busca dentro de um intervalo | `findByDataNascimentoBetween(Date inicio, Date fim)` |
| `Like`          | Busca por padrões (similar ao LIKE do SQL) | `findByNomeLike("%Silva%")` |
| `StartingWith`  | Filtra registros que começam com um valor | `findByNomeStartingWith("Jo")` |
| `EndingWith`    | Filtra registros que terminam com um valor | `findByNomeEndingWith("son")` |
| `Containing`    | Filtra registros que contêm um valor específico | `findByNomeContaining("Car")` |
| `GreaterThan`   | Busca valores maiores que o especificado | `findByIdadeGreaterThan(18)` |
| `LessThan`      | Busca valores menores que o especificado | `findByIdadeLessThan(60)` |


## 🔹 **Exemplo de Uso**
### 📌 1️⃣ **Criando a Entidade**

```java
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String email;
    private String cidade;

    // Getters e Setters
}
```

### 📌 2️⃣ **Criando um Repository com JpaRepository**
```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Métodos personalizados usando palavras-chave
    List<Cliente> findByNome(String nome);
    List<Cliente> findByCidadeContaining(String cidade);
    Cliente findFirstByOrderByIdDesc();
    Long countByCidade(String cidade);
}
```

### 📌 3️⃣ **Criando um Service**
```java
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> listarPorNome(String nome) {
        return repository.findByNome(nome);
    }

    public Cliente buscarUltimoCliente() {
        return repository.findFirstByOrderByIdDesc();
    }
}
```

### 📌 4️⃣ **Criando um Controller**
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

    @GetMapping("/nome/{nome}")
    public List<Cliente> buscarPorNome(@PathVariable String nome) {
        return service.listarPorNome(nome);
    }

    @GetMapping("/ultimo")
    public Cliente buscarUltimo() {
        return service.buscarUltimoCliente();
    }
}
```

## 🚀 Resumo
| Item |	O que faz? | 
|------| --------------| 
| JpaRepository|	Interface que fornece métodos CRUD prontos.|
| Palavras-chave|	Permitem criar queries automáticas sem escrever SQL.|
| FindBy, OrderBy, Between, Like...|	Utilizados para personalizar consultas.|
| Menos código  |	Graças ao Spring Data JPA, evita necessidade de implementar DAO manualmente.|

# Conclusão
O JpaRepository é uma das ferramentas mais poderosas do Spring Boot para manipular bancos de dados de forma rápida e eficiente, eliminando a necessidade de escrever SQL manualmente! 🚀🔥