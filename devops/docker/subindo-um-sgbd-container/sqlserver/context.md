# SQLServer
execute o seguinte comando
```shell
docker run --name containerSQLServer -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=admin123*" -p 1400:1433 -d mcr.microsoft.com/mssql/server:2017-latest
```