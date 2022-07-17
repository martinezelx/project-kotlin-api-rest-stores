# Kotlin - Spring Boot Rest API that manages stores information

## Tech Stack
- IDE: IntelliJ IDEA Community Edition (2022.1.3)
- Kotlin 1.7.10
- Spring Boot: 2.7.1
- SpringDoc OpenApi
- Maven 3.8.4
- H2 Database
- Mockito Kotlin

## Prerequisites to test/run the application
- Kotlin 1.7.10
- Java 11
- Maven 3.8.4

## Run tests
You can use your favorite IDE to run the tests or use the following command:
```shell
mvn test
```

## Run the application
1. Clone the repository
2. In the cloned folder repository, run the following command:
```shell
mvn spring-boot:run
```

## Available endpoints
Since the project uses SpringDoc OpenApi, we can see the available endpoints at the following link:

[http://localhost:8090/swagger-ui/index.html](http://localhost:8090/swagger-ui/index.html)

[Example of the first time you access Swagger UI](./readme-resources/img/01-swagger-ui.png)
![Screenshot](/readme-resources/img/01-swagger-ui.PNG)

### Examples to call the endpoints
You can use the HTTP client of your choice to call the endpoints. In the next examples I will use Postman to perform the requests.

Using the [import feature of Postman](https://learning.postman.com/docs/getting-started/importing-and-exporting-data/) you can import the OpenAPI definition from the following link: [http://localhost:8090/v3/api-docs](http://localhost:8090/v3/api-docs)

#### Get all stores
- `GET /api/v1/stores/get`

#### Get store by id
- `GET /api/v1/stores/get/{id}`

#### Delete store by id
- `DELETE /api/v1/stores/delete/{id}`

#### Update store by id
- `DELETE /api/v1/stores/update/{id}`

#### Create a new store
- `POST /api/v1/stores/save`

`example:`
```json
{
  "id": 4,
  "name": "new store",
  "country": "ES",
  "city": "new city",
  "address": "new address",
  "status": "CLOSE",
  "type": "MEDIUM_CAP"
}
```
