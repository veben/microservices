# Order

## Datasource settings
- PostgreSQL
    - Launch PostgreSQL in a Docker container with: `docker-compose up -d && docker-compose logs -f`
    - Intellij Settings > "View" > "Database"
            - Add datasource **PostgreSQL**: 
                - Name: order
                - User: postgres
                - Database: order
            - Right click on datasource > "Properties" > "Schema" > Check public schema

## Build
- LOCAL
    - Go to folder: `order`
    - Build with Maven : `mvn clean install -s settings.xml`
- DOCKER
    - Go to folder: `order`
    - Build with Docker `docker build --tag order:test --rm=true .`

## Run
- LOCAL
    - Go to folder: `order`
    - Run with Maven: `mvn spring-boot:run -Drun.profiles=local`
- DOCKER
    - Go to folder: `order`
    - Run with Docker: `docker run -it --name order --publish=8080:8080 order:test`

## API access
http://localhost:8080/swagger-ui.html