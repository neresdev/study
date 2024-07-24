# `***IAM (Identity Access Management)***`

Para acessar os serviços AWS tem 3 formas

- Console da AWS
- CLI
- API’s

Ambos os acessos chegam no IAM, que através dele é possível criar usuários, regras, gerenciar esses usuários e as aplicações no geral

Com IAM, é possível criar/gerenciar as políticas, sendo elas

- IBP
- RBP

Com essas duas é possível acessar os serviços da AWS

A partir de um usuário criado, é necessário atribuir um nome a ele. Após isso o novo usuário é criado com nenhum privilégio

Ao criar um grupo, é inserido e criado usuários dentro dele, para agrupar usuários com os mesmos privilégios

Também é possível criar roles (Regras) que serão aplicadas em serviços da AWS, posso querer que uma instância EC2 (VM) tenha permissão para acessar um bucket S3 por exemplo

As Policys servem para bloquear e permitir acessos de usuários e grupos

