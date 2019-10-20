# Build stage
FROM maven:3.6.2-jdk-11-slim AS build

ARG APP_NAME
ENV JAVA_OPTIONS "-Xmx1792m -Xms1792m"

COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package


## Package stage
FROM openjdk:11-jre-slim

ARG APP_NAME
ARG APP_VERSION
ENV LIB_PATH "/opt/${APP_NAME}/lib"
ENV JAR_PATH "${LIB_PATH}/${APP_NAME}.jar"

LABEL   name="${APP_NAME}" \
        maintainer="veben"

COPY --from=build "/home/app/target/${APP_NAME}-${APP_VERSION}.jar" $JAR_PATH
ENTRYPOINT exec java -jar $JAR_PATH

