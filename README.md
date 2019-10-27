# Microservices

## Technologies to configure to build and run with docker
- Docker Desktop for Windows
    - Download & install
    - Know your current version : `docker --version`
    - Docker settings
        - Shared drives **C**
        - Expose deamon on **tcp://localhost:2375**
    - Intellij settings > "Build, Execution, Deployment" > "Docker"
        - Change configuration: 
            - Name: Docker
            - TCP socket: checked
            - Engine API URL: `tcp/localhost:2375`

## Technologies to configure to build and run without docker
- JDK : openjdk-11.0.4
    - Download & install
    - Create env var: **JAVA_HOME**=‪`C:\Env\tools\jdk\openjdk-11u-11.0.4_11`
	- Add `%JAVA_HOME%\bin` to **Path** env var
    - Know your current version: `java -version`
- Maven 3.6.2
    - Download & install
    - Create env var: **M3_HOME**=`C:\Env\tools\apache-maven-3.6.2`
	- Add `%M3_HOME%\bin` to **Path** env var
    - Know your current version: `mvn -version`

## Launch just some Microservices
- Follow : 
    - [Developer MS](developer/README.MD)
    - [Order MS](order/README.MD)

## Manage the whole project with Docker Compose
- Start: `docker-compose up --build -d && docker-compose logs -f`
- Stop: `docker-compose down`

## Clean containers and images
- With Git bash or bash for Windows: 
    - `docker stop $(docker ps -a -q) && docker rm $(docker ps -a -q) && docker image prune -f`
    
## Troubleshooting
- The following ports have not to be in use: 8090, 8091, 5433,  5434