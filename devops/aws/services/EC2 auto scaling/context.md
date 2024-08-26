# Criando um auto scalin

1 - Crie um template
    - Vá em "Modelos de execução"
    - Insira um nome
    - Insira a versão
    - Escolha a imagem
    - Escolha o tipo de instancia
    - Escolha a chave
    - Configure de rede
      - Crie um novo grupo de segurança
      - Escreva uma descrição
      - Tipo de regra
    - Importante: caso queira que seja executado algum codigo basta adicionar esse código (em shellscript) na parte "dados do usuário, com isso toda instância criada a partir desse template no momento do autoscaling, executará esse código em shellscript
    - Clique em "criar modelo de execução"
2 - Vá em "Grupos de auto scaling"  
    - Crie um grupo de autoscaling
    - escolha o nome do grupo
    - escolha o modelo de execuçao (o criado anteriormente)
    - Escolha a VPC
    - adicione um balanceador de carga se tiver criado um
    - especifique o tamanho do grupo
      - especifique a capacidade no inicio
      - especifique a capacidade no minimo
      - especifique a capacidade no maximo
      - especifique a política de escalabilidade se existir
      - se quiser, configure notificações
      - especifique tags
      - verifique o resumo