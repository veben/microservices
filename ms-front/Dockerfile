# Build stage
FROM node:12.13-alpine AS build

WORKDIR /opt/

COPY . .
RUN npm install && \
    npm run build


# Run stage
LABEL name=ms-front \
      maintainer="veben"

FROM nginx:1.17.5-alpine
COPY --from=build /opt/dist/ms-front /usr/share/nginx/html
