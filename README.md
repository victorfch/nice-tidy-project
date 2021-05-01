# Nice & Tidy

Proyecto para la administración de la limpieza de habitaciones de los hoteles


## Resumen
En los establecimientos hoteleros, a día de hoy, el control de limpieza de las habitaciones entre el check-out y el siguiente check-in es difícil de organizar. 

Nuestro objetivo principal es crear una aplicación web responsive que agilice la comunicación entre camareros de piso y recepción, consiguiendo así que la información del estado de las habitaciones llegue de manera inmediata. Para ello las camareras de piso dispondrán de un listado con las habitaciones que deben limpiar ese día y al chequearlas como limpias, la información se actualizará en recepción.

De esta forma, conseguiremos facilitar la labor de recepción a la hora de indicar a los clientes cuándo pueden ocupar su habitación.

## Abstract
In hotel establishments nowadays, controlling room service between check-out and the next check-in is difficult to organize.

Our main objective is to create a responsive web application that streamlines communication between chambermaids and reception, thus ensuring that the information on the status of the rooms arrives immediately. For this, the chambermaids will have a list of the rooms that must be cleaned that day. Once they’re checked off as cleaned, the information will be updated at the reception.

This way we will be able to facilitate reception work when it comes to telling customers when they can occupy their room.


## Autores ✒️
* **Lorena Jiménez Tejada** - [lorejim](https://github.com/lorejim)
* **Víctor Manuel Faría Chávez** - [victorfch](https://github.com/victorfch)

2º CFGS Informática y Comunicaciones - Desarrollo de Aplicaciones Web

IES Las Galletas

2020/2021

## Clonar la repo
```sh
git clone https://github.com/victorfch/nice-tidy-project.git
```

## Frontend
El front está desarrollado en Vue.js

### Pre-requisitos 📋
Vue, node y npm
### Instalación 🔧
1. Situarnos en la carpeta front
   ```sh
   cd front
   ```
2. Instalar los paquetes de NPM
   ```sh
   npm install
   ```
### Arrancar el servidor 🚀
```sh
npm run serve
```
El front correrá en localhost:3000

## Backend
El backend está desarrollado en Spring boot

### Pre-requisitos 📋
Java jdk 1.8.0 y Maven
### Instalación 🔧
1. Situarnos en la carpeta del back
   ```sh
   cd back
   ```
2. Instalar los paquetes de maven
   ```sh
   mvn clean install
   ```
### Arrancar el servidor 🚀
```sh
mvn spring-boot:run
```
El backend correrá en localhost:8080
Se usa una base de datos mysql llamada nice, usuario root y sin contraseña

