# Route 53
- Esse serviço basicamente é um servidor DNS "turbinado" com algumas políticas, como o redirecionamento daquele endereço para outro ip dependendo da necessidade, caso o servidor que possui aquele IP padrão estiver fora por exemplo.
- Observe o arquivo route54-explain.drawio, o serviço route53 pode ser configurado para que caso o servidor web 1 estiver fora, o usuário ser redirecionado para o servidor web 2 ou ser redirecionado por questão de geolocalização por exemplo, para ser redirecionado para o servidor mais próximo para diminuir a latência.

# Hosted zones
- Para registrar um domínio, basta ir em "hosted zones" > "Registered domains" ou "Registrar dominio" > escolha o nome do dominio > escolha o dominio (.com, .net, .co, etc...)
- Complete as informações sobre o dominio
- Aceite os termos
- Aguarde o registro do dominio estar completo