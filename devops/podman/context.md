# Podman
- Para buscar as imagens basta usar o comando
```shell
podman seach <nome da imagem>
# ou caso queira apenas as oficiais basta adicionar a flag --filter=is-official
podman seach <nome da imagem> --filter=is-official
```
- Exemplo:
```shell
podman run -dit -p 8083:80 -v ./website_example/:/usr/local/apache2/htdocs/httpd registry.access.redhat.com/rhscl/httpd-24-rhel7
```
