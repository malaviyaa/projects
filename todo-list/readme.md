

## project build and run
mvn clean install && mvn spring-boot:run

## Why certain approaches were used, why others were not selected
Created spring boot microservice so that it could be deployed and manged independently.
As it would be loosely coupled process to integrate with ui or any other app over REST

##  Any design patterns used
DAO patterns are used for repositories and Inversion of Control to Autowire service.

## Anything extra you would have done give more time
Multiple user session management with Spring security.
Input validation

# url 
http://localhost:8080/todo/
