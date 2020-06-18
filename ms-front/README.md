# MS front

![](https://github.com/veben/microservices/workflows/MS-front-CI/badge.svg)

## II. Run application

### 1. First (easy) possibility: run it with Docker Compose
Launch the application inside a Docker container, based on the following [image](https://hub.docker.com/repository/docker/veben/mas-front), hosted in Docker hub.
```sh
docker-compose up
```

### 2. Second possibility: run it with Docker
```sh
docker run -it --name ms-front --publish=80:80 veben/ms-front:latest
```

### 3. Third possibility: run it locally with npm

#### Install dependencies:
```sh
npm install
```

#### Run:
```sh
npm start
```


## III. Access
With `Docker` deployment: http://localhost

With `Local` deployment: http://localhost:4200
