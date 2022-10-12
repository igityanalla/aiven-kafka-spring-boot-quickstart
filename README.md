# Aiven Kafka Quickstart with Spring Boot

This repository contains a proof of concept Spring Boot application for Aiven Apache Kafka. The associated blog post can be found here:
https://docs.google.com/document/d/1Z66hcYn5ohVf_ebpMwOUj7rxjsFQy4FhXTLHLxfeR1k/edit?usp=sharing

Make sure you sign up for your [free 30 day trial for Aiven](https://console.aiven.io/signup).


## Requirements

For building and running the application you need:

- [JDK](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `io.aiven.quickstart.QuickstartApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
