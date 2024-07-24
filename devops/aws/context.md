

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

