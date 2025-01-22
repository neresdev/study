# MySQL
execute o seguinte comando
```shell
 docker run --name containerMySQ2L -e MYSQL_ROOT_PASSWORD=admin123@ -e MYSQL_DATABASE=docker_db -p 3308:3306 -d mysql
```