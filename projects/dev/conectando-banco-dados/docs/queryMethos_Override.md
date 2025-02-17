# 🔹 **Query Methods e Override no Spring Boot**
## 📌 1️⃣ **O que são Query Methods?**
Os **Query Methods** são métodos que permitem realizar consultas automaticamente no banco de dados sem precisar escrever SQL manualmente. O Spring Data JPA interpreta os nomes dos métodos e gera a query correspondente.

✅ Vantagens dos Query Methods
-[x] Não precisa escrever SQL manualmente.
-[x] Código mais limpo e fácil de manter.
-[x] Usa convenções de nomenclatura para consultas automáticas.

## 📌 2️⃣ **Exemplos de Query Methods**
### 📌 **Consulta básica por um campo**
```java
List<Usuario> findByNome(String nome);
```

#### 🔹 **Equivalente a:**
```sql
SELECT * FROM usuario WHERE nome = ?;
```

### 📌 **Consulta com Like (busca aproximada)**
```java
List<Usuario> findByNomeContaining(String nome);
```

#### 🔹 **Equivalente a:**
```sql
SELECT * FROM usuario WHERE nome LIKE '%nome%';
```

### 📌 **Consulta com Ordenação**
```java
List<Usuario> findByNomeOrderByIdDesc(String nome);
```

#### 🔹 **Equivalente a:**
```sql
SELECT * FROM usuario WHERE nome = ? ORDER BY id DESC;
```

### 📌 **Consulta com múltiplos critérios**
```java
List<Usuario> findByNomeAndEmail(String nome, String email);
```

#### 🔹 **Equivalente a:**

```java
SELECT * FROM usuario WHERE nome = ? AND email = ?;
```

## 📌 3️⃣ O que é Override no Spring Boot?
O ** @Override** é uma anotação do Java usada para indicar que um método de uma classe filha está **sobrescrevendo** um método da classe pai ou de uma interface.

✅ Por que usar @Override?
-[x] Evita erros: O compilador verifica se o método está sendo sobrescrito corretamente.
-[x] Melhora a legibilidade: Indica que o método pertence a uma hierarquia de classes.

## 📌 4️⃣ **Exemplo de Uso do @Override no Spring Boot**
### 📌 **Criando uma Interface Repository**
```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
```

### 📌 **Criando um Service e Sobrescrevendo Métodos**
```java
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario buscarPorEmail(String email) {
        return repository.findByEmail(email);
    }

    // Método sobrescrito de Object
    @Override
    public String toString() {
        return "Este é um serviço de usuário.";
    }
}
```

➡️ Aqui, o **método toString()** foi **sobrescrito** para exibir uma mensagem personalizada.

### 📌 5️⃣ **Exemplo de @Override em um Controller**
```java
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/email/{email}")
    public Usuario buscarPorEmail(@PathVariable String email) {
        return service.buscarPorEmail(email);
    }

    // Método sobrescrito de Object
    @Override
    public String toString() {
        return "Controlador de Usuários";
    }
}
```
➡️ Aqui, o **método toString()** foi **sobrescrito** na classe UsuarioController.

## 📌 6️⃣ Resumo
| Conceito |	O que faz? |	Exemplo|
|----------|---------------|-----------|
**Query Methods** | 	Gera consultas automaticamente com base no nome do método |	`findByNome(String nome)`  |
**@Override** | 	Indica que um método está sendo sobrescrito de uma classe pai ou interface	| `@Override  public String toString() { return "Nova implementação"; } `|

# 🚀 Conclusão
* Os **Query Methods** facilitam consultas no banco sem escrever SQL manualmente.
* O **@Override** garante que um método está sobrescrevendo corretamente outro método, evitando erros e melhorando a clareza do código.

💡 **Usando esses conceitos, você cria aplicações Spring Boot mais eficientes e organizadas!** 🚀