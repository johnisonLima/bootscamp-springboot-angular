#### No Spring, o escopo de um bean define o ciclo de vida e quantas instâncias desse bean serão criadas e gerenciadas pelo container do Spring.

Os dois escopos mais comuns no Spring Boot são:
1. Singleton (Padrão)
2. Prototype

## 🏛️ 1️⃣ Singleton (@Scope("singleton"))
### 🔹 O que é?
* O Singleton é o escopo padrão no Spring.
* Apenas uma instância do bean é criada e compartilhada para todas as injeções dentro do contexto da aplicação.

🔹 Como o Spring já usa singleton por padrão, não precisamos da anotação @Scope("singleton").

## 🏗️ 2️⃣ Prototype (@Scope("prototype"))
### 🔹 O que é?
* Um novo bean é criado toda vez que ele é solicitado.
* Cada injeção recebe uma nova instância.

## 📊 Principais Diferenças
| Característica         | Singleton                          | Prototype                          |
|------------------------|------------------------------------|------------------------------------|
| Instância criada       | Uma única vez (compartilhada)      | Sempre que solicitado              |
| Ciclo de vida          | Criado no startup da aplicação     | Criado e descartado conforme necessário |
| Gerenciado pelo Spring | Sim                                | Apenas na criação, depois não é gerenciado |
| Uso comum              | Serviços e repositórios            | Objetos temporários e dinâmicos    |

## 🎯 Quando usar cada um?
* ✅ Singleton → Quando o bean deve ser único e compartilhado, como serviços (@Service) e repositórios (@Repository).
* ✅ Prototype → Quando o bean deve ser criado novamente a cada uso, como objetos de configuração dinâmica ou sessões temporárias.

Se precisar de múltiplas instâncias, use @Scope("prototype"), mas lembre-se de que o Spring não gerencia seu ciclo de vida depois da criação! 🚀