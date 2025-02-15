# 📄 O que é o `application.properties` ou `application.yml` no Spring Boot?

O arquivo de propriedades (application.properties ou application.yml) no Spring Boot é utilizado para configurar a aplicação sem precisar modificar o código-fonte. Ele permite definir parâmetros como:

* ✅ Configurações de banco de dados
* ✅ Porta do servidor
* ✅ Configurações de logs
* ✅ Perfis de ambiente (dev, prod, test)
* ✅ Configurações personalizadas

## 🎯 Como acessar propriedades no código?
O Spring permite acessar as configurações definidas no `application.properties` ou `application.yml` usando a anotação `@Value` ou a classe `@ConfigurationProperties`.

## 🔥 Conclusão
`application.properties` e `application.yml` configuram a aplicação sem alterar o código.
Podemos acessar as configurações com `@Value` ou `@ConfigurationProperties`.
Perfis permitem diferentes configurações para ambientes distintos (ex: dev, prod).

Com isso, sua aplicação fica mais flexível e fácil de gerenciar! 🚀🔥