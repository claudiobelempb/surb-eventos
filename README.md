# Surb Eventos 2024

Java RESTful Api

## Diagramas de Classes

```mermaid
classDiagram
    Activity "1..*" -- "*" Participant
    Activity "*" -- "1" Category
    Activity "1" -- "1..1" Block
    class Activity{
      +Long id
      +String name
      +String description
      +Double price
    }
    class Category{
      +Long id
      +String description
    }
    class Block{
      +Long id
      +Instant startAt
      +Instant endAt
    }
    class Participant{
      +Long id
      +String name
      +String email
    }
```
