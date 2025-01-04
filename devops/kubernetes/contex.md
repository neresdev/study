# Kubernetes
 - Kubernetes é utilizado para orquestrar os containeres docker e promover ações importantes como
   - Auto scaling
   - Service discovery para ajudar os microsserviços a encontrarem uns aos outros
   - Load balancer
   - Self healing para verificar a integridade e substitui instancias com falhas
   - Zero Downtime deployments

# Principais comandos:
 - Criar um deployment
   - kubectl create deployment <nome do deployment> --image=<nome da imagem>
 - Expor um pod
   - kubectl expose pod hello-kubernetes-689bdcfc58-mhv4b --type=LoadBalancer --port=8080
 - Expor um deployment
   - kubectl expose deployment hello-kubernetes --type=LoadBalancer --port=8080
 - Adicionar autoscale para um deployment
   - kubectl autoscale deployment <nome do deployment> --max=10 --cpu-persent=70
 - Alterar imagem do deployment
   - kubectl set image deployment hello-kubernetes hello-kubernetes=leandrocgsi/hello-kubernetes:erudio-0.0.2