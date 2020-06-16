# Build stage
FROM node:13.5-alpine AS build

WORKDIR /opt/

COPY . .
RUN npm install && \
    npm run build


# Run stage
FROM nginx:1.17.6-alpine

ARG APP_NAME

ENV MAINTAINER "veben"

LABEL name=$APP_NAME \
      maintainer=$MAINTAINER

COPY --from=build "/opt/dist/$APP_NAME" /usr/share/nginx/html
