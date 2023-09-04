# Prueba MicroServicios - Comercio Electrónico: Sistema de Precios

Este servicio REST se ha construido con Spring Boot y tiene como objetivo proporcionar un punto de acceso para consultar el precio de un producto para una marca y una fecha específica.

## Tabla de Contenidos

- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Arquitectura Hexagonal](#arquitectura-hexagonal)
- [API Endpoints](#api-endpoints)
    - [Consultar precio](#consultar-precio)
- [BBDD H2](#bbdd)


## Tecnologías Utilizadas

* **Spring Boot**: Framework utilizado para construir la aplicación.
* **Spring Data JPA**: Proporciona facilidades para trabajar con bases de datos mediante JPA.
* **H2**: Base de datos en memoria utilizada para este proyecto.
* **JUnit & Mockito**: Usados para testing del proyecto.

## Estructura del Proyecto

* **Modelo**: Define la entidad Price que mapea la tabla PRICES en la base de datos.
* **Repositorio**: Interfaz PriceRepository que extiende JpaRepository para proporcionar operaciones CRUD sobre la entidad Price.
* **Servicio**: Capa de servicio que contiene la lógica de negocio.
* **Controlador**: Define el endpoint REST para consultar el precio.

### Arquitectura Hexagonal

* **application**: Contiene la lógica relacionada con la entrada/salida de la aplicación, como controladores REST.
* **domain**: Aloja la lógica del dominio, entidades, reglas de negocio, y servicios.
* **configuration**: Configuraciones específicas de la aplicación.
* **ports**: Define las interfaces para adaptadores primarios y secundarios.
    * **repository**: Repositorios JPA y otras interfaces de persistencia.
    * **service**: Servicios de aplicación y del dominio.

## API Endpoints

### Consultar precio

#### Request:

http://localhost:8080/bcnc-app/api/prices?applicationDate=2020-06-14T15:00:00&productId=35455&brandId=1

#### Response:

```json
{
"productId": 35455,
"brandId": 1,
"priceList": 2,
"startDate": "2020-06-14T15:00:00",
"endDate": "2020-06-14T18:30:00",
"finalPrice": 25.45,
"currency": "EUR"
}
```

## BBDD
http://localhost:8080/bcnc-app/h2-console/

* Driver Class: org.h2.Driver
* JDBC URL: jdbc:h2:mem:bcnc-app
* Username: root
* PDW: 



