
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

# `***Life cycle***`
- Versionamento
- É utilizado para mover objetos para outras classes
- Exemplo, para mover um arquivo que está na classe padrão do s3, após 90 dias ele ir para a classe <i>glacier</i> do s3, basta seguir esses passos:
 - Gerenciamento
 - Clique em "Criar regra de ciclo de vida"
   - Especifique o nome "mover-30-dias" por exemplo
   - Caso queira, adicione um prefixo "Development/", para que todos os arquivos que estiverem dentro dessa pasta sejam afetados por essa regra (parecido com o padrão do terminal linux)
   - Mover versões atuais de objetos entre clases de armazenamento
   - Escolha a transação de classes
   - Digite os dias desejados 
   - Clique em "criar regra"
 - Segundo exemplo -> criar uma regra para manter apenas as 10 últimas versões do objeto dentro do bucket
   - Gerenciamento
   - Especifique o nome da regra "delete-old-versions" por exemplo
   - selecione "aplicar a todos os objetos no bucket", caso assim queira
   - selecione "excluir permanentemente versões desatualizadas de objetos"
   - Digite o tanto de dias após os objetos ficarem desatualizados
   - Digite o numero de versões que serão mantidas (nesse exemplo é 10)
   - Clique em "criar regra"
 
# `***Replicação de objetos***`
- Caso necessário copiar os objetos de uma bucket de uma zona de disponibilidade para outra que estaja em otutra zona de disponibilidade, é utilizado essa técnica
- Necessário habilitar o versionamento
- Como fazer:
  - Gerenciamento
    - Regras de replicação    
    - Digite um nome "us-london" por exemplo
    - status habilitado
    - escolha o prefixo ou aplica a todos os objetos
    - selecione a bucket de destino (pode estar em outra conta AWS sem problema nenhum, fazendo cross-account)
    - Crie uma nova função ou selecione uma
    - Especifique qual classe de arquivos irá ser aplicada 
    - Selecione as opções de replicação adicionais que se aplicam
    - Selecione salvar
    - Caso queira replicar objetos existentes, selecione "sim" e clique em enviar
      - Caso sim:
        - Especifique se quer executar automaticamente esse trabalho de copiar, ou aperte em aguardar para que a AWS espere sua confirmação
        - Caso deseje um relatório de conclusão, selecione o checkbox e especifique algumas informações como escopo do relatório (apenas tarefas com falhas ou todas) e o caminho para o destino do relatório
        - Clique em salvar
    - Com isso, quando você fizer um upload em uma bucket, a outra irá ter o mesmo arquivo

# `***Segurança do bucket***`
- Pode ser feita via IAM (via regra para aquele grupo, usuario ou role)
- Via bucket police (via regra para bucket)
- Via access list

# `***S3 glacier***`
- Classes
  - Glacier -> paga barato e pegar seus arquivos com uma quantidade de tempo menor (muito barato)
  - Glacier deep archive -> como colocar seus produtos no "freezer", usado para colocar os arquivos la dentro e "esquecer" dele (mais barato ainda)
- Todas as classes ficam em um lugar chamado "Cold Datacenter"
- Possui custo por acesso (AWS recomenda não utilizar com frequência esses arquivos que estejam nesse serviço)
- Existe algumas maneiras de "pegar" o arquivo de volta
  - Expedited: 1 à 5 minutos apenas no Glacier ($$$)
    - Glacier padrão: 1 - 5 minutos
    - Glacier deep archive: não e aplica
  - Standard ($$)
    - Glacier padrão: 3 - 5 horas
    - Glacier deep archive: 12 horas
  - Bulk ($): 
  - Glacier padrão: 5 - 12 horas
  - Glacier deep archive: 48 horas  
- Vantagens
  - Sistema s3 object lock
  - S3 glacier vault lock