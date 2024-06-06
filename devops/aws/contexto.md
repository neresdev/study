

# `***Serviços***`
p servidorA1 → hVl55quDYrpX8jXr@5CNnsaTW)bK)yDG
Tem MUITOS, não da pra listar todos (banco de dados, armazenamento, machine learning, segurança…).

# `***Shared Responsibility Model***`

Por mais que a AWS tente, ela nao consegue manter a segurança dos seus dados sozinha, com isso tem esse termo “Shared Responsibility Model“ 

# `***Criando alerta de Billing***`

Para criar um alerta de billing basta ir em billing → budgets → create budget  

# `***CLI - Command Line Interface***`

Basicamente é o cloudshell instalado no terminal

# `***Cloud Shell***`

Terminal dentro da AWS, com ele é possível manipular todos os serviços da AWS

# `***Aviability Zones (Zonas de disponibilidade)***`

Existe uma lista de zonas de disponibilidades na AWS que funcionam da seguinte maneira:

Por exemplo, existe a zona sa-east-1 (São Paulo), com isso podemos ter sa-east-1a, sa-east-1b, sa-east-1c.

Essas zonas funcionam como backup para cada uma (cada uma com 100GB por segundo) e estao em um raio de 100KM de distância uma da outra

# `***Zona Locais***`

As zonas locais são zonas menores que ficam mais próximas aos usuários com conexões muito rápidas (da própria amazon) com as zonas de disponibilidade maiores ajudando assim serviços de jogos em tempo real hospedados em computação em nuvem, machine learning e entre outros serviços que necessitam de uma latência menor.

Obs: Muitas empresas utilizam Zonas Locais, como Netflix

# `***AWS Wevelength***`

AWS Wavelenght são os equipamentos da AWS instalados nos provedores para fazer a conexão com as Zonas de disponibilidade. Por exemplo

Quando uma pessoa está acessando um serviço hospedado em algum serviço da AWS via 5g pelo celular, ao invés da comunicação ser:

📱 → 🗼 torre da TIM → Zonas de disponibilidade

a comunicação é feita da seguinte maneira

📱 → 🗼 equipamentos da AWS instalados na TIM → Zonas de disponibilidade

# `***AWS Outspots***`

AWS Outspots são os equipamentos da AWS em datacenters já existentes.

Por exemplo, tenho uma empresa que já tem um datacenter porém, quero utilizar os serviços AWS.

Posso solicitar a AWS para criar um Outspot em meu datacenter, com isso a comunicação ficará melhor pois não será necessário sair do link do meu servidor e ir para uma Zona de Disponibilidade, quem cuidará desse processo será o Outspot, com isso a compatibilidade e a velocidade dos meus servidores e dos serviços AWS serão melhores 

# `***Segurança***`

Um serviço bom para segurança é o AWS CloudTrail, com ele é possível os seguintes eventos:

Eventos de gerenciamentos

- Login de usuários
- Executar uma instancia EC2
- Criar uma subnet

Eventos de dados

- Eventos de escrita (como salvar algum arquivo no S3, por exemplo)
- Atualizar algum dado no DynamoDB

AWS CloudWatch → organiza as métricas e de acordo com as mesmas, é gerado um alarme que é desencadeado uma ação.

Preparar um ambiente florence

Detecção → Fase que identifica algo de estranho no ambiente.

- GuardDuty → Analisa os logs para anormalidades e comportamentos maliciosos utilizando machine learning.
    
    Ele basicamente entende como que a aplicação funciona e com isso consegue identificar comportamentos possivelmente maliciosos
    
- AWS Config → Verifica os status das configurações
- Amazon Inspector → Verifica as vulnerabilidades nos serviços

Para consolidar todos os dados dos serviços listados acima, podemos utilizar o Security Hub

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

# ***`EC2 (Elastic Compute Cloud)`***

Basicamente são as máquinas virtuais da amazon

Utilizam virtualização XEN

## Vantagens

- Maior Controle sobre a máquina virtual
- Segurança
- Trabalha com todos os serviços AWS
- Low - Colt

# `***AWS Batch***`

Batch → Lote

É um serviço usado para rodar lotes de scripts

Primeiro inicia um JOB e dentro dele é colocado todos os scripts e para isso é criado um JOB Definition (Onde fica as especificações do JOB)

Depois, é criado uma JOB Queue (Fila onde ficam todos os scripts)

A próxima etapa (Batch compute env) é onde todos os scripts são executados

# `***Amazon LightSail***`

Forma de navegar no EC2 com uma maior facilidade, porém, possui menor poder computacional

# `***ECS (Elastic Container Service)***`

Serviço da amazon para containers

Task → Container

Registry → Image

ECR (Elastic Container Registry) → Lugar onde coloca as imagens

ECS Service → Serviço onde é configurado quantos containers vão ter e quais as caracteristicas de cada container

*Mas aonde que rodam esses containers?*

ECS EC2 Cluster → Você faz tudo, configurações etc

ECS Fargate → Tudo é configurado (Mais fácil de trabalhar)

# `***Armazenamento na AWS***`

Categorização:

- Block Storage → arquivos que são guardados em formato de blocos, volumes (HD) → latência muito baixa → DAS
- File storage → Para armazenar os dados e compartilhá-los → NAS
- Object Storage → Objetos que possuem um ID único e um endereçamento único (URL)

EBS:

→ Em uma instância EC2, não há um disco rígido como aparenta existir, mas sim um EBS, um serviço da AWS que simula esse disco

→ O EBS precisa estar na mesma AZ (Aviability Zone) da instância EC2

→ Para um EBS conectar em mais de uma instância é necessário seguir alguns requisitos:

- Ambas as instâncias precisam ser do tipo Nitro
- O EBS em questão precisa ser do tipo IO1

→ Tipos de EBS

- HDD, mais lento e mais barato
- SSD, mais rápido e MUITO mais barato
- 

# `***S3 (famoso)***`

- foi o primeiro serviço que a AWS disponibilizou para seus clientes
- Não tem uma limitação pré-definida de quantidade, porém cada arquivo não pode passar de 5T
- Bucket → pasta
- Durabilidade → ter um arquivo não corrompido ou com algum tipo de problema ocasionado pelos servidores AWS (99.999999999%)
- Disponibilidade → ter seu arquivo disponível 99.99% do tempo

# `***Amazon AMI***`

- Imagens para instâncias EC2
- Imagens privadas → são aquelas que nós criamos
    - Ex: Uma imagem linux com uma aplicação spring rodando
- Imagens públicas → são aquelas que todos tem acesso
    - Ex: Uma imagem Red Hat Linux zerada
- AMI é útil quando você precisa replicar uma instância EC2 em outra região por exemplo, basta criar uma AMI (imagem) dessa instância e feito!

# `***Classes de armazenamento do S3***`

- A AWS fez uma maneira de cobrar mais de quem acessa mais arquivos e menos de quem acessa menos arquivos
- Existe no total 8 classes, mas dentre as mais famosas
    1. S3 Standard → o mais caro, para empresas que fazem download e upload de arquivos rapidamente
    2. S3 Intelligent-Tiering → De forma inteligente, a AWS organiza as classes do arquivo e dependendo do seu uso, ele é movido para diferentes classes
    3. S3 Standard - IA → Infrequest Access (Acesso Infrequente) 
    4. S3 One Zone IA → Igual o S3 Standard - IA porém você só consegue acessar o teu arquivo de uma zona
    5. S3 Glacier Flexible Retrieval → Destinado para arquivos acessados de 1 a 2 vezes por ano
    6. S3 Glacier Deep Archive → Arquivos que precisam ser armazenados por questões legais, acessado de 7 a 10 anos
    7. S3 Outposts → Armazenamento em um Outposts

# `***S3 Pricing***`
- Para calcular o preço da AWS [clique aqui](https://calculator.aws/#/)
- Por mais que a classe Deep archive seja bem barato, caso o cliente queira acessar o mesmo, ele terá que pagar a cada 1.000 solicitações (PUT, GET, DELETE, etc...)
- Mover os arquivos entre classes também é uma ação paga
- 