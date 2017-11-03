# Simple Logic Interpreter [![Build Status](https://travis-ci.org/abrden/7510-TP1-Java.svg?branch=master)](https://travis-ci.org/abrden/7510-TP1-Java) [![codecov](https://codecov.io/gh/abrden/7510-TP1-Java/branch/master/graph/badge.svg)](https://codecov.io/gh/abrden/7510-TP1-Java)

A Java library designed to serve as a logic interpreter.

## Prerequisites

- Java >= 1.8.0_131 (Java 8)
- Maven >= 3.3.9

## Tests
```
$ mvn clean compile test
```

## Usage
Clone the project
```
$ git clone https://github.com/abrden/7510-TP1-Java.git
$ cd 7510-TP1-Java/
```
Build the project
```
$ mvn clean install
```

Write your database a file (there's some examples [here](https://github.com/abrden/7510-TP1-Java/tree/master/src/main/resources)) and run the interpreter with it's path.
For example:
```
$ java -jar target/rulogic-0.0.1-SNAPSHOT.jar src/main/resources/numbers.db
```
Make any query
```
add(2, 2, 1)
(SLI) false
add(1, 1, 2)
(SLI) true
```
Press 'q' to exit.
