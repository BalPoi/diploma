# e-Scooter Sharing API

## Description

REST API for kicksharing. This is the backend of my thesis.

Technologies used:
* Java 17
* Spring Boot 2.7.10
* PostgreSQL
* Liquibase
* Lombok
* ModelMapper
* SpringFox (Swagger UI)
* jUnit 5
* Mockito

---

## Setup Guide

1. Clone repository
```shell
git clone https://github.com/BalPoi/diploma.git
```
2. Change database connection details in `src/main/resources/application.yml`
```yaml
datasource:
    url: ${DB_URL}
    driver-class-name: org.postgresql.Driver
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
```
where
- ${DB_URL} - string like `jdbc:postgresql://localhost:5432/DATABASE_NAME`
- ${DB_USERNAME} - database username  
- ${DB_PASSWORD} - database user password  
- org.postgresql.Driver - JDBC driver class for PostgreSQL
> You can use another DB, but it will require adding additional dependency into the pom.xml  
> Feel free to do it, if you know how.
3. Run `./mvnw spring-boot:run`
4. Visit http://localhost:8080/swagger-ui/index.html to view Swagger UI documentation
