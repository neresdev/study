# `Segurança`

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
