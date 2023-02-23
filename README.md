# Personas App

Ejemplo de API REST usando Spring Boot.

## Instalación

- `git clone https://github.com/akobashikawa/springboot-personas.git`
- `mvn clean install`
- `cd target`
- `java -jar hola-0.0.1-SNAPSHOT.jar`
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

## Ramas

- Cada rama contiene un caso desarrollado.

### [Hola Mundo](https://github.com/akobashikawa/springboot-personas/tree/holamundo)

- Saludar a todos

### [Hola](https://github.com/akobashikawa/springboot-personas/tree/hola)

- Saludar a alguien

### [Personas](https://github.com/akobashikawa/springboot-personas/tree/personas)

- Lista de personas. Base de datos: Array

### [Personas H2](https://github.com/akobashikawa/springboot-personas/tree/personas-h2)

- Lista de personas. Base de datos: H2 en memoria

### [Personas SQL](https://github.com/akobashikawa/springboot-personas/tree/personas-sql)

- Lista de personas. Base de datos SQL Server

