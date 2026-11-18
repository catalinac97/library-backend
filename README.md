Library Management System

Build a REST API for managing a library's books, authors, members, and loans.

Tech stack: Java 21, Spring Boot, Spring Data JPA, PostgreSQL, Maven, Flyway.

1. Entities

Author

- ID, name, email

Book

- ID, title, ISBN, active, author

Member

- ID, name, email

Loan

- ID, book, member, loan date, return date

Relationships

- One author can have multiple books.

- One book can have multiple loans over time.

- One member can have multiple loans.

2.  Requirements

Book ISBN must be unique. Member email must be unique. Books should use soft delete (active = false) instead of physical deletion of entries from the database.


- Get a book by id (already implemented).
- Get all active books with pagination (already implemented).
- Get a book by isbn. 
- Edit book name functionality
- Delete a book (soft delete, see comment above).
- Save new author functionality
- Save new book functionality
- Add Loan table using Flyway and create entity for it



