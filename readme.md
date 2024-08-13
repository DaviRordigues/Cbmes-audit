# CBMES Audit

## Visão Geral
Este projeto é uma API para auditoria de logs de sistemas, desenvolvida com **Spring Boot** e conectada a um banco de dados **Oracle**.

## Pré-requisitos

- **Java 21+**
- **Docker**
- **Oracle Database**
- **Postman**

## Configuração do Projeto

### 1. Subindo o Banco de Dados com Docker
Utilize o comando abaixo para subir a imagem Docker do Oracle:

## SWAGGER
http://localhost:8080/swagger-ui/index.html


## Criar img no docker
```bash
docker-compose up
```

## Criar usuario oracle
```
ALTER SESSION SET "_ORACLE_SCRIPT"=true;

CREATE USER admin_user IDENTIFIED BY Oradoc_db1;

GRANT CREATE SESSION TO admin_user;
GRANT CONNECT TO admin_user;
GRANT CONNECT, RESOURCE, DBA TO admin_user;
GRANT UNLIMITED TABLESPACE TO admin_user;
GRANT ALL PRIVILEGES TO admin_user;
````