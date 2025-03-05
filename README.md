
# PI RESTful de creación de usuarios

Esta es una aplicación Java que expone una API RESTful para la creación de usuarios. La API permite registrar nuevos usuarios con información como nombre, correo y contraseña, junto con detalles de teléfono. También se realizan validaciones de formato de correo y contraseña. La aplicación utiliza una base de datos H2 en memoria y Spring Boot.

# Arquitectura
Esta API sigue una arquitectura de aplicación basada en Spring Boot y sigue un patrón de diseño de estilo MVC (Modelo-Vista-Controlador). Algunos de los componentes clave de la arquitectura incluyen:

Controladores: Estos controlan las solicitudes HTTP y gestionan la lógica de negocio de la aplicación. Puedes encontrar los controladores en el paquete com.nisum.latam.controllers.

Servicios: Los servicios encapsulan la lógica de negocio y se utilizan para realizar operaciones en los datos. Los servicios pueden encontrarse en el paquete com.nisum.latam.service.impl.

Repositorios: Se utilizan para interactuar con la base de datos. En este proyecto, se emplea una base de datos H2 en memoria. Los repositorios se encuentran en el paquete com.nisum.latam.repository.

Modelos: Estos representan las entidades de datos de la aplicación, como User y Phone. Puedes encontrar los modelos en el paquete com.nisum.latam.entities.
