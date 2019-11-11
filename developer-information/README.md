# Developer Informations Microservice

## Class Diagram

![](img/class-diagram.png)

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

### Datasource:

> Launch MongoDb in a Docker container with:

```sh
docker run --name developer-information-mongodb -p 27018:27017 -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=root mongo:4.2.1
```

### Add dataset:

> Connect to mongo

```sh
docker exec -it developer-information-mongodb mongo
```

> In another shell, insert data

```sh
docker cp mongo/data-local.json developer-information-mongodb:/data-local.json && docker exec developer-information-mongodb mongoimport -d developer-information -c developer-information -u root -p root --authenticationDatabase admin --file /data-local.json --jsonArray
```

### Build:

```sh
docker build --tag developer-information:test --rm=true ..
```

### Run:

```sh
docker run -it --name developer-information --publish=8092:8092 developer-information:test
```

## Build & Run with Maven

### Datasource:

> Launch MongoDb in a Docker container with:

```sh
docker run --name developer-information-mongodb -p 27018:27017 -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=root mongo:4.2.1
```

### Build:

```sh
mvn clean install
```

### Run:

```sh
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

## Access

- Actuator: http://localhost:8092/actuator/health
- Swagger: http://localhost:8092/swagger-ui.html
- Database:
  - GUI connector:
    - uri: localhost:27018
    - user: root
    - password: root
    - auth: SCRAM-SHA-1
  - Mongo shell:
    ```sh
    mongo -u root -p root --authenticationDatabase admin localhost:27018
    ```

## Datasets

```json
[
  {
    "developerId": "3bdfbba3-d472-4431-b9ac-c203e7505b8b",
    "about": "Software Engineer, France, Paris",
    "websiteUrl": "",
    "stackOverflowUrl": "https://stackoverflow.com/users/8718377/veben",
    "avatarUrl": "https://i.stack.imgur.com/kGFwM.png?s=128&g=1",
    "goldBadges": 6,
    "silverBadges": 20,
    "bronzeBadges": 35,
    "reputation": 2774,
    "githubUrl": "https://github.com/veben",
    "name": "veben",
    "company": "",
    "publicRepositories": 4,
    "followers": 1
  },
  {
    "developerId": "4ca98fd9-927e-40e5-854b-392669f98204",
    "about": "Invisible framework coding ninja",
    "websiteUrl": "http://www.zopatista.com/",
    "stackOverflowUrl": "https://stackoverflow.com/users/100297/martijn-pieters",
    "avatarUrl": "https://www.gravatar.com/avatar/24780fb6df85a943c7aea0402c843737?s=128&d=developerIdenticon&r=PG",
    "goldBadges": 169,
    "silverBadges": 2808,
    "bronzeBadges": 3531,
    "reputation": 768917,
    "githubUrl": "https://github.com/mjpieters",
    "name": "Martijn Pieters",
    "company": "Zopatista Ltd",
    "publicRepositories": 78,
    "followers": 565
  },
  {
    "developerId": "d15a5fb3-a157-4d13-ad2d-c8add8250e25",
    "about": "Answer questions about Git and GitHub since 2009 on Stack Overflow",
    "websiteUrl": "http://careers.stackoverflow.com/vonc",
    "stackOverflowUrl": "https://stackoverflow.com/users/6309/vonc",
    "avatarUrl": "https://www.gravatar.com/avatar/7aa22372b695ed2b26052c340f9097eb?s=128&d=developerIdenticon&r=PG",
    "goldBadges": 332,
    "silverBadges": 2932,
    "bronzeBadges": 3531,
    "reputation": 901744,

    "githubUrl": "https://github.com/VonC",
    "name": "VonC",
    "company": "Softeam",
    "publicRepositories": 77,
    "followers": 171
  },
  {
    "developerId": "2f91c199-3ab4-4496-9ffa-5ae419b68f49",
    "about": "",
    "websiteUrl": "http://blog.marcgravell.com",
    "stackOverflowUrl": "https://stackoverflow.com/users/23354/marc-gravell",
    "avatarUrl": "https://i.stack.imgur.com/3vbu5.jpg?s=128&g=1",
    "goldBadges": 215,
    "silverBadges": 2236,
    "bronzeBadges": 2633,
    "reputation": 829078,

    "githubUrl": "https://github.com/mgravell",
    "name": "Marc Gravell",
    "company": "Stack Overflow",
    "publicRepositories": 39,
    "followers": 953
  },
  {
    "developerId": "25230b5d-567d-4361-a2dd-03240378648e",
    "about": "Hacker of JavaScript, Perl, C++, and various other bits and bobs. Some of it is even here on Github.",
    "websiteUrl": "",
    "stackOverflowUrl": "https://stackoverflow.com/users/19068/quentin",
    "avatarUrl": "https://www.gravatar.com/avatar/1d2d3229ed1961d2bd81853242493247?s=128&d=developerIdenticon&r=PG",
    "goldBadges": 82,
    "silverBadges": 946,
    "bronzeBadges": 1095,
    "reputation": 693914,

    "githubUrl": "https://github.com/dorward",
    "name": "DavdeveloperId Dorward",
    "company": "@FairFXGroup",
    "publicRepositories": 33,
    "followers": 79
  },
  {
    "developerId": "99f3e575-a935-40ff-8890-9d57752d7694",
    "about": "Author of the book: Java 9 Regular Expressions: A hands-on gudeveloperIde to use regular expressions with Java",
    "websiteUrl": "http://anubhava.wordpress.com",
    "stackOverflowUrl": "https://stackoverflow.com/users/548225/anubhava",
    "avatarUrl": "https://www.gravatar.com/avatar/dab08478b226280d4a30894c9a7ed719?s=128&d=developerIdenticon&r=PG",
    "goldBadges": 49,
    "silverBadges": 364,
    "bronzeBadges": 440,
    "reputation": 262968,

    "githubUrl": "https://github.com/anubhavas/",
    "name": "Anubhava Srivastava",
    "company": "",
    "publicRepositories": 1,
    "followers": 14
  },
  {
    "developerId": "98e85368-fde3-42e1-9079-e9b6ac05df4a",
    "about": "You can hire me via Mercury1. You can donate me at PayPal.",
    "websiteUrl": "http://balusc.omnifaces.org",
    "stackOverflowUrl": "https://stackoverflow.com/users/157882/balusc",
    "avatarUrl": "https://www.gravatar.com/avatar/89927e2f4bde24991649b353a37678b9?s=128&d=developerIdenticon&r=PG",
    "goldBadges": 314,
    "silverBadges": 3272,
    "bronzeBadges": 3301,
    "reputation": 894594,

    "githubUrl": "https://github.com/BalusC",
    "name": "Bauke Scholtz",
    "company": "",
    "publicRepositories": 1,
    "followers": 332
  },
  {
    "developerId": "51ef449b-7cd0-4752-86b7-f1362af1d1b9",
    "about": "",
    "websiteUrl": "",
    "stackOverflowUrl": "https://stackoverflow.com/users/217408/g%c3%bcnter-z%c3%b6chbauer",
    "avatarUrl": "https://i.stack.imgur.com/IlnZm.jpg?s=128&g=1",
    "goldBadges": 88,
    "silverBadges": 1216,
    "bronzeBadges": 1097,
    "reputation": 376148,

    "githubUrl": "https://github.com/zoechi",
    "name": "Günter Zöchbauer",
    "company": "",
    "publicRepositories": 32,
    "followers": 510
  },
  {
    "developerId": "9b88969f-06da-4cc8-a7b5-840093b9dc9c",
    "about": "Not much to say, uninteresting object...",
    "websiteUrl": "https://www.scribd.com/user/60098423/Willem-Van-Onsem",
    "stackOverflowUrl": "https://stackoverflow.com/users/67579/willem-van-onsem",
    "avatarUrl": "https://i.stack.imgur.com/BJXub.png?s=128&g=1",
    "goldBadges": 19,
    "silverBadges": 187,
    "bronzeBadges": 283,
    "reputation": 198353,

    "githubUrl": "https://github.com/KommuSoft",
    "name": "Willem Van Onsem",
    "company": "",
    "publicRepositories": 52,
    "followers": 152
  },
  {
    "developerId": "d37f2850-9f02-4efc-9e3f-80a0d6a3b7f4",
    "about": "Author of The Busy Coder's GudeveloperIde to AndrodeveloperId Development (https://commonsware.com/AndrodeveloperId). AndrodeveloperId app development trainer and consultant.",
    "websiteUrl": "https://commonsware.com",
    "stackOverflowUrl": "https://stackoverflow.com/users/115145/commonsware",
    "avatarUrl": "https://i.stack.imgur.com/wDnd8.png?s=128&g=1",
    "goldBadges": 147,
    "silverBadges": 1986,
    "bronzeBadges": 2026,
    "reputation": 817681,

    "githubUrl": "https://github.com/commonsguy",
    "name": "Mark Murphy",
    "company": "CommonsWare",
    "publicRepositories": 32,
    "followers": 6214
  },
  {
    "developerId": "0338663e-97b8-402f-b15c-55a776a0e22b",
    "about": "Java developer since 1997, and enthusiast scuba diver since 2001.",
    "websiteUrl": "",
    "stackOverflowUrl": "https://stackoverflow.com/users/571407/jb-nizet",
    "avatarUrl": "https://www.gravatar.com/avatar/2f0d9dec16bae1e06552af55ddefc11f?s=128&d=developerIdenticon&r=PG",
    "goldBadges": 70,
    "silverBadges": 953,
    "bronzeBadges": 1069,
    "reputation": 574902,

    "githubUrl": "https://github.com/jnizet",
    "name": "JB Nizet",
    "company": "",
    "publicRepositories": 70,
    "followers": 127
  },
  {
    "developerId": "d69f0549-4c7b-45da-be90-95af26aff311",
    "about": "Currently a software engineer at Google, London.\nUsually a Microsoft MVP (C#, 2003-2010, 2011-)",
    "websiteUrl": "http://csharpindepth.com",
    "stackOverflowUrl": "https://stackoverflow.com/users/22656/jon-skeet",
    "avatarUrl": "https://www.gravatar.com/avatar/6d8ebb117e8d83d74ea95fbdd0f87e13?s=128&d=developerIdenticon&r=PG",
    "goldBadges": 720,
    "silverBadges": 8240,
    "bronzeBadges": 8620,
    "reputation": 1140506,

    "githubUrl": "https://github.com/jskeet",
    "name": "Jon Skeet",
    "company": "Google",
    "publicRepositories": 39,
    "followers": 4506
  },
  {
    "developerId": "daa00584-0c3a-43fb-85bd-f52eb3e2ffdf",
    "about": "I'm a software developer and Microsoft MVP who relishes authoring HTML and CSS on the web and hacking C# on their self-built Windows PC.",
    "websiteUrl": "https://NOVALISTIC.com",
    "stackOverflowUrl": "https://stackoverflow.com/users/106224/boltclock",
    "avatarUrl": "https://www.gravatar.com/avatar/a2d818d801ce38a33807f68fdd92043a?s=128&d=developerIdenticon&r=PG",
    "goldBadges": 134,
    "silverBadges": 1216,
    "bronzeBadges": 1238,
    "reputation": 556022,

    "githubUrl": "https://github.com/NOVALISTIC",
    "name": "Daniel Tan",
    "company": "NOVALISTIC",
    "publicRepositories": 1,
    "followers": 6
  },
  {
    "developerId": "9e5145bd-a581-4404-9a79-9a08ebbc903b",
    "about": "Wanna work with me at Code White? Have a look at our current job openings!",
    "websiteUrl": "https://www.linkedin.com/in/markuswulftange",
    "stackOverflowUrl": "https://stackoverflow.com/users/53114/gumbo",
    "avatarUrl": "https://www.gravatar.com/avatar/cd501083459cbc21fccae78e2d03bee2?s=128&d=developerIdenticon&r=PG",
    "goldBadges": 94,
    "silverBadges": 691,
    "bronzeBadges": 782,
    "reputation": 538729,

    "githubUrl": "https://github.com/mwulftange",
    "name": "Markus Wulftange",
    "company": "codewhitesec",
    "publicRepositories": 8,
    "followers": 21
  },
  {
    "developerId": "04172846-150b-4b8d-ae7c-92f9b5d78bec",
    "about": "Abusing programming instead of drugs.",
    "websiteUrl": "https://pileborg.se/",
    "stackOverflowUrl": "https://stackoverflow.com/users/440558/some-programmer-dude",
    "avatarUrl": "https://i.stack.imgur.com/9ZYta.jpg?s=128&g=1",
    "goldBadges": 26,
    "silverBadges": 286,
    "bronzeBadges": 456,
    "reputation": 317708,

    "githubUrl": "https://github.com/pileon",
    "name": "Joachim Pileborg",
    "company": "Team Evil",
    "publicRepositories": 33,
    "followers": 22
  },
  {
    "developerId": "7bc177f0-44f4-4eb6-b9a2-54c333daa053",
    "about": "I am a programmer. My principal language is C++. I've also done commercial work in Java, C, Perl, Python, Javascript and APL. I've also been known to dabble in lisp, Haskell, assembler (ARM, x86, amd64) and probably a few other languages that haven't left as big a mark.",
    "websiteUrl": "",
    "stackOverflowUrl": "https://stackoverflow.com/users/19563/cb-bailey",
    "avatarUrl": "https://www.gravatar.com/avatar/a8db27c91db97757a829c7971fd62b84?s=128&d=developerIdenticon&r=PG",
    "goldBadges": 84,
    "silverBadges": 574,
    "bronzeBadges": 617,
    "reputation": 556336,

    "githubUrl": "https://github.com/hashpling",
    "name": "CB Bailey",
    "company": "bloomberg",
    "publicRepositories": 15,
    "followers": 33
  }
]
```