# Simulador FaleMais

![falemais_screenshot](/src/main/resources/images/falemais_screenshot.png?raw=true&s=200 "Simulador FaleMais")

## Objetivo
Esta aplicação tem o objetivo de simular o cálculo do valor de uma ligação para o cliente Telzir, incluindo
o plano FaleMais. No caso, o cliente pode escolher os códigos das cidades de origem e destino, o tempo da ligação em minutos e escolher qual o plano FaleMais deseja simular. Os resultados são apresentados tanto com o plano FaleMais quanto sem o plano.

## Características
Esta aplicação foi desenvolvida para cumprir o desafio da empresa Vizir. Ela foi desenvolvida utilizando
os seguintes recursos:

- Spring Boot para o backend
- Angular 7 para o frontend

## Pré-requisitos
Para que seja possível compilar e rodar esta aplicação, é necessário ter instalado as seguintes ferramentas:

- JDK 1.8
- Node 8.15 ou superior. (A utilizada na construção deste projeto foi a 8.15)

## Como usar

### Início Rápido

``` bash
cd falemais
./mvnw clean package spring-boot:repackage
cd target
java -jar falemais-0.0.1-SNAPSHOT.jar
```

Após isso, você pode ter acesso ao sistema usando o link (http://localhost:8080/)

### Passo a passo

#### Compilando o front-end

Todo o código fonte do Frontend desta aplicação encontra-se em (a partir da pasta raiz do projeto):

> `src/main/resources/frontend`

Em caso de alteração em que haja necessidade de gerar um novo release do front, é necessário executar o seguinte passo:

``` bash
cd src/main/resources/frontend
npm run build
```

Após o término da execução, utilizar o passo seguinte para compilar o projeto novamente.

#### Compilando o projeto

Para compilar o projeto, basta entrar na pasta raiz do projeto e executar o seguinte comando do maven:

``` bash
./mvnw clean package spring-boot:repackage
```

Após a execução, o artefato gerado poderá ser encontrado na pasta (a partir da pasta raiz do projeto):

> `falemais/target`

#### Executando o projeto

Para executar o projeto, basta entrar na pasta raiz do projeto e executar o seguinte comando:

``` bash
java -jar target/falemais-0.0.1-SNAPSHOT.jar
```

Após isso, você pode ter acesso ao sistema usando o link (http://localhost:8080/)

### Testes

Para executar os testes desta aplicação, basta executar o comando (a partir da pasta raiz):

``` bash
./mvnw clean test
```

## Desenvolvedor

* [enosgomes](https://github.com/enosgomes)

## Licença

Todo o código desenvolvido nesta aplicação é de total propriedade da empresa [Vizir](https://github.com/vizir).
