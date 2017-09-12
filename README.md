# Sample spring boot rest application using Kotlin #

This is a sample spring boot REST application using [Kotlin](https://kotlinlang.org) language (A new JVM language, 
developed by [Jetbrains]
(https://www.jetbrains.com))

Application is bootstrapped using [Spring Initializr](http://start.spring.io)

#### Modules used ####
* Web - for exposing the REST endpoints
* JPA - for ORM and database operations
* H2 - in memory database used for testing

#### Endpoints ####

REST endpoints for performing different CRUD (Create, Read, Update, Delete) operations on Movie entity.

* PUT - /moviedb/api/movie
* GET - /moviedb/api/movie/all
* GET - /moviedb/api/movie/{movieId}
* GET - /moviedb/api/movie/name/{movieName}
* POST - /moviedb/api/movie/{movieId}
* DELETE - /moviedb/api/movie/{movieId}

#### To build and run the application ####
```text
mvn clean install -Dmaven.test.skip=true
```

#### Tools used ####
* IntelliJ IDEA
* Git
* Postman