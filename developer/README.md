# Microservice Developer

## Class Diagram

![](img/class-diagram.png)

## Build & Run with Docker Compose

### Build & Run:

```sh
docker-compose up --build -d && docker-compose logs -f
```

### Stop:

```sh
docker-compose down
```

## Build & Run with Docker

### Datasource:

> Launch PostgreSQL in a Docker container with:

```sh
docker run --name developer-postgresql -p 5433:5432 -e POSTGRES_DB=developer postgres:11.5-alpine
```

### Build:

```sh
docker build --tag developer:test --rm=true ..
```

### Run:

```sh
docker run -it --name developer --publish=8090:8090 developer:test
```

## Build & Run with Maven

### Datasource:

> Launch PostgreSQL in a Docker container with:

```sh
docker run --name developer-postgresql -p 5433:5432 -e POSTGRES_DB=developer postgres:11.5-alpine
```

### Build:

```sh
mvn clean install
```

### Run:

```sh
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

## Access

- Actuator: http://localhost:8090/actuator/health
- Swagger: http://localhost:8090/swagger-ui.html
- Database: jdbc:postgresql://localhost:5433/developer
  - User: postgres
  - Password:

## Dataset

### Developer table:

| id                                   | location       | nickname             | speciality |
| :----------------------------------- | :------------- | :------------------- | :--------- |
| 3bdfbba3-d472-4431-b9ac-c203e7505b8b | France         | veben                | java       |
| 4ca98fd9-927e-40e5-854b-392669f98204 | United Kingdom | Martijn Pieters      | python     |
| d15a5fb3-a157-4d13-ad2d-c8add8250e25 | France         | VonC                 | git        |
| 2f91c199-3ab4-4496-9ffa-5ae419b68f49 | United Kingdom | Marc Gravell         | c#         |
| 25230b5d-567d-4361-a2dd-03240378648e | United Kingdom | Quentin              | javascript |
| 99f3e575-a935-40ff-8890-9d57752d7694 | India          | anubhava             | regex      |
| 98e85368-fde3-42e1-9079-e9b6ac05df4a | Curaçao        | BalusC               | java       |
| 51ef449b-7cd0-4752-86b7-f1362af1d1b9 | Austria        | Günter Zöchbauer     | angular    |
| 9b88969f-06da-4cc8-a7b5-840093b9dc9c | Belgium        | Willem Van Onsem     | python     |
| d37f2850-9f02-4efc-9e3f-80a0d6a3b7f4 | United States  | CommonsWare          | android    |
| 0338663e-97b8-402f-b15c-55a776a0e22b | France         | JB Nizet             | java       |
| d69f0549-4c7b-45da-be90-95af26aff311 | United Kingdom | Jon Skeet            | c#         |
| daa00584-0c3a-43fb-85bd-f52eb3e2ffdf | Singapore      | BoltClock            | css        |
| 9e5145bd-a581-4404-9a79-9a08ebbc903b | Germany        | Gumbo                | php        |
| 04172846-150b-4b8d-ae7c-92f9b5d78bec | Sweden         | Some programmer dude | c++        |
| 7bc177f0-44f4-4eb6-b9a2-54c333daa053 | United Kingdom | CB Bailey            | git        |
