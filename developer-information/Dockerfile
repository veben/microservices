FROM adoptopenjdk/openjdk14:alpine-jre-nightly

ARG APP_NAME
ARG APP_VERSION

ENV MAINTAINER "veben"
ENV SPRING_PROFILES_ACTIVE "docker"
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

COPY "dependencies/" $JAR_FOLDER
COPY "snapshot-dependencies/" $JAR_FOLDER
COPY "spring-boot-loader/" $JAR_FOLDER
COPY "application/" $JAR_FOLDER

USER $MAINTAINER
WORKDIR $JAR_FOLDER
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
