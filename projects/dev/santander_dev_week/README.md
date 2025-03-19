# Santander Dev Week
Java RESTful API criada para a Santander Dev Week
## Diagrama de classes
```mermaid
classDiagram
    class User {
        - String name
        - Account account
        - Feature[] features
        - Card card
        - News[] news
    }

    class Account {
        - String accountNumber
        - String accountAgency
        - float accountLimit
        - float balance
    }

    class Feature {
        - String icon
        - String description
    }

    class Card {
        - String number
        - float limit
    }

    class News {
        - String icon
        - String description
    }

    User "1" *-- "1" Account
    User "1" *-- "N" Feature : contains
    User "1" *-- "1" Card
    User "1" *-- "N" News : contains
```