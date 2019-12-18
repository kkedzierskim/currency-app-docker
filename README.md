# CurrencyApp

A web application for viewing and analyzing currency exchange rates. 
The application is powered by data available from API of the National Bank of Poland api.nbp.pl

## Techonolgies included
* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 
* [Maven](https://maven.apache.org/)
* [Spring (Boot, MVC, Data JPA)](https://spring.io)
* [MySQL](https://www.mysql.com/)  
* [Swagger](https://swagger.io/) 
* [Docker](https://www.docker.com/) 


currently implemented features:
- processing data from nbp api
- scheduled method updating data every 24h
- saving every request at database
- list of all available currencies and it's exchange rates
- conversion based on the exchange rate for the following parameters: amount from which currency, to which currency


documentation:
http://localhost:8080/swagger-ui.html

to run application on docker container:
docker-compose up
