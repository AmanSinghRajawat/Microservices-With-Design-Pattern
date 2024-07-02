# DurgeshMicroservices

```diff
This is the Microservices based Java SpringBoot project.
In this project we are developing the Restaurant Feedback Application.

User can give ratings and feedback to the number of Restaurants.

In this project we have created Two Services.
1. User Service
2. Restaurant Service

Dependency We Used :

JPA
MySQL 
Spring Web

DATABASE We Used :

MySQL Workbench

We have created durgeshuserservice SCHEMA.

```

#### User Service

```diff

In User Service we used given application.yml file.

+ application.yml file

server:
  port: 8081
  
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/durgeshuserservice
    username: root
    password: root
  application:
    name: USER-SERVICE

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    database-platform: org.hibernate.dialect.MySQLDialect


+ // END of application.yml file.

```




