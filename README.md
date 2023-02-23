# Personas App

Ejemplo de API REST usando Spring Boot.

## Instalación

- `git clone https://github.com/akobashikawa/springboot-personas.git`
- `mvn clean install`
- `cd target`
- `java -jar personas-0.0.1-SNAPSHOT.jar`
- http://localhost:8080

## Libraries

- [Bootstrap](https://getbootstrap.com/) v5
    - estilos para el frontend
- [VueJS](https://vuejs.org/) v3
    - javascript para el frontend
- [Axios](https://axios-http.com/) v1.3
    - para las solicitudes del frontend al backend

## Ideas

- Usaremos spring boot para servir tanto el backend como el frontend.
- _spring boot initializr_ para generar el esqueleto de la app

- _java_ para contener el backend

```java
// HolaApplication
SpringApplication.run(PersonasApplication.class, args);
```

- _resources/static_ para contener el frontend

## Personas

- Lista de personas
- El formulario permite que el usuario ingrese nombres
- Los nombres se guardan en una lista
    - La base de datos es una lista en memoria
    - Se invoca POST /personas para guardar el registro
- La lista se jala regularmente
    - Se invoca GET /personas para traer los datos
- La lista tiene botones
    - para editar
        - Se invoca GET /personas/{id} para traer los datos
        - Se invoca PUT /personas/{id} para guardar los cambios
    - para eliminar
        - Se invoca DELETE /personas/{id} para eliminar el registro

