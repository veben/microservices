# Order

## Build & Run with Maven
- Datasource:
    - Launch PostgreSQL in a Docker container with: `docker run --name order-postgresql-database -p 5432:5432 -e POSTGRES_DB=order postgres:11.5-alpine`
- Build
    - Go to folder: `order`
    - Build with Maven : `mvn clean install -s settings.xml`
- Run
    - Go to folder: `order`
    - Run with Maven: `mvn spring-boot:run -Drun.profiles=local`

## Build & Run with Docker
- Datasource:
    - Launch PostgreSQL in a Docker container with: `docker run --name order-postgresql-database -p 5432:5432 -e POSTGRES_DB=order postgres:11.5-alpine`
- Build
    - Go to folder: `order`
    - Build with Docker `docker build --tag order:test --rm=true .`
- Run
    - Go to folder: `order`
    - Run with Docker: `docker run -it --name order --publish=8080:8080 order:test`

## Build & Run with Docker Compose
- Go to folder: `order`
- Build with Docker Compose: `docker-compose up --build -d && docker-compose logs -f`

## Datasource access
- Intellij
    - Intellij Settings > "View" > "Database"
        - Add datasource **PostgreSQL**: 
            - Name: order
            - User: postgres
            - Database: order
        - Right click on datasource > "Properties" > "Schema" > Check public schema

## API access
http://localhost:8080/swagger-ui.html