# Sporty Shoes - SimpliLearn Phase 3 Assessment

## Technologies Used

| Java | 1.8 |
| ------ | ------- |
| Spring Boot | 2.2.10 |
| Lombok  | --- |
| Swagger-ui | 2.7.0 |
| H2 | --- |
| JPA | --- |
| Spring Security Starter | --- | 


## File Structure

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── api
│   │           └── sportyShoes
│   │               ├── SportyShoes.java
│   │               ├── config
│   │               │   ├── SpringSecurityConfig.java
│   │               │   └── SwaggerConfig.java
│   │               ├── controller
│   │               │   ├── CRUDController.java
│   │               │   └── SearchController.java
│   │               ├── exceptionHandler
│   │               │   └── BusinessException.java
│   │               ├── model
│   │               │   ├── PurchaseReport.java
│   │               │   └── Shoe.java
│   │               ├── repository
│   │               │   ├── PurchaseReportRepository.java
│   │               │   └── ShoesRepository.java
│   │               └── service
│   │                   ├── SportyShoesService.java
│   │                   └── impl
│   │                       └── SportyShoesServiceImpl.java
│   └── resources
│       └── application.properties
└── test
    ├── java
    └── resources

16 directories, 13 files
```

## Project Structure

This project uses Spring Boot for Model and Controller Implementation
Availaible apis are -
  - /shoe (CRUD)
  - /purchaseReport (CRUD)
  - /shoe/all
  - /purchaseReport/(category|all|dop)

Current Implementation relies simply on String for storing order list.

It can be extended to utilize many-to-many relationship b/w Shoe and PurchaseReport Entities.

Also for admin authentication spring-security-starter has been used with credentials saved in `application.properties` file.

## Docs
For complete docs please use the docs folder in project directory.

Or Visit:[Docs Website](https://manish-baghel.github.io/sporty_shoes/)
‰
