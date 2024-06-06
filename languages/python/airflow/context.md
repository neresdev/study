# O Airflow

Nada mais é que uma plataforma que é utilizado para criar, manter e monitorar fluxos de trabalho.

Não é uma ferramenta de streaming de dados.

As tarefas não movem dados de uma para outra, mas podem trocar metadados!

Por que usar Airflow? Quando temos apenas 1 workflow é de boa e da para fazer utilizando cron expression por exemplo, mas quando temos centenas de workflows, a coisa muda, fica MUITO mais complexo de utilizar.

Tópicos importantes:

- Iniciou em 2014 com AIRBNB
- Escrito em Python
- Escalabilidade de Gerenciamento - Para ter tudo em um lugar só
- Escalabilidade de Execução - Poder de fogo para executar essas tarefas em paralelo
- Dependências do Ambiente - “Se o ambiente for versão x faça y”
- Conexões com muitas fontes de dados
- Monitoramento - Interface do usuário
- Tolerância de falhas

# DAGs

As um dag é um workflow, é o conjunto de tarefas a serem executadas

Pode aplicar um SLA em cada tarefa → “Tal tarefa tem que levar no máximo 3 segundos, passou disso é erro”, “Tal tarefa deve tentar ser executada até 3 vezes”

Os dag’s nada mais são que arquivos python

# Default Paramters (in dags)

Esses Default Paramters, são parâmetros que ficam acessíveis para qualquer operador dentro do DAG, semelhante a uma variável de ambiente, porém visível apenas aos operadores daquele dag em específico.

# Hooks

São como callbacks, com essa ferramenta, é possível chamar ferramentas externas como bancos de dados, serviços da amazon como S3 entre outros

# Pools

São os limitadores de recursos, é possível agrupar terefas por uso de CPU, tempo etc, com isso os recursos são limitados

# Connections

É possível realizar a reutilização das conexões em diversas partes do dag

# Xcoms

com esse recurso, é possível fazer duas tarefas se comunicam (metadados, parâmetros e variáveis

# Variáveis (formato key-value)

forma de armazenar parâmetros, configurações etc

# Branching

alternar o fluxo de acordo com alguma condição ou iniciar tarefas ao mesmo tempo

# SubDAGS

é possível criar dags dentro de outros dags, são chamados de subdags

# Triggers

Semelhante às triggers em bancos de dados, é possível criar Triggers no airflow

verificar → trigger_rule

# Last Execution Only

Quando é necessário executar apenas uma tarefa idependente, para que nao seja necessário a criação de todo um dag para aquilo, usa o Last Execution Only

# Zombies e Undeads

Se assemelha ao garbage collector, se a tarefa fica em modo zombie, o airflow elimina essa tarefa ou tenta reinicia-la

# Cluster Policies

Seria as permissões de recursos do ambiente

# Jinja Templating

Com essa ferramenta é possível implementar macros

Aparentemente é semelhante ao cold, quando é possível fazer um cfloop em uma <li> para criar várias linhas dentro de uma lista com pouco código

# Packaged DAGs

Combinar workflows diferentes em pacotes

# Backfill

Com os parâmetros START_DATE e END_DATE é possível fazer alterações na regra de negócio no workflow e o mesmo refletir essa mudança para as datas anteriores, passadas por esses parâmetros

# Operadores(Operators)

BashOperator - Executa um comando bash (Ex `mv`)

PythonOperador - Chama uma função Python arbitrária

EmailOperator - envia um e-mail

SimplesHttpOperator - envia uma solicitação

MySqlOperator/SqliteOperator/PostgresOperator/MsSqlOperator/OracleOperator - executa um SQL comando

Sensor - espera um cerrto tempo, arquivo, banco de dados S3, filas SQS, etc…

# Alternativas para o Airflow

- Azkaban
- Oozie