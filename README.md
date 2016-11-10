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
