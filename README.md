## Test developer.avalith
### Autor :Angel Quingaluisa

#### Lenguage Java 11
 - spring boot
 - hibernate
 - gradle
 - H2 DB
 - Intellij IDEA
 - Heroku

### Descripción 
   - Aplicación alojada en Heroku, integrada con hithub  para deployar la rama master y desplegar la APP
   - se implementa 4 servicios rest GET,POS,PUT,DELETE
### Estructura
    - Controller: Capa API REST
    - DTO: POJOS 
    - ENTITY : entidades de la capa de negocio
    - REPOSITORY: sql para la capa de negocio
    - SERVICIO: capas de negocio
    - UTIL: utilitarios generales
    - CONFIG: configuracion de  JACKSON para spring 
### URL APP HEROKU
   - https://avalith-test.herokuapp.com/
   - (GET) http://avalith-test.herokuapp.com/developers
   - (POS) http://avalith-test.herokuapp.com/developers/{id}
   - (PUT) http://avalith-test.herokuapp.com/developers/{id}
   - (DELETE) http://avalith-test.herokuapp.com/developers/{id}
### NOTA: 
   - para los metodos GET,POS,PUT,DELETE es necesario agregar el id en el URL
   - para los metofos POS,PUT se envia una structura Json como body
   - {
    "nombres_completos": "A Quingaluisa",
    "link_github": "www.linkedin/aquingaluisa",
    "tecnologias_conocidas": ["java", "python", ...]
    }
   
![alt text](https://raw.githubusercontent.com/angelquin1986/developer.avalith/master/assert/ejemplo1.png)      

## COMPILAR
    - gradle build
    - esto genera  el archivo developer-0.0.1-SNAPSHOT.jar   
## DOCKER
    para ejecutar la app en docker debe crear la imagen 
    - docker-compose up -d --build

## Ejecutar la app de forma local
    java -jar  developer-0.0.1-SNAPSHOT.jar
