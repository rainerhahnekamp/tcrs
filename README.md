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

Install jspm & gulp globally and local node modules by:

    $ npm install -g jspm gulp
    $ npm update

### Prerequisites
Next let jspm update system.js, install jspm dependencies and run a customized script that is a workaround for [issue 6012](https://github.com/Microsoft/TypeScript/issues/6012) of the TypeScript compiler

    $ jspm update
    $ ./node_modules/gulp/bin/gulp jspmFix

### Run application
Finally run

    $ gulp

which will compile all TypeScript and SASS files from app/src to bundle/src and links that directory to src/main/webapp where it is served from Spring.
To start Spring you have to run in parallel to gulp:

    $ ./gradlew bootRun

This starts the included gradle wrapper that does the rest for you. Spring will be started on port 8080 with an embedded MongoDb instance.

### Verification
To verify everything is correct, point your browser to

    $ http://localhost:8080
