# Proyecto Backend con Spring Boot

Este es un backend desarrollado con Spring Boot como prueba técnica para el cargo de Desarrollador Fullstack en la empresa NTT Data Colombia. Proporciona una API RESTful para traer los datos del cliente con Tipo Identificación 'C' y Numero de Documento '23445322'.

## Requisitos previos

Asegúrate de tener los siguientes requisitos previos instalados:

- [JDK 17 o superior](https://openjdk.java.net/)
- [Maven](https://maven.apache.org/)

## Archivo Jar ejecutable

El archivo Jar se encuentra en la carpeta Target con el nombre 'clientes-backend-0.0.1-SNAPSHOT.jar'.
Para ejecturalo es necesario descargarlo y en la terminal ejecutar el comando
>>> java -jar clientes-backend-0.0.1-SNAPSHOT.jar

## Creación del archivo Jar

Para esto es necesario clonar el repositorio y estando en la carpeta raíz del proyecto ejecutar el comando
>>> mvn clean package
Y este creará el Jar en la carpeta Target
