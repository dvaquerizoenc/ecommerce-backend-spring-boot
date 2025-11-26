# 🛒 E-Commerce API RESTful (En desarrollo actualmente)

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)
![Status](https://img.shields.io/badge/Status-En_Desarrollo-yellow)

## 📖 Descripción

Este proyecto consiste en el desarrollo de una **API RESTful** completa para una plataforma de comercio electrónico. El objetivo principal es construir una arquitectura de backend robusta, escalable y siguiendo las **mejores prácticas de la industria** (Clean Architecture, SOLID, DTO Pattern).

El proyecto simula un entorno real de producción, gestionando productos, usuarios y pedidos, con persistencia en base de datos relacional.

## 🚀 Stack Tecnológico

* **Lenguaje:** Java 21 (LTS) - Uso de *Records* y nuevas características.
* **Framework:** Spring Boot 3.3.
* **Base de Datos:** PostgreSQL.
* **ORM:** Spring Data JPA (Hibernate).
* **Herramientas de Build:** Maven.
* **Utilidades:** Lombok (Reducción de Boilerplate).
* **Próximamente:** Spring Security (JWT) y Swagger/OpenAPI.

## 🏗️ Arquitectura y Diseño

El proyecto sigue una **Arquitectura en Capas** estricta para asegurar la separación de responsabilidades:

1.  **Controller Layer:** Manejo de peticiones HTTP (REST). No contiene lógica de negocio.
2.  **Service Layer:** Contiene la lógica de negocio y validaciones.
3.  **Repository Layer:** Abstracción de la persistencia de datos (Spring Data JPA).
4.  **Domain/Model:** Entidades JPA que reflejan la base de datos.
5.  **DTOs (Data Transfer Objects):** Uso de Java `Records` para desacoplar la API externa de las entidades internas de base de datos.

## ⚙️ Configuración e Instalación

### Prerrequisitos
* Java JDK 21 instalado.
* PostgreSQL instalado y corriendo.
* Maven.

### Pasos para ejecutar

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/tu-usuario/ecommerce-api.git](https://github.com/tu-usuario/ecommerce-api.git)
    cd ecommerce-api
    ```

2.  **Configurar Base de Datos:**
    Crea una base de datos en PostgreSQL llamada `ecommerce_db`.
    ```sql
    CREATE DATABASE ecommerce_db;
    ```

3.  **Configurar Credenciales:**
    Edita el archivo `src/main/resources/application.properties` con tu usuario y contraseña de Postgres:
    ```properties
    spring.datasource.username=postgres
    spring.datasource.password=tu_password
    ```

4.  **Ejecutar la aplicación:**
    ```bash
    mvn spring-boot:run
    ```

## 🔌 Endpoints (Documentación API)

Actualmente el módulo de **Productos** está completamente funcional.

| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| `POST` | `/api/products` | Crea un nuevo producto. Requiere JSON body. |
| `GET` | `/api/products` | Obtiene la lista completa de productos. |
| `GET` | `/api/products/{id}` | Obtiene un producto específico por su ID. |

### Ejemplo de JSON (Crear Producto)
```json
{
  "name": "Monitor UltraWide",
  "description": "34 pulgadas, 144Hz",
  "price": 450.00,
  "stock": 10
}
