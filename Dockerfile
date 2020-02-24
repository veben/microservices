# Build stage
FROM maven:3.6.2-jdk-13 AS build

ARG APP_NAME
ENV SPRING_PROFILES_ACTIVE "docker"
ENV MVN_OPTIONS "clean package"

COPY ${APP_NAME}/src /home/app/src
COPY ${APP_NAME}/pom.xml /home/app
RUN mvn -f /home/app/pom.xml $MVN_OPTIONS


# Extract layers stage
FROM adoptopenjdk/openjdk13:alpine-jre as extract

ARG APP_NAME
ARG APP_VERSION
ENV SPRING_PROFILES_ACTIVE "docker"
ENV LIB_FOLDER "/opt/${APP_NAME}/lib"
ENV JAR_PATH "${LIB_FOLDER}/${APP_NAME}.jar"

COPY --from=build "/home/app/target/${APP_NAME}-${APP_VERSION}.jar" $JAR_PATH

WORKDIR $LIB_FOLDER
RUN java -Djarmode=layertools -jar $JAR_PATH extract


# Package & Run stage
FROM adoptopenjdk/openjdk13:alpine-jre

ARG APP_NAME
ARG APP_VERSION
ENV SPRING_PROFILES_ACTIVE "docker"
ENV LIB_FOLDER "/opt/${APP_NAME}/lib"
ENV JAR_FOLDER "${LIB_FOLDER}/${APP_NAME}"
ENV JAVA_OPTIONS "-Xmx1792m -Xms1792m -Pdocker"

LABEL name="${APP_NAME}" \
      maintainer="veben"

COPY --from=extract "$LIB_FOLDER/dependencies/" $JAR_FOLDER
COPY --from=extract "$LIB_FOLDER/snapshot-dependencies/" $JAR_FOLDER
COPY --from=extract "$LIB_FOLDER/resources/" $JAR_FOLDER
COPY --from=extract "$LIB_FOLDER/application/" $JAR_FOLDER

WORKDIR $JAR_FOLDER
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
