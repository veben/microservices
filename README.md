# Microservices

> Created and maintained by veben

## 📜 Table of Contents

- [ ] [Tools Setup](#tools-setup)
- [ ] [Build & Launch](#build-launch)
- [ ] [Browse to the app](#browse-to-the-app)
- [ ] [Manage containers and other Docker things](#manage-containers-and-other-docker-things)
- [ ] [Stop & Clean](#stop-clean)
- [ ] [Microservice Developer in depth](developer/README.md)
- [ ] [Microservice Developer Informations in depth](developer-information/README.md)
- [ ] [Front-end MS-Front in depth](ms-front/README.md)
- [ ] [Troubleshooting](#troubleshooting)

## ⚙ Tools Setup

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

## 🔧 Build & 🚀 Launch

To manage the whole project with **Docker Compose** using just few commands

> ⚠ The first one build is very long

```sh
 docker-compose up
```

## 💻 Browse to the app

http://localhost

## 🐳 Manage containers

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

## ✋ Stop & 🚿 Clean

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

### 🛠 Troubleshooting

#### Warning during the build

There is some warning with `fsevent` during the buils. Just ignore them

#### `Portainer` Launch

- At every relaunch of the container, you have to define a password for the user, before logging.
- It may occurs some errors when opening Portainer (http://localhost:9000). Just refresh the page.

#### One of the services connot start

It may occurs if one of the following ports is in use.
They are needed as followed:

- **80**: for Front App
- **8090**: for Developer MS
- **8092**: for Developer Information MS
- **5433**: for Developer PostgreSQL database
- **27018**: for Developer Information MongoDb database
- **8000**: for Portainer Agent
- **9000**: for Portainer Server
