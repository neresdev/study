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