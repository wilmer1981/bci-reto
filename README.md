# API RESTful para Creación de Usuarios

Esta aplicación en Java proporciona una API RESTful para gestionar el registro de usuarios. Permite agregar información como nombre, correo electrónico, contraseña y detalles de teléfono, asegurando validaciones de formato para el correo y la contraseña.

La aplicación está construida con Spring Boot y emplea una base de datos H2 en memoria.

# Arquitectura

Esta API sigue el patrón Modelo-Vista-Controlador (MVC), y está organizada en los siguientes componentes:

Controladores (controlador): Gestionan las solicitudes HTTP y la lógica de negocio.
Servicios (servicios): Encapsulan la lógica de negocio y manipulan los datos.
Repositorios (repositorio): Se encargan del acceso a la base de datos mediante JPA.
Modelos y Entidades (modelos y entidades): Representan los datos, como Usuario y Telefono.

# Patrones de Diseño

Para mejorar la modularidad y escalabilidad, se han aplicado los siguientes patrones:
MVC: Separa la lógica de negocio de las solicitudes HTTP y los modelos de datos.
Inyección de Dependencias: Facilita la gestión de componentes mediante Spring Boot.
Builder: Se usa para la creación de objetos complejos como Usuario.
Repositorio: Desacopla el acceso a datos de la lógica de negocio.
Singleton: Se aplica en instancias como el generador de tokens JWT.

## Requisitos

Base de datos en memoria: HSQLDB o H2.

Gestión de dependencias: Gradle o Maven.

Persistencia con JPA: EclipseLink, Hibernate u OpenJPA.

Framework: Spring Boot.

Java: Versión 8 o superior.


## Configuración

1. Clona este repositorio en tu máquina local.
2. Edita el archivo src/main/resources/application.properties para configurar la base de datos H2.
3. Ejecuta la aplicación con Maven.
4. Accede a la documentación de la API en: 
     http://localhost:8080/swagger-ui.html

## Endpoints

### Registro de Usuario

- POST /usuarios/registro : 
Permite registrar un nuevo usuario con los siguientes datos en formato json :

{
  
       "name": "Wilmer Saldaña",
  
       "email": "wilmer.saldana@sermaluc.pe",
  
       "password": "admin21",
  
       "phones": [
  
        {
   
           "number": "941478859",
           "citycode": "1",
           "contrycode": "51"
     
        }
   
       ]
  
}

# Respuesta en caso de éxito

En formato json :


{

     "id": "uuid-generado",
  
     "created": "2025-03-05T12:00:00",
  
     "modified": "2025-03-05T12:00:00",
  
     "last_login": "2025-03-05T12:00:00",
  
     "token": "token.jwt.generado",
  
     "isactive": true
  
}


# Formato de error

{

     "mensaje": "mensaje de error"

}

# Validaciones

La API emplea expresiones regulares para garantizar la calidad de los datos ingresados.
