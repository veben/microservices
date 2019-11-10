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

<!DOCTYPE html>
<html>
<head>
  <title>Developer table</title>
</head>
<body>
<table border="1" style="border-collapse:collapse">
<tr><th>id</th><th>avatar</th><th>location</th><th>nickname</th><th>speciality</th></tr>
<tr><td>3bdfbba3-d472-4431-b9ac-c203e7505b8b</td><td>https://i.stack.imgur.com/kGFwM.png?s=128&amp;g=1</td><td>France</td><td>veben</td><td>java</td></tr>
<tr><td>4ca98fd9-927e-40e5-854b-392669f98204</td><td>https://www.gravatar.com/avatar/24780fb6df85a943c7aea0402c843737?s=128&amp;d=developerIdenticon&amp;r=PG</td><td>United Kingdom</td><td>Martijn Pieters</td><td>python</td></tr>
<tr><td>d15a5fb3-a157-4d13-ad2d-c8add8250e25</td><td>https://www.gravatar.com/avatar/7aa22372b695ed2b26052c340f9097eb?s=128&amp;d=developerIdenticon&amp;r=PG</td><td>France</td><td>VonC</td><td>git</td></tr>
<tr><td>2f91c199-3ab4-4496-9ffa-5ae419b68f49</td><td>https://i.stack.imgur.com/3vbu5.jpg?s=128&amp;g=1</td><td>United Kingdom</td><td>Marc Gravell</td><td>c#</td></tr>
<tr><td>25230b5d-567d-4361-a2dd-03240378648e</td><td>https://www.gravatar.com/avatar/1d2d3229ed1961d2bd81853242493247?s=128&amp;d=developerIdenticon&amp;r=PG</td><td>United Kingdom</td><td>Quentin</td><td>javascript</td></tr>
<tr><td>99f3e575-a935-40ff-8890-9d57752d7694</td><td>https://www.gravatar.com/avatar/dab08478b226280d4a30894c9a7ed719?s=128&amp;d=developerIdenticon&amp;r=PG</td><td>India</td><td>anubhava</td><td>regex</td></tr>
<tr><td>98e85368-fde3-42e1-9079-e9b6ac05df4a</td><td>https://www.gravatar.com/avatar/89927e2f4bde24991649b353a37678b9?s=128&amp;d=developerIdenticon&amp;r=PG</td><td>Curaçao</td><td>BalusC</td><td>java</td></tr>
<tr><td>51ef449b-7cd0-4752-86b7-f1362af1d1b9</td><td>https://i.stack.imgur.com/IlnZm.jpg?s=128&amp;g=1</td><td>Austria</td><td>Günter Zöchbauer</td><td>angular</td></tr>
<tr><td>9b88969f-06da-4cc8-a7b5-840093b9dc9c</td><td>https://i.stack.imgur.com/BJXub.png?s=128&amp;g=1</td><td>Belgium</td><td>Willem Van Onsem</td><td>python</td></tr>
<tr><td>d37f2850-9f02-4efc-9e3f-80a0d6a3b7f4</td><td>https://i.stack.imgur.com/wDnd8.png?s=128&amp;g=1</td><td>United States</td><td>CommonsWare</td><td>android</td></tr>
<tr><td>0338663e-97b8-402f-b15c-55a776a0e22b</td><td>https://www.gravatar.com/avatar/2f0d9dec16bae1e06552af55ddefc11f?s=128&amp;d=developerIdenticon&amp;r=PG</td><td>France</td><td>JB Nizet</td><td>java</td></tr>
<tr><td>d69f0549-4c7b-45da-be90-95af26aff311</td><td>https://www.gravatar.com/avatar/6d8ebb117e8d83d74ea95fbdd0f87e13?s=128&amp;d=developerIdenticon&amp;r=PG</td><td>United Kingdom</td><td>Jon Skeet</td><td>c#</td></tr>
<tr><td>daa00584-0c3a-43fb-85bd-f52eb3e2ffdf</td><td>https://www.gravatar.com/avatar/a2d818d801ce38a33807f68fdd92043a?s=128&amp;d=developerIdenticon&amp;r=PG</td><td>Singapore</td><td>BoltClock</td><td>css</td></tr>
<tr><td>9e5145bd-a581-4404-9a79-9a08ebbc903b</td><td>https://www.gravatar.com/avatar/cd501083459cbc21fccae78e2d03bee2?s=128&amp;d=developerIdenticon&amp;r=PG</td><td>Germany</td><td>Gumbo</td><td>php</td></tr>
<tr><td>04172846-150b-4b8d-ae7c-92f9b5d78bec</td><td>https://i.stack.imgur.com/9ZYta.jpg?s=128&amp;g=1</td><td>Sweden</td><td>Some programmer dude</td><td>c++</td></tr>
<tr><td>7bc177f0-44f4-4eb6-b9a2-54c333daa053</td><td>https://www.gravatar.com/avatar/a8db27c91db97757a829c7971fd62b84?s=128&amp;d=developerIdenticon&amp;r=PG</td><td>United Kingdom</td><td>CB Bailey</td><td>git</td></tr></table>
</body>
</html>
