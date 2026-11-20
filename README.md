# Hospital API

API REST para gestionar las personas y los doctores de un hospital (alta, consulta, actualización y baja), con validación de datos y control de CURP y cédula duplicadas.

## Requisitos

- Java 25 (versión definida en pom.xml)
- Maven 3.9 o superior (el proyecto incluye mvnw, así que no es obligatorio instalarlo)
- MySQL 8
- Git

## Instalación rápida

```bash
git clone https://github.com/LDSM-25001751/Hospital.git
cd Hospital
./mvnw spring-boot:run
```

> Antes de ejecutar, crea la base de datos `papoisenterprise` y pon tu usuario y contraseña de MySQL en `src/main/resources/application.properties`. 

## Uso básico

Con la aplicación corriendo, abre en el navegador:

```
http://localhost:8080/api/doctores
```

Debe mostrarse una lista JSON (vacía, `[]`, si aún no hay doctores).

### Endpoints

| Método | Ruta | Qué hace |
|--------|------|----------|
| GET | `/api/personas` | Lista todas las personas |
| GET | `/api/personas/{id}` | Busca una persona por id |
| POST | `/api/personas` | Crea una persona |
| PUT | `/api/personas/{id}` | Actualiza una persona |
| DELETE | `/api/personas/{id}` | Elimina una persona |
| GET | `/api/doctores` | Lista todos los doctores |
| GET | `/api/doctores/{id}` | Busca un doctor por id |
| POST | `/api/doctores` | Crea un doctor |
| PUT | `/api/doctores/{id}` | Actualiza un doctor |
| DELETE | `/api/doctores/{id}` | Elimina un doctor |


## Herramientas utilizadas

Spring Boot 4.1.2 · Spring Web MVC · Spring Data JPA · Bean Validation · MySQL · Lombok · Maven

## Estructura

```
src/main/java/com/papoisenterprise/hospital/
├── Controller/    Endpoints REST (PersonaController, DoctorController)
├── DTOs/          Datos de entrada y sus validaciones
├── Entities/      Entidades JPA (Persona y Doctor, que hereda de Persona)
├── Exceptions/    Excepciones propias y manejador global de errores
├── Repository/    Acceso a la base de datos (Spring Data JPA)
├── Service/       Lógica de negocio (BaseService, PersonaService, DoctorService)
└── HospitalApplication.java
src/main/resources/
└── application.properties   Configuración y conexión a la base de datos
```

## Documentación

- [INSTALACION.md](INSTALACION.md): cómo dejar el proyecto funcionando
- [MANUAL.md](MANUAL.md): cómo usar la API paso a paso

## Autores

[Nikolas Sterling Villabon Puentes] · [Diego Herrera Ahedo] · [Regina Estrada Guadarrama] · [Christopher Noe Duran Vargas] -
 LDSM41D, UTL