# Microservices

## Technologies to configure to build and run in docker
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
            - Engine API URL: tcp/localhost:2375

## Technologies to configure to build and run in local
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