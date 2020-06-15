# MS front

## Build & Run with Docker Compose

### Build & Run:

```sh
docker-compose up --build -d && docker-compose logs -f
```

### Build & Run (using **Docker BuildKit**)

> Unix version

```sh
COMPOSE_DOCKER_CLI_BUILD=1 DOCKER_BUILDKIT=1 docker-compose up --build -d && docker-compose logs -f
```

> Windows version

```sh
set "COMPOSE_DOCKER_CLI_BUILD=1" & set "DOCKER_BUILDKIT=1" & docker-compose up --build -d && docker-compose logs -f
```

## Build & Run with Docker

### Build:

> Unix version

```sh
DOCKER_BUILDKIT=1 docker build --tag ms-front:test --rm=true .
```

> Windows version

```sh
set "DOCKER_BUILDKIT=1" & docker build --tag ms-front:test --rm=true .
```

### Run:

```sh
docker run -it --name ms-front --publish=80:80 ms-front:test
```

## Install dependencies & Run with npm

### Install dependencies:

```sh
npm install
```

### Run:

```sh
npm start
```

## Build locally:

```sh
npm build
```

## Access

With `Docker` deployment: http://localhost

With `Local` deployment: http://localhost:4200
