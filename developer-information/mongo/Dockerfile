FROM mongo:4.2.5
COPY data-local.json /data-local.json
CMD mongoimport -h developer-information-mongodb:27017 -d developer-information -c developer-information -u root -p root --authenticationDatabase admin --file data-local.json --jsonArray