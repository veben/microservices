FROM nginx:1.17.6-alpine

ARG APP_NAME

ENV MAINTAINER "veben"

LABEL name=$APP_NAME \
      maintainer=$MAINTAINER

COPY $APP_NAME /usr/share/nginx/html

HEALTHCHECK --interval=30s --timeout=10s --start-period=120s --retries=3 \
  CMD curl -f http://localhost/ || exit 1
