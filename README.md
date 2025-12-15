# Apple and Basket — Backend

---

## Tecnologías
- Java + Spring Boot
- API REST 
- Base de datos (FreeDB)

---

## Requisitos
- Java 17+ 
- Maven (o Maven Wrapper `./mvnw`)
- Acceso a una base de datos (FreeDB)

---

# Configuración de Base de Datos (FreeDB)

El backend requiere credenciales para conectarse a FreeDB.

## Configura los valores en `application.properties` de la siguiente manera o con la información de tu DB

spring.application.name=ProyectoFinal
spring.jpa.hibernate.ddl-auto=update

# Conexión a la base de datos MariaDB
spring.datasource.url=jdbc:mariadb://sql.freedb.tech:3306/freedb_proyectoFinal-bd?allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username=freedb_rootJuego
spring.datasource.password=%vDM65%!He#jcD%
spring.jpa.database-platform=org.hibernate.dialect.MariaDBDialect

# CHECAR ESTO
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

## Ejecutar en local:
Con Maven Wrapper:
* ./mvnw spring-boot:run

Con Maven instalado:
* mvn spring-boot:run

## Compilar:
Crear el .jar:
./mvnw clean package

Ejecutar el .jar:
java -jar target/*.jar

## Despliegue en Railway:
- Sube el repo a GitHub

- En Railway:
New Project
Deploy from GitHub Repo
Selecciona este repositorio
En Variables agrega tus credenciales de BD si aun no las configuras en local:

SPRING_DATASOURCE_URL

SPRING_DATASOURCE_USERNAME

SPRING_DATASOURCE_PASSWORD

Railway detecta Maven y compila automáticamente.

Railway te dará una URL:

proyectofinal-backend-production-91d7.up.railway.app

## Peticiones de consumo:

1) CREATE POST /login:
curl -X POST "proyectofinal-backend-production-91d7.up.railway.app/login" \ -H "Content-Type: application/json" \ -d "{\"usuario\":\"layu\",\"password\":\"1234\"}"
 
2) READ /scoreboard
curl -X GET "proyectofinal-backend-production-91d7.up.railway.app/scoreboard"

3) UPDATE POST /puntaje:
curl -X POST "proyectofinal-backend-production-91d7.up.railway.app/puntaje" \ -H "Content-Type: application/json" \ -d "{\"usuario\":\"epxon\",\"maxPuntuacion\":120}"

4) DELETE /borrar
curl -X DELETE "proyectofinal-backend-production-91d7.up.railway.app/borrar" \ -H "Content-Type: application/json" \ -d "{\"usuario\":\"karol\",\"password\":\"1234\"}"
