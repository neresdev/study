- O quando é executado o comando `docker run -it centos /bin/bash` o docker client (instalado na máquina) tenta achar a imagem centos, caso não encontre-a, o mesmo a busca no docker hub (repositório oficial do docker) e cria um container com essa imagem.

---

# `*Analogia*`

- Docker Engine ou Docker Deamon é similar à um porto.
- As Imagens do docker (Docker Images) é similar aos Cargo Manifests, um documento parecido com notas fiscais, mas para os contêineres.
- Docker Contêineres são como so Contêineres de carga, usados para transportar e armazenar diversos tipos de cargas

---

# `*Docker Engine*` ou `*Docker Deamon*`

- O docker engine seria todo o porto, ele que controla as dependencias, rotas, sistemas de arquivos, variaveis de acesso ao kernel e por aí vai.

---

# `*Docker Images*`

- Onde as imagens ficam?
    - ficam em `***/var/lib/docker/overlay2`***
- Exportando uma imagem
    
    ```bash
    #docker save -o <caminho onde vai ficar o tarball><nome do tarball>.tar <nome da imagem a ser exportada>
    docker save -o /home/neres/visualmix/work/foobaras.tar foobaras
    
    ```
    

---

# `*Docker Containers*`

- Onde os containers ficam?
    - ficam em `***/var/lib/docker/containers***`

---

# `*Dockerfile*`

- O que é o Dockerfile?
    - é um arquivo de texto simples que contém instruções para a criação de uma imagem docker a partir do comando `docker build Dockerfile>`

---

# `***Comandos Docker***`

```docker
# rodando o docker por uma imagem do docker hub
docker run -it centos /bin/bash

# rodando o docker pelo hash da imagem
docker start 8bed15b80ffc

# rodando o docker pelo nome da imagem
docker start sql-server-db

# lista os containers que estão em execução
docker ps

# lista todos os containers
docker ps -a

# lista os containers que foram executados em ordem
docker ps -l

#limita o tanto de CPU utilizado pela imagem
docker run --cpu-shares=256 

#limita o tanto de RAM utilizado pela imagem
docker run memory=1g

#criando uma imagem com centos na versão 7 e dando um ping no ip do servidor do Google 
docker run -d centos:7 /bin/bash -c "ping 8.8.8.8"

#se adicionar a flag -c e passar um número após, será limitado a uma certa quantidade de "pings" 
docker run -d centos:7 /bin/bash -c "ping 8.8.8.8" -c 50

# docker inspect <id do container>
docker inspect 374680738d21

#para visualizar os logs de um container / docker logs <id do container>
docker logs 374680738d21

# docker start <container id>
docker start 9949c81e1694

# docker run <image id>
docker run 216c552ea5ba

## REMOVENDO IMAGENS ##

# docker rm <container_id>
docker rm e9b32a6d71d3

# docker rmi <image_id> 
docker rmi 216c552ea5ba

# para sair do terminal docker sem que o container pare, basta usar o atalho ctrl + p + q

# docker stop <container_id>
docker stop 9949c81e1694

## IMPORTANTE ##
#o comando docker start é destinado para os CONTAINERS docker
#enquanto o docker run é destinado para as IMAGENS docker

#para "attachar" a um container (necessário o container estar em execução)
# docker attach <container id>
	docker attach 9949c81e1694

#a melhor maneira de "attachar" a um container

# docker exec -it <container id> /bin/bash
	docker exec -it 9949c81e1694 /bin/bash

#comando completo para rodar imagem especificando nome e porta
# docker run -d --name <nome da imagem> -p <porta>:<porta> <hash da imagem>
	docker run -d --name api-spring-certa -p 4321:4321 0c6d01d987d8

#passos para "dockerizar uma aplicação em spring boot"
#caso esteja usando maven basta rodar o comando "mvn clean install -f pom.xml" para gerar o .jar file
#depois disso crie o Dockerfile e adiciona o seguinte codigo
# 
# FROM openjdk:<versao do java, do java 8 para cima e de preferencia a mesma que se encontra no arquivo pom.xml do projeto spring>            
	FROM openjdk:11
	ARG JAR_FILE=target/*.jar
	COPY ${JAR_FILE} app.jar
	ENTRYPOINT ["java","-jar","/app.jar"]

#após criar o Dockerfile, basta rodar o docker build
# docker build -t <repository da imagem> .
	docker build -t spring-api .

#após esse comando, será criado uma imagem docker
#depois é só partir para o abraço, execute o seguinte comando
# docker run -d --name <nome da imagem> -p <porta>:<porta> <hash da imagem>
	docker run -d --name api-spring-certa -p 4321:4321 0c6d01d987d8

# !!IMPORTANTE!!
# ao executar o comando acima, certifique-se de que a porta, especificada após a flag "-p" precisa ser a mesma que a api sobre normalmente
# por default é a 8080, porém isso pode ser alterado adicionando o seguinte parâmetro no aplication.properties
# server.port=<porta>
	server.port=4321

#basta fazer os testes e corrija, ou peça para o responsável corrigir imediatamente

```

- Entrypoint
    
    Entrypoint works as grep command. In Dockerfile, the parameters in Entrypoint command will receive the args sended when docker run <image> is executed.
    
    Example Dockerfile:
    
    ```docker
    FROM ubuntu:18.04
    ENTRYPOINT ["echo"]
    ```
    
    when run the command `docker run imageexample:latest Hello World` the output is “Hello world” 
    
- CMD
    
    CMD command in docker build is used for run commands in Runtime. Example:
    
    ```docker
    FROM ubuntu:18.04
    RUN apt-get update && apt-get install -y inputils-ping
    
    ```
    
- RUN
    
    Run command is used for run commands in build time. Example
    
    ```docker
    FROM ubuntu:18.04
    RUN apt-get update && apt-get install -y inputils-ping
    
    ```