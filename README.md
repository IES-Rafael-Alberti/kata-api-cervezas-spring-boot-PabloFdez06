[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/um2scOsx)

# Kata API - Spring Boot

Implementación de una API REST funcional [CRUD](https://www.codecademy.com/articles/what-is-crud) sobre cervezas, cervecerías, categorías y estilos usando Spring Boot.

## Objetivo

Crear una [API REST](https://github.com/OAI/OpenAPI-Specification) funcional que permita:
- Aprender y usar diferentes [métodos HTTP](https://developer.mozilla.org/es/docs/Web/HTTP/Methods) (GET, POST, PUT, PATCH, DELETE)
- Implementar operaciones CRUD completas
- Trabajar con Spring Boot y JPA

## Requisitos

- Java 17 o superior
- Maven 3.6 o superior
- MySQL 8.0 o superior
- Git

## Tecnologías utilizadas

- Spring Boot 3.2.0
- Spring Data JPA
- MySQL Connector/J
- Lombok
- SpringDoc OpenAPI (Swagger)
- Maven

## Configuración de la base de datos

1. Crear la base de datos en MySQL:
```sql
CREATE DATABASE cervezas_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

2. Importar los scripts SQL del proyecto (en el orden mostrado):
```bash
mysql -u root -p cervezas_db < initSQL/01-create-db.sql
mysql -u root -p cervezas_db < initSQL/categories.sql
mysql -u root -p cervezas_db < initSQL/styles.sql
mysql -u root -p cervezas_db < initSQL/breweries.sql
mysql -u root -p cervezas_db < initSQL/beers.sql
```

3. Configurar las credenciales de base de datos en `src/main/resources/application.yml`

## Ejecución del proyecto

1. Clonar el repositorio
2. Compilar y ejecutar:
```bash
mvn clean install
mvn spring-boot:run
```

3. La API estará disponible en: `http://localhost:8080/api`
4. Swagger UI: `http://localhost:8080/api/swagger-ui.html`

## Objetivos completados

- [x] Implementar CRUD completo para cervezas (GET, POST, PUT, PATCH, DELETE)
- [x] Implementar lectura (GET) para cervecerías, categorías y estilos
- [x] Usar diferentes métodos HTTP correctamente
- [x] Integración con Swagger para documentación automática
- [x] API REST con Spring Boot y Spring Data JPA

## Ejemplos de uso de la API

### Obtener todas las cervezas
```bash
curl -X GET http://localhost:8080/api/beers
```

### Obtener cerveza por ID
```bash
curl -X GET http://localhost:8080/api/beers/1
```

### Crear nueva cerveza
```bash
curl -X POST http://localhost:8080/api/beers \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Cerveza Premium",
    "categoryId": 1,
    "styleId": 1,
    "abv": 5.5,
    "ibu": 25,
    "description": "Una excelente cerveza premium"
  }'
```

### Actualizar cerveza
```bash
curl -X PUT http://localhost:8080/api/beers/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Cerveza Premium Updated",
    "categoryId": 1,
    "styleId": 1,
    "abv": 6.0,
    "ibu": 30,
    "description": "Actualizada"
  }'
```

### Actualizar parcialmente cerveza (PATCH)
```bash
curl -X PATCH http://localhost:8080/api/beers/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Nuevo nombre"
  }'
```

### Eliminar cerveza
```bash
curl -X DELETE http://localhost:8080/api/beers/1
```

### Obtener todas las cervecerías
```bash
curl -X GET http://localhost:8080/api/breweries
```

### Obtener todas las categorías
```bash
curl -X GET http://localhost:8080/api/categories
```

### Obtener todos los estilos
```bash
curl -X GET http://localhost:8080/api/styles
```

## Estructura del proyecto

```
src/
├── main/
│   ├── java/com/example/cervezas/
│   │   ├── controller/
│   │   │   ├── BeerController.java
│   │   │   ├── BrewerieController.java
│   │   │   ├── CategorieController.java
│   │   │   └── StyleController.java
│   │   ├── entity/
│   │   │   ├── Beer.java
│   │   │   ├── Brewerie.java
│   │   │   ├── Categorie.java
│   │   │   └── Style.java
│   │   ├── repository/
│   │   │   ├── BeerRepository.java
│   │   │   ├── BrewerieRepository.java
│   │   │   ├── CategorieRepository.java
│   │   │   └── StyleRepository.java
│   │   └── KataApiCervezasApplication.java
│   └── resources/
│       └── application.yml
└── test/
```

## Notas importantes

- La API utiliza Jakarta Persistence (JPA) para la capa de persistencia
- Swagger está disponible en http://localhost:8080/api/swagger-ui.html
- Los DTOs y servicios pueden ser agregados para mejorar la arquitectura
- Actualmente la paginación no está implementada pero puede ser agregada fácilmente con PageRequest  


## Descripción de rutas a utilizar

| Endpoint         | Resultado                               | Método   |
|----------------- |-----------------------------------------|:--------:|
|`/beers`          | Muestra todas las cervezas              | GET      |
|`/beer`           | Añadir una cerveza                      | POST     |
|`/beer/{id}`      | Mostrar la cerveza con el id `{id}`     | GET      |
|`/beer/{id}`      | Eliminar una cerveza                    | DELETE   |
|`/beer/{id}`      | Modificar una cerveza                   | PUT      |
|`/beer/{id}`      | Modificar parcialmente una cerveza      | PUT o PATCH    |
|`/breweries`      | Listar todas las cerveceras             | GET      |
|`/brewerie/{id}`  | Mostrar la cervecera `{id}`             | GET      |
|`/categories`     | Listar todas las categorías             | GET      |
|`/categorie/{id}` | Mostrar la categoría `{id}`             | GET      |
|`/styles`         | Listar todos los estilos -style-        | GET      |
|`/style/{id}`     | Mostrar el estilo -style- `{id}`        | GET      |


## Colaboradores (idiomas en orden alfabético)

[Laravel](https://github.com/SaphireVert/Kata-API/tree/saphirevert/laravel) → [![saphirevert-repos][saphirevert-shield]][saphirevert-url]


[saphirevert-shield]: https://badgen.net/badge/Github/SaphireVert/green?icon=https://svgshare.com/i/Srf.svg
[saphirevert-url]: https://github.com/saphirevert/

---

## Conclusión

En este proyecto he desarrollado una API REST completamente funcional utilizando Spring Boot, aplicando los principios de arquitectura en capas y buenas prácticas de desarrollo. He logrado implementar un sistema CRUD completo para la gestión de cervezas, junto con endpoints de consulta para cervecerías, categorías y estilos.

Durante el desarrollo he trabajado con tecnologías modernas del ecosistema Java como Spring Data JPA para la persistencia de datos, Lombok para reducir el código boilerplate, y SpringDoc OpenAPI para generar documentación automática e interactiva de la API. La integración con MySQL mediante Docker Compose me ha permitido tener un entorno de desarrollo reproducible y fácilmente desplegable.

He implementado correctamente todos los métodos HTTP requeridos (GET, POST, PUT, PATCH, DELETE), comprendiendo las diferencias entre ellos y aplicándolos según las necesidades de cada operación. La aplicación sigue una arquitectura clara separada en capas: controladores REST, repositorios JPA y entidades, lo que facilita el mantenimiento y la escalabilidad del código.

Este proyecto me ha permitido consolidar conocimientos sobre el desarrollo de APIs RESTful, el uso de frameworks modernos de Java, la gestión de bases de datos relacionales, y la importancia de una buena documentación mediante herramientas como Swagger. Además, he aprendido a configurar y gestionar contenedores Docker para el entorno de desarrollo, una habilidad fundamental en el desarrollo de software actual.

