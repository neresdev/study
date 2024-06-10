FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=12345

ENV MYSQL_DATABASE=coursejdbc
ENV MYSQL_USER=app
ENV MYSQL_PASSWORD=app123

COPY ./docker/setup.sql /docker-entrypoint-initdb.d/

EXPOSE 3306