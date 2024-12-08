# Planejando as builds das imagnes
Para planejar as builds, basta subir um container usando o seguinte comando abaixo por exemplo

```shell

docker run -it --name test-ubuntu ubuntu:18.04 /bin/bash

```

Depois de estar dentro do container, execute o que você quer que seja executado durante a build e anote tudo por exemplo:
 1 - Subir um container
 2 - atualizar os pacotes
 3 - instalar o iputils-ping
 4 - dar um ping no ip 8.8.8.8 (google)

 comandos:
 apt update
 apt install -y iputils-ping
 ping 8.8.8.8

 Dockerfile:

 ```Dockerfile
 FROM ubuntu:18.04
 RUN apt-get update \
     apt install -y iputils-ping
 CMD ping 8.8.8.8
 ```