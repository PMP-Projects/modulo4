## Módulo 2.1 PMP

Producer do Módulo 4 do Projeto de PMP para entrega do Projeto Final, nele foi atendido alguns dos seguintes requisitos:

```
Módulo 4 

Crie três aplicações Spring Boot com Kafka:
- 1 produtor
- 2 consumidores

Requisitos:
- Garanta que uma mensagem enviada pelo produtor seja consumida pelas duas aplicações.
- Configure corretamente o Group ID no Kafka.
- Garanta resiliência com três brokers Kafka.
- Configure cinco partições para garantir redundância e melhor paralelismo na leitura das mensagens.

```

### Observação
* **Para utilização integral do 4° módulo, temos esse e outros dois projetos  que contemplam esse desenvolvimento**
* **Esse projeto está em desenvolvimento para integração com outros módulos além dos mencionados. Assim que feitos, serão referenciados nessa descrição...**

| Projeto    | Descrição        | Link do Repositório                                     |
|------------|------------------|---------------------------------------------------------|
| Módulo 4   | Producer Kafka   | Este Repositório                                        |
| Módulo 4.1 | Consumer 1 Kafka | [Módulo 4.1](https://github.com/PMP-Projects/modulo4.1) |
| Módulo 4.2 | Consumer 2 Kafka | [Módulo 4.2](https://github.com/PMP-Projects/modulo4.2) 

---

````

modulo4/
├── 📁 src
│   ├── 📁 main
│   │   ├── 📁 java
│   │   │   └── 📁 modulo4 ← Módulo principal da aplicação
│   │   │       ├── 📁 config ← Configurações gerais da aplicação (Kafka, Beans, etc.)
│   │   │       ├── 📁 controller ← Camada de entrada (exposição de endpoints REST)
│   │   │       ├── 📁 entity ← Entidades e modelos de domínio
│   │   │       ├── 📁 event ← Producers/Consumers e integração com Kafka
│   │   │       ├── 📁 exception ← Tratamento de exceções customizadas
│   │   │       └── 📄 Modulo4Application.java ← Classe principal da aplicação
│   │   └── 📁 resources ← Configurações da aplicação (application.yml/properties, logs, etc.)
│   ├── 📁 test ← Testes unitários e de integração
├── 📁 target ← Artefatos gerados pelo Maven
├── 📄 .gitattributes
├── 📄 .gitignore
├── 📄 docker-compose.yml ← Subida dos containers (Kafka, Zookeeper, aplicação, etc.)
├── 📄 Dockerfile ← Build da imagem Docker da aplicação
├── 📄 HELP.md
├── 📄 mvnw
├── 📄 mvnw.cmd
├── 📄 pom.xml ← Gerenciamento de dependências e build Maven
└── 📄 README.md ← Este arquivo

````
## 🧩 Tecnologias Utilizadas

- **Spring Boot** → Framework Back-End
- **Java** → Linguagem de programação
- **Maven** → Build
- **Docker** → Containers e virtualização
- **MongoDB** → Persistência de dados
- **Graylog** → Central de Logs
- **SonarQube** → Qualidade do Código
- **Github Actions** → CI/CD automatizado

---
## ✅ Qualidade de Código (SonarQube)

> A Qualidade de Código do Projeto é Analisada através do SonarQube, verifique os badges a seguir que apresentam as métricas obtidas no projeto!

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo4&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo4)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo4&metric=bugs)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo4)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo4&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo4)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo4&metric=coverage)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo4)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo4&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo4)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo4&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo4)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo4&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo4)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo4&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo4)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo4&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo4)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo4&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo4)

---

---

## Imagens Docker

- [Módulo 4](https://hub.docker.com/r/juliosn/modulo1)
- [Módulo 4.1](https://hub.docker.com/r/juliosn/modulo2)
- [Módulo 4.2](https://hub.docker.com/r/juliosn/modulo-auth)

---


## 📦 Instalação e Configuração do Ambiente
> Obs.: Tenha as imagens acima baixadas e presentes no seu docker para execução!

### 1️⃣ Clone o projeto na sua máquina e baixe as dependências:
```bash
# Clonar repositório
git clone https://github.com/PMP-Projects/modulo4.git

# Acesse a pasta do projeto
cd modulo4
````

### 2️⃣ Suba os Containers e Rode a Aplicação
```bash
# Inicie os containers (MongoDB, Redis, OpenSearch, Graylog), juntamente com o Dockerfile da aplicação
docker compose up -d --build
```

#### Serviços do Docker Compose

Caso queira acessar o gerenciamento de logs ou a base de dados do MongoDB, você pode utilizar esses acessos
- MongoDB: localhost:27017
- Graylog: localhost:9000

---
## Endpoints

| Método   | Endpoint                       | Descrição                                                                         |
|----------|--------------------------------|-----------------------------------------------------------------------------------|
| `POST`   | `/modulo-producer/v1/pessoa/save` | Realiza o envio do tópico kafka com o key/value especifico para futura integração |

### Exemplos de uso com cURL

* Obs.: cURLs exportados do Insomnia

#### Fazer envio do Tópico

```bash 
curl --request POST \
  --url http://localhost:8084/modulo-producer/v1/pessoa/save \
  --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWxpdXNlcyIsImlhdCI6MTc2Mzg1NDExMCwicm9sZXMiOlsiUk9MRV9VU0VSIl19.WUJzlp_OkKp2-uaI-XuRNqS3fIs0L2fHVualEvbTkXA' \
  --header 'Content-Type: application/json' \
  --data '{
  "nome": "Paulo Nivi",
  "dataNascimento": "2000-10-10"
}'
````


## ✍️ Autor do Projeto

<div align="center">

| [<img src="https://avatars.githubusercontent.com/u/99426563" width=115><br><sub>Júlio Neves</sub>](https://github.com/juliosn)
| :---: |

</div>

---