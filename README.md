[![Build Status](https://travis-ci.org/hatorach/tcrs.svg?branch=master)](https://travis-ci.org/hatorach/tcrs)

# TCRS - Tennis Court Reservation System
This is a web-based reservation system for tennis courts.

There is no working code yet.

For the first version we are planning to provide a complete web-based application in Angular2 and Spring which can be run in a Docker container.

So far following features are planned:

- online reservation for tennis courts (main requirement)
- multiple clubs with club-admin role
- multiple courts per club
- user registration with Facebook Connect and Google Authentication

## Installation
For running TCRS you require

* JDK 8
* Current version of Node.js
* SASS Compiler

Install angular-cli and the required node modules by

    $ npm install -g angular-cli
    $ npm install
    
A running mysql instance with , you can setup it very quickly by:

    $ docker run -dit \
      -e MYSQL_ALLOW_EMPTY_PASSWORD=1 \
      -e MYSQL_DATABASE=tcrs \
      --name mysql -p 3306:3306 mysql

### Run application
Finally run

    $ npm start

which will start `ng serve`.

To start Spring you have to run in parallel to npm:

    $ ./gradlew bootRun

This starts the included gradle wrapper that does the rest for you. Spring will be started on port 8080 with an embedded MongoDb instance.

### Verification
To verify everything is correct, point your browser to

    $ http://localhost:8080
