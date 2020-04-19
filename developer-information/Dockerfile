# Build stage
FROM maven:3.6.3-jdk-14 AS build

ENV SPRING_PROFILES_ACTIVE "docker"
ENV MVN_OPTIONS "clean package"

COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml $MVN_OPTIONS


# Extract layers stage
FROM adoptopenjdk/openjdk14:alpine-jre-nightly as extract

ARG APP_NAME
ARG APP_VERSION

ENV SPRING_PROFILES_ACTIVE "docker"
ENV LIB_FOLDER "/opt/${APP_NAME}/lib"
ENV JAR_PATH "${LIB_FOLDER}/${APP_NAME}.jar"

COPY --from=build "/home/app/target/${APP_NAME}-${APP_VERSION}.jar" $JAR_PATH

WORKDIR $LIB_FOLDER
RUN java -Djarmode=layertools -jar $JAR_PATH extract


# Package & Run stage
FROM adoptopenjdk/openjdk14:alpine-jre-nightly

ARG APP_NAME
ARG APP_VERSION

ENV MAINTAINER "veben"
ENV SPRING_PROFILES_ACTIVE "docker"
ENV LIB_FOLDER "/opt/${APP_NAME}/lib"
ENV JAR_FOLDER "/app/${APP_NAME}"
ENV SPRING_OUTPUT_ANSI_ENABLED "NEVER"
ENV JAVA_OPTIONS "-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

LABEL name=$APP_NAME \
      maintainer=$MAINTAINER

RUN mkdir -p $JAR_FOLDER
RUN addgroup -S $MAINTAINER && \
    adduser -S $MAINTAINER -G $MAINTAINER && \
    chown -R root:$MAINTAINER $JAR_FOLDER && \
    chmod -R g+w $JAR_FOLDER

COPY --from=extract "$LIB_FOLDER/dependencies/" $JAR_FOLDER
COPY --from=extract "$LIB_FOLDER/snapshot-dependencies/" $JAR_FOLDER
COPY --from=extract "$LIB_FOLDER/resources/" $JAR_FOLDER
COPY --from=extract "$LIB_FOLDER/application/" $JAR_FOLDER

USER $MAINTAINER
WORKDIR $JAR_FOLDER
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
