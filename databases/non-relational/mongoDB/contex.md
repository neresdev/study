# MongoDB

## Problemas de bancos de dados relacionais
 - Problema 1: Incompatibilidade de impedância
   - Quando os objetos estão armazenados em memória secundária, eles estão armazenados em forma estruturada diferentemente de quando os mesmos estão em memória primária, onde estão em forma de objetos relacionados.
   - Com isso sempre que há uma comunicação das aplicações com os bancos de dados relacionais, é necessário a conversão para que a manipulação desses dados seja possível.
   - Para essa conversão, é utilizada as tecnologias ORM porém, há alguns problemas de performance
   - Com ou sem ORM, a performance é problemática por conta das transações e junções das tabelas
 - Problema 2: Grande volume de dados e acessos
   - Necessário muitas máquinas
   - Bancos de dados relacionais não funcionam bem em clusters

## Primeiras influências
 - BigTable (Google) e Amazon (Dynamo)
 - Caracteristicas em comuns
   - Não utilizam modelo relacional
   - Boa execução em cluster
   - Código aberto
   - Nao tem esquema

## Duas classes principais de bancos de dados NoSQL
 - Banco de dados orientado a agregados
   - Modelo chave-valor (Riak, Redis)
   - Modelo de documentos (MongoDB, CounchDB)
   - Modelo família de colunas (Cassandra, Apache HBase)
 - Banco de dados de grafos (Neo4j)
 - Agregado
   - é um conjunto de objetos que precisamos tratar como unidade (conjunto de objetos que precisam ser tratados como um só e muitas vezes, como um objeto)