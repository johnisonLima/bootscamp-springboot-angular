# 📌 O que é `@ConfigurationProperties` no Spring Boot?

A anotação `@ConfigurationProperties` é usada no Spring Boot para mapear e carregar várias configurações definidas no `application.properties` ou `application.yml` diretamente em uma classe Java.

Diferente de `@Value`, que injeta propriedades individuais, `@ConfigurationProperties` permite carregar múltiplas propriedades de uma vez e organizá-las dentro de uma classe de configuração.

## ✅ Vantagens do `@ConfigurationProperties`
- [x] Organização: Agrupa todas as configurações relacionadas em uma única classe.
- [x] Facilidade de manutenção: Permite mudanças sem precisar modificar o código principal.
- [x] Tipagem forte: O Spring valida automaticamente os tipos dos atributos.
- [x] Escalabilidade: Ideal para grandes aplicações com várias configurações.

### 📌 Exemplo de Uso
#### 1️⃣ **Definir propriedades no application.yml**

````java
meuservico:
  nome: "Meu Serviço"
  url: "https://api.meuservico.com"
  timeout: 5000
````
#### 2️⃣ **Criar a classe de configuração**

```java
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "meuservico")
public class MeuServicoConfig {

    private String nome;
    private String url;
    private int timeout;

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public int getTimeout() { return timeout; }
    public void setTimeout(int timeout) { this.timeout = timeout; }
}
```

### 3️⃣ **Usar a configuração em outra classe**

```java
import org.springframework.stereotype.Service;

@Service
public class MeuServico {

    private final MeuServicoConfig config;

    public MeuServico(MeuServicoConfig config) {
        this.config = config;
    }

    public void exibirConfiguracao() {
        System.out.println("Nome: " + config.getNome());
        System.out.println("URL: " + config.getUrl());
        System.out.println("Timeout: " + config.getTimeout());
    }
}
```

### 🎯 Conclusão
- `@ConfigurationProperties` facilita o carregamento e a organização de configurações.
- Usa um prefixo para agrupar as propriedades.
- Melhora a manutenibilidade da aplicação.

🔹 Dica: Para habilitar `@ConfigurationProperties`, adicione a anotação `@EnableConfigurationProperties` na classe principal do Spring Boot (caso não use @Component na classe de configuração). 🚀