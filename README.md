# 🎓 Student Management REST API

A Spring Boot REST API for managing student records using **Spring Data JPA and MySQL**. This project was built as part of my **50 Days Java + Spring Boot Mini Project Challenge** to learn database persistence and improve my REST API development skills.

## 🚀 Features

* Create a student
* Get students
* Filter students by age, course, and department
* Update student details
* Delete a student
* Automatic ID generation
* MySQL database persistence
* Request validation
* Custom exception handling
* Global exception handling
* Type mismatch error handling
* Custom error responses
* Proper HTTP status codes
* REST API design

## 🛠️ Technologies Used

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL
* Jakarta Validation
* Maven
* Lombok

## 📚 What I Learned

### 1. JPA Entity

Learned how to map a Java class to a database table using:

```java
@Entity
```

The `Student` class represents the student table in the database.

### 2. Primary Key

Used:

```java
@Id
```

to identify the primary key of the student entity.

### 3. Automatic ID Generation

Used:

```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
```

to allow the database to generate student IDs automatically.

### 4. Spring Data JPA

Learned how Spring Data JPA simplifies database operations without manually writing SQL for basic operations.

Used repository operations such as:

```text
save()
findAll()
findById()
deleteById()
```

### 5. Repository Layer

Implemented the architecture:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
JPA / Hibernate
    ↓
MySQL
```

The repository is responsible for interacting with the database.

### 6. Optional and `orElseThrow()`

Learned how `findById()` returns an `Optional` and how to handle missing students using:

```java
orElseThrow()
```

### 7. Database Persistence

Unlike my previous in-memory projects, student data is stored in **MySQL**, so the data remains available after restarting the application.

### 8. Request Validation

Used Jakarta Validation annotations such as:

```text
@NotBlank
@NotNull
@Positive
@Size
```

to validate incoming student data.

### 9. Global Exception Handling

Implemented:

```java
@RestControllerAdvice
```

and:

```java
@ExceptionHandler
```

to handle application exceptions in one centralized location.

### 10. Custom Exceptions

Created:

```text
StudentNotFoundException
```

to handle requests for students that don't exist.

### 11. Validation Error Handling

Handled validation failures and converted them into a custom error response containing field-level validation messages.

### 12. Type Mismatch Handling

Handled:

```text
MethodArgumentTypeMismatchException
```

for invalid query parameter types and returned a `400 BAD REQUEST` response.

### 13. Custom Error Response

Created a reusable error response containing:

```text
status
timestamp
message
validation errors
```

### 14. Filtering

Implemented optional filtering through query parameters:

```text
GET /students?age=21
GET /students?course=B.Tech
GET /students?department=CSE
```

The service determines which repository query should be executed based on the provided parameters.

## 📡 API Endpoints

| Method | Endpoint         | Description         |
| ------ | ---------------- | ------------------- |
| POST   | `/students`      | Create a student    |
| GET    | `/students`      | Get/filter students |
| PUT    | `/students?id=1` | Update a student    |
| DELETE | `/students?id=1` | Delete a student    |

### Filtering Examples

```text
GET /students?age=21
```

```text
GET /students?course=B.Tech
```

```text
GET /students?department=CSE
```

## 📦 Sample Request

### Create Student

```json
{
  "name": "Madhav Rao",
  "email": "madhav@example.com",
  "age": 21,
  "department": "CSE",
  "course": "B.Tech",
  "phonenumber": "9876543210"
}
```

The `id` is generated automatically by the database.

## 🏗️ Project Structure

```text
src/main/java/com/mini/StudentManagement

├── controller
│   └── StudentController.java
│
├── entity
│   └── Student.java
│
├── repository
│   └── StudentRepository.java
│
├── service
│   └── StudentService.java
│
└── exception
    ├── ErrorResponse.java
    ├── GlobalExceptionHandler.java
    └── StudentNotFoundException.java
```

## 🎯 Day 5 Learning Progress

This project represents the transition from simple in-memory REST APIs to database-backed Spring Boot applications.

### Day 4

```text
Controller
    ↓
Service
    ↓
ArrayList
```

### Day 5

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Spring Data JPA
    ↓
Hibernate
    ↓
MySQL
```

This project helped me understand how Spring Boot applications interact with a relational database using JPA and Spring Data JPA.

## 🔮 Future Improvements

* Improve multi-parameter filtering
* Add pagination
* Add sorting
* Add more advanced JPA queries
* Add Swagger/OpenAPI documentation
* Add unit tests
* Add integration tests
* Add authentication and authorization

---

**Day 5/50 — Java + Spring Boot Mini Project Challenge 🚀**
