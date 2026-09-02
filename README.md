# Clean Architecture - Sistema de Biblioteca

Projeto de **estudos** desenvolvido em **Java + Spring Boot**, criado com o objetivo de aplicar na prática os conceitos de **Clean Architecture** propostos por Robert C. Martin (Uncle Bob). A aplicação simula o backend de uma biblioteca, com o gerenciamento de **livros, membros, empréstimos, reservas e multas**.

> ⚠️ Este é um projeto em evolução, feito para consolidar conhecimento sobre arquitetura de software. Ainda existem pontos a melhorar (cobertura de testes, tratamento de exceções mais refinado, documentação de API, entre outros), mas a estrutura já reflete bem os princípios da arquitetura estudada.

---

## 🎯 Por que estudar Clean Architecture?

Clean Architecture é um estilo arquitetural que organiza o código em **camadas concêntricas**, separando claramente as regras de negócio da aplicação dos detalhes de infraestrutura (banco de dados, frameworks, APIs, UI, etc).

Entender e aplicar esses conceitos é importante porque:

- **Baixo acoplamento**: as regras de negócio não dependem de frameworks, bibliotecas ou banco de dados.
- **Testabilidade**: como o núcleo da aplicação (domínio e casos de uso) não depende de detalhes externos, fica muito mais fácil escrever testes unitários.
- **Manutenibilidade**: trocar o banco de dados, o framework web ou qualquer detalhe de infraestrutura não deveria (idealmente) impactar as regras de negócio.
- **Escalabilidade do time**: times diferentes podem trabalhar em camadas diferentes sem gerar conflitos constantes.
- **Independência de frameworks**: o Spring, por exemplo, é um "detalhe" — ele entrega dados para a aplicação, mas não dita como as regras de negócio funcionam.

Mais do que seguir uma "receita de bolo", o valor de estudar essa arquitetura está em desenvolver a capacidade de **pensar em fronteiras e responsabilidades** dentro de um sistema.

---

## 🧱 Estrutura do projeto

O projeto foi organizado em pacotes que representam as camadas da Clean Architecture:

```
com.example.clean_arquitecture
│
├── core/                     → Núcleo da aplicação (regras de negócio)
│   ├── <feature>/domain/     → Entidades de domínio (Book, Member, Loan, Reservation, Fine)
│   ├── <feature>/useCase/    → Casos de uso (regras de negócio da aplicação)
│   └── <feature>/dataprovider (ou contracts)/ → Interfaces (contratos) de repositório
│
├── dataprovider/              → Implementação dos repositórios (acesso a dados - MongoDB)
│
└── entrypoint/                → Camada de entrada e saída da aplicação
    ├── controllers/           → Endpoints REST
    ├── service/                → Orquestração entre controllers e use cases
    ├── dtos/                    → Objetos de request/response
    ├── mappers/                 → Conversão entre Domain <-> DTO <-> Entity
    ├── persistence/             → Entidades de persistência (Mongo)
    └── exceptions/               → Tratamento de exceções
```

### Camadas e responsabilidades

| Camada | Responsabilidade |
|---|---|
| **domain** | Entidades puras de negócio (`Book`, `Member`, `Loan`...), sem dependência de frameworks. |
| **useCase** | Uma classe por ação de negócio (`SaveBook`, `DeleteBookById`, `GetListBook`...), seguindo o princípio de responsabilidade única. |
| **dataprovider (interface)** | Contratos (`BookRepository`, `LoanRepository`...) que definem *o que* precisa ser feito, sem dizer *como*. |
| **dataprovider (implementação)** | Implementação concreta dos contratos usando Spring Data MongoDB. |
| **entrypoint** | Tudo que é "porta de entrada/saída": controllers, DTOs, mappers e persistência. |

---

## 🔄 Inversão de Dependência (Dependency Inversion)

Esse é um dos pilares mais importantes aplicados no projeto e um dos princípios do **SOLID** (o "D").

A ideia central é: **módulos de alto nível (regras de negócio) não devem depender de módulos de baixo nível (detalhes de implementação). Ambos devem depender de abstrações.**

No projeto, isso é feito assim:

1. O **core** define uma interface, por exemplo:

```java
// core/book/dataprovider/BookRepository.java
public interface BookRepository {
    Book save(Book book);
    List<Book> getAllBooks();
    Optional<Book> findBookById(String id);
    void delete(String id);
}
```

2. O caso de uso depende **apenas dessa interface**, nunca da implementação:

```java
// core/book/useCase/SaveBook.java
@Component
@RequiredArgsConstructor
public class SaveBook {
    private final BookRepository bookRepository; // depende da abstração

    public Book execute(BookRequest request) {
        Book book = bookMapper.toRequestToEntity(request);
        bookRepository.save(book);
        return book;
    }
}
```

3. Quem implementa essa interface está na camada de infraestrutura (`dataprovider`), usando MongoDB através do Spring Data:

```java
// dataprovider/book/BookRepositoryImpl.java
@Repository
public class BookRepositoryImpl implements BookRepository {
    // implementação concreta usando MongoTemplate e MongoRepository
}
```

Note que o fluxo de dependência aponta **de fora para dentro**: `dataprovider` conhece o `core`, mas o `core` **não sabe** que existe um MongoDB, um `MongoTemplate` ou qualquer outra tecnologia. Se um dia o banco de dados mudar (para PostgreSQL, por exemplo), basta criar uma nova implementação da interface — as regras de negócio permanecem intactas.

Isso é possível graças à **injeção de dependência** feita automaticamente pelo Spring: como `BookRepositoryImpl` é anotada com `@Repository` e implementa `BookRepository`, o Spring injeta a implementação correta onde a interface é requisitada, sem que o caso de uso precise conhecer os detalhes.

---

## ✅ Princípios aplicados

- **Separation of Concerns** — cada camada tem uma responsabilidade clara e isolada.
- **Dependency Inversion Principle (DIP)** — o core depende de abstrações, não de implementações.
- **Single Responsibility Principle (SRP)** — cada *use case* representa uma única ação de negócio.
- **Independência de frameworks** — as entidades de domínio (`core/*/domain`) são POJOs simples, sem anotações do Spring ou do MongoDB.

---

## 🛠️ Tecnologias utilizadas

- **Java 17**
- **Spring Boot** (Web MVC)
- **Spring Data MongoDB**
- **MongoDB** (via Docker Compose)
- **Lombok**
- **Maven**

---

## ▶️ Como rodar o projeto

```bash
# Subir o banco de dados (MongoDB)
docker compose up -d

# Rodar a aplicação
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080/api/v1/...`, com endpoints para `book`, `member`, `loan`, `reservation` e `fine`.

---
