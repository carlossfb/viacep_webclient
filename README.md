# Getting Started

##### Create a docker image from Dockerfile

```bash
    docker build -t reactive-viacep:1.0.0 .
```
#### Run application

```bash
    docker run --name reactive-viacep_container -p 8080:8080 -d reactive-viacep:1.0.0
```

#### /api/{cep}

```json
    {
      "cep": "03252-000",
      "logradouro": "Rua Barbeiro de Sevilha",
      "complemento": "",
      "bairro": "Vila Rosa Molla",
      "localidade": "São Paulo",
      "uf": "SP",
      "ibge": "3550308",
      "gia": "1004",
      "ddd": "11",
      "siafi": "7107",
      "_links": {
        "self": {
          "href": "http://localhost:8080/api/03252000"
        }
      }
    }
```

#### Create a build (and change name of JAR) for use in Docker container (Example POM)

```bash
   mvn clean package
```

```xml
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
		<finalName>application</finalName> *Name of JAR file*
	</build>
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

