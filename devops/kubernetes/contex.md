# Kubernetes
 - Kubernetes é utilizado para orquestrar os containeres docker e promover ações importantes como
   - Auto scaling
   - Service discovery para ajudar os microsserviços a encontrarem uns aos outros
   - Load balancer
   - Self healing para verificar a integridade e substitui instancias com falhas
   - Zero Downtime deployments

# Principais comandos:
 - Criar um deployment
  `kubectl create deployment <nome do deployment> --image=<nome da imagem>`
 - Expor um pod
  `kubectl expose pod hello-kubernetes-689bdcfc58-mhv4b --type=LoadBalancer --port=8080`
 - Expor um deployment
  `kubectl expose deployment hello-kubernetes --type=LoadBalancer --port=8080`
 - Adicionar autoscale para um deployment
  `kubectl autoscale deployment <nome do deployment> --max=10 --cpu-persent=70`
 - Escalar um pod
  `kubectl scale deployment <nome do deployment> --replicas=3`
 - Alterar imagem do deployment
  `kubectl set image deployment <nome do deployment> <nome do deployment>=<nome da imagem>:<versão da imagem>`
 - Verificar eventos que aconteceram (ordenado por data)
  `kubectl get events --sort-by=.metadata.creationTimestamp`
  
# Alternativas
 - Diversos provedores de Cloud tem seus próprios serviços de kubernetes em nuvem como o EKS (AWS) GKE (Google Cloud) AKS (Azure)
 - Também temos o docker swarm, mas por conta de sua limitação de escalabilidade e performance, o Kubernetes segue sendo o favorito da comunidade e das empresas
 
# Kubernetes como Gerenciador
- O kubernetes gerencia seus servidor![alt text](image.png)es virtuais
- Os servidores virtuais são chamados de "nodes" tendo geralmente apenas 1 master node
- Esse master node é quem gerencia os demais nodes

# Pods
- Comando para listar os pods é o `kubectl get pods`
- Para visualizar as informações de um pod `kubectl describe pod <pod>`
- Ao desejar criar um container, é necessario armazenalo em um pod, conforme a imagem abaixo <br>
<img src="./images/image.png" width=300 heigth=300></img>
<br>
- Um pod pode conter um ou mais containers dentro dele

# Replicasets
 - Replicasets é basicamente o serviço que mantem a quantidade de pods em execução

# Deployments
 - O deployment garante a disponibilidade das aplicações (pods), caso atualizamos a imagem do deployment e essa imagem nao for encontrada, o deployment garante a disponibilidade mantendo os pods com a imagem antiga.
 - Quando a nova imagem é "setada"

# Services
- Os services funcionam como um proxy, onde os pacotes chegam nele e ele passa para os respectivos pods, fazendo o balanceamento de carga usando o algoritmo <i>round-robin</i> por todos os pods existentes.