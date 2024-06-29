# Prueba tecnica Devsu

## Detalles del proyecto
Este proyecto fue desarrollado utilizando java 17 y springboot como el framework de backend, utiliza postgresql como base de datos y docker como la herramienta de despliegue.
Adicionalmente se utiliza `eureka` como servidor de registro y `spring router` como punto de entrada y recepcion de peticiones de ambos servicios.
## Uso del proyecto
Para correr el proyecto debes realizar los siguientes pasos:
* Clonar el repositorio `git clone https://github.com/RandyDpoe45/devsu-test.git`
* Utilizar el archivo de docker compose para ejecutar toda la solucion, para esto se debe correr con el comando `docker compose up --build`, es probable que la primera vez que este comando sea ejecutado tome bastante tiempo, pues debe construir y empaquetar las imagenes de cada uno de los servicios.
* Despues se puede utilizar el postman [Devsu.postman_collection.json](Devsu.postman_collection.json) agregado en esta entrega.