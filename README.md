# Microservices Design Patter.

```diff
This is the Microservices based Java SpringBoot project.
In this project we are developing the Restaurant Feedback Application.

User can give ratings and feedback to the number of Restaurants.

In this project we have created Three Services and One Eureka Server to register our services.
1. User Service
2. Restaurant Service
3. Rating Service

Dependency We Used for Eureka Service :

Eureka Server.

Dependency We Used for all three Services :

JPA
MySQL 
Spring Web
Eureka Client

DATABASE We Used :

MySQL Workbench

We have created durgeshuserservice SCHEMA for User Service.

We have created durgeshratingservice SCHEMA for Rating User Service.

We have created durgeshrestaurantservice SCHEMA for Restaurant Service.


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

#### Rating Service

```diff

In Rating Service we used given application.yml file.

+ application.yml file

server:
  port: 8083
  
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/durgeshratingservice
    username: root
    password: root
  application:
    name: RATING-SERVICE

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    database-platform: org.hibernate.dialect.MySQLDialect

+ // END of application.yml file.

```

#### Restaurant Service

```diff

In Restaurant Service we used given application.yml file.

+ application.yml file

server:
  port: 8082
  
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/durgeshrestaurantservice
    username: root
    password: root
  application:
    name: RESTAURANT-SERVICE

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    database-platform: org.hibernate.dialect.MySQLDialect

+ // END of application.yml file.

```
