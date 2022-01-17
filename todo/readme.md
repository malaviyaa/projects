

## project build and run
mvn clean install && mvn spring-boot:run

## Why certain approaches were used, why others were not selected
Did not create UI as separate microservice due to time constraint.
Ideal way would have been to create api and UI as a separate springboot and angular projects.
so both could be managed and deployed independent of each other.

##  Any design patterns used
mvc and dao patterns are used. repositories as DAO's and controller spring , view jsp and model as entities alongwith Spring mvc is used.

## Anything extra you would have done give more time
exception handling.
separate ui logic.
logging.
unit tests using mockito.
multiple user session management.

# url 
http://localhost:8080/
username - test
pass - pwd123