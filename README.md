# DurgeshMicroservices



```
Config Server

In Config Server we host our configuration files over the server, Here we are using Git as a server, We put all the configuration files in Github & used directly from there.

+ always put common configuration in configuration files. all the common properties which are applicable to all the services.

Earlier we were hosting Configuration files Locally.

- It provides Client-Server architecture.

STEPS

1. Create a github repository contains all the configuration files.
2. Create Configuration Service with the dependencies mention below.
    2.1 Eureka Discovery Client
    2.2 Config Server
3. @EnableConfigServer   -    on Main class
4. Good to go.


Now Lets Implement Config Client. [User Service]

- add the config client dependency in the service in which you want to implement CONFIG CLIENT.
- Go to application.yml file and type 'spring.config.import.optional: configserver:http://localhost/8085' or 'spring.config.import= configserver:http://localhost/8085' // config server url.
- spring.profiles.active: profileName this is used to change the profile.
- Done!.



```





```diff
This is the Microservices based Java SpringBoot project.
In this project we are developing the Restaurant Feedback Application.

User can give ratings and feedback to the number of Restaurants.

In this project we have created Three Services and One Eureka Server to register our services.
1. User Service
2. Restaurant Service
3. Rating Service
4. Api Gateway

We can update the Ratings and Restaurants Service using User Service API.

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