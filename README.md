# Getting Started

##### Create a docker image from Dockerfile

```bash
    docker build -t reactive-viacep:1.0.0 .
```
#### Run application

```bash
    docker run --name reactive-viacep_container -p 8080:8080 -d reactive-viacep:1.0.0
```


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.0/maven-plugin/reference/html/#build-image)
* [Spring HATEOAS](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#web.spring-hateoas)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#web.reactive)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a Hypermedia-Driven RESTful Web Service](https://spring.io/guides/gs/rest-hateoas/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)

