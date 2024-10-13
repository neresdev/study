# CloudFormation
 - É um serviço que executa comandos através de um script, é possível criar todo um ecossistema de rotas, armazenamento, servidores, redes, monitoramento etc... através desse script.
 - Benefícios
   - Toda a parte de infra é em código, nao precisa ficar criando tudo "na mão", logo você tem um controle muito preciso de o que vai ser criado e o que nao vai ser criado
   - O script é versionado
   - Visualização das mudanças antes que elas sejam aplicadas
   - Custos
     - Todas as implementações recebem uma tag, isso facilita MUITO na parte de monitoramento e custo
     - Antes de confirmar as alterações, você já saberá quanto aquilo irá lhe custar
     - Possivel fazer um script para apagar alguns recursos (em um certo momento do dia que tem baixo volume de dados/acessos por exemplo) e outro para criar tudo novamente de forma automática 
     