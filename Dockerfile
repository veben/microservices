# Build stage
FROM maven:3.6.2-jdk-13 AS build

ARG APP_NAME
ENV SPRING_PROFILES_ACTIVE "docker"
ENV MVN_OPTIONS "clean package -DskipTests"

COPY ${APP_NAME}/src /home/app/src
COPY ${APP_NAME}/pom.xml /home/app
RUN mvn -f /home/app/pom.xml $MVN_OPTIONS


## Package & Run stage
FROM openjdk:13-jdk-alpine

ARG APP_NAME
ARG APP_VERSION
ENV SPRING_PROFILES_ACTIVE "docker"
ENV LIB_PATH "/opt/${APP_NAME}/lib"
ENV JAR_PATH "${LIB_PATH}/${APP_NAME}.jar"
ENV JAVA_OPTIONS "-Xmx1792m -Xms1792m -Pdocker"

LABEL name="${APP_NAME}" \
      maintainer="veben"

COPY --from=build "/home/app/target/${APP_NAME}-${APP_VERSION}.jar" $JAR_PATH
ENTRYPOINT exec java -jar $JAR_PATH

