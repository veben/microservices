# Microservices

> Created and maintained by veben

![](https://github.com/veben/microservices/workflows/Developer-CI/badge.svg)
![](https://github.com/veben/microservices/workflows/Developer-information-CI/badge.svg)
![](https://github.com/veben/microservices/workflows/MS-front-CI/badge.svg)

# 📜 Table of Contents
1. [Tools Setup](#tools-setup)
2. [Build & Launch](#build-launch)
3. [Browse to the app](#browse-to-the-app)
4. [Manage containers](#manage-containers)
5. [Stop & Clean](#stop-clean)
6. [Microservice Developer in depth](developer/README.md)
7. [Microservice Developer Informations in depth](developer-information/README.md)
8. [Front-end MS-Front in depth](ms-front/README.md)
9. [Troubleshooting](#troubleshooting)

## ⚙ Tools Setup <a name="tools-setup"></a>

#### 🐳 Docker Desktop for Windows

- [Download](https://download.docker.com/win/stable/Docker%20Desktop%20Installer.exe)
- Install
  > Check your current version:

```sh
 docker --version
```

- Docker settings
  - Shared drives **C**
  - Expose deamon on **tcp://localhost:2375**
- Intellij settings (Optional) `"Build, Execution, Deployment" > "Docker"`
  - Change configuration:
    - Name: Docker
    - TCP socket: checked
    - Engine API URL: `tcp/localhost:2375`

## 🔧 Build & 🚀 Launch <a name="build-launch"></a>

To manage the whole project with **Docker Compose** using just few commands

> ⚠ The first one build is very long

### With experimental **Docker BuildKit**:

> Unix version

```sh
COMPOSE_DOCKER_CLI_BUILD=1 DOCKER_BUILDKIT=1 docker-compose up --build -d && docker-compose logs -f
```

> Windows version

```sh
set "COMPOSE_DOCKER_CLI_BUILD=1" & set "DOCKER_BUILDKIT=1" & docker-compose up --build -d && docker-compose logs -f
```

### Without **Docker BuildKit**

```sh
 docker-compose up && docker-compose logs -f
```

## 💻 Browse to the app <a name="browse-to-the-app"></a>

http://localhost

## 🐳 Manage containers <a name="manage-containers"></a>

> 🛈 Once everything is up, you can manage containers with **Portainer**.

Just enter the following address on a browser: http://localhost:9000

> 🛈 You have to define a password for Portainer user.

The front-end only know **Developer** Microservice.
**Developer Information** Microservice is called by **Developer** Microservice with a REST call.
You can try some different scenarios:

1- Kill the _developer_ container and launch the app => you cannot have access to developers.

2- Relaunch the _developer_ container => everything's now ok.

3- Kill the _developer-posgresql_ container => you cannot have access to developers too, but the error is different.

4- Relaunch the _developer-posgresql_ container => everything's now ok.

5- Kill the _developer-information_ container => you cannot have access to developer informations

6- Relaunch the _developer-information_ container => everything's now ok.

7- Kill the _developer-information-mongodb_ container => you cannot have access to developer informations, but the error is different.

> 🛈 The **Order** Microservice is present but still unused by the app nor for one of the other services.

## ✋ Stop & 🚿 Clean <a name="stop-clean"></a>

To stop all containers:

> 🛈 Have to be launch with **Git Bash** or **Bash for Windows**.

```sh
 bin\stop-all-containers.sh
```

To stop and remove everything (containers, images, volumes, networks, cash):

> ⚠ Be prudent with this command!

> 🛈 Have to be launch with **Git Bash** or **Bash for Windows**.

```sh
 bin\clean-everything.sh
```

## 🛠 Troubleshooting <a name="troubleshooting"></a>

### Warning during the build

There is some warning with `fsevent` during the build. Just ignore them.

### `Portainer` Launch

- At every relaunch of the container, you have to define a password for the user, before logging.
- It may occur some errors when opening Portainer (http://localhost:9000). Just refresh the page.

### One of the services cannot start

It may occur if one of the following ports is in use.
They are needed as followed:

- **80**: for Front App
- **8090**: for Developer MS
- **8092**: for Developer Information MS
- **5433**: for Developer PostgreSQL database
- **27018**: for Developer Information MongoDb database
- **8000**: for Portainer Agent
- **9000**: for Portainer Server
