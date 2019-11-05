# MS front

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

### Build:

```sh
docker build --tag ms-front:test --rm=true .
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
