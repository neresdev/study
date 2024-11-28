# logs no docker deamon
temos 5 níveis de logs
 - debug -> todos os tipos de mensagens 
 - info -> mensagens de info, warn, erro e fatal
 - warn -> mensagens de warn, erro e fatal
 - error -> mensagens de erro e fatal
 - fatal -> erros fatais

Para executar o docker deamon em modo debug, basta rodar o seguinte comando
``` shell
    sudo dockerd -l debug
```