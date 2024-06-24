FROM mongo:latest

COPY docker/init.js /docker-entrypoint-initdb.d/

ENV MONGO_INITDB_ROOT_USERNAME local
ENV MONGO_INITDB_ROOT_PASSWORD 12345
