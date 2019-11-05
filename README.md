# Microservices

> Created and maintained by veben
> https://stackoverflow.com/users/8718377/veben > https://github.com/veben>

## 📜 Table of Contents

- [ ] [Tools Setup](#tools-setup)
- [ ] [Build & Launch](#build-launch)
- [ ] [Browse to the app](#browse-to-the-app)
- [ ] [Stop & Clean](#stop-clean)
- [ ] [Microservice Developer in depth](developer/README.md)
- [ ] [Microservice Developer Informations in depth](developer-information/README.md)
- [ ] [Microservice Order in depth](order/README.md)
- [ ] [Front-end MS-Front in depth](ms-front/README.md)
- [ ] [Troubleshooting](#troubleshooting)
- [ ] [Tools to manage without docker](#tools-to-manage-without-docker)

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
- Intellij settings > "Build, Execution, Deployment" > "Docker"
  - Change configuration:
    - Name: Docker
    - TCP socket: checked
    - Engine API URL: `tcp/localhost:2375`

## 🔧 Build & 🚀 Launch

To manage the whole project with **Docker Compose** using just few commands

> ⚠ The first one build is very long

```sh
 docker-compose up --build -d && docker-compose logs -f
```

## 💻 Browse to the app

http://localhost

## ✋ Stop & 🚿 Clean

To stop and remove containers define in the `docker-compose.yml` file

```sh
 docker-compose down
```

To stop and remove all containers and images

> ⚠ Be prudent with this command

> have to be launch with **Git Bash** or **Bash for Windows**

```sh
 docker stop $(docker ps -a -q) && docker rm $(docker ps -a -q) && docker image prune -f
```

### 🛠 Troubleshooting

The following ports have not to be in use: 80, 8090, 8091, 8092, 5433, 5434, 27018

### 💼 Tools to manage without docker

#### ⛏ JDK: openjdk-11.0.4

- [Download](https://github.com/AdoptOpenJDK/openjdk11-upstream-binaries/releases/download/jdk-11.0.4%2B11/OpenJDK11U-jdk_x64_windows_11.0.4_11.zip)
- Install here: `C:\Env\tools\jdk\openjdk-11u-11.0.4_11`
- Create env var: **JAVA_HOME**=‪`C:\Env\tools\jdk\openjdk-11u-11.0.4_11`
- Add `%JAVA_HOME%\bin` to **Path** env var
  > Check your current version:

```sh
 java -version
```

#### ⛏ Maven: 3.6.2

- [Download](http://apache.mirrors.benatherton.com/maven/maven-3/3.6.2/source/apache-maven-3.6.2-src.zip)
- Install here: `C:\Env\tools\apache-maven-3.6.2`
- Create env var: **M3_HOME**=`C:\Env\tools\apache-maven-3.6.2`
- Add `%M3_HOME%\bin` to **Path** env var
  > Check your current version:

```sh
 mvn -version
```

#### ⛏ Node.js: 12.13.0 & npm 6.12.0

- [Download](https://nodejs.org/en/download/)
- Install here: `C:\Env\tools\nodejs`
  > Check your current `Node.js` version:

```sh
 node -v
```

> Check your current `npm` version:

```sh
 npm -v
```

#### ⛏ Angular CLI: 8.3.17

Download & install globally:

```sh
npm install -g @angular/cli
```

> Check your current version:

```sh
 ng version
```
