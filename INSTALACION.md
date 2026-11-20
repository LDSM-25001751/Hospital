# Guía de instalación

Sigue los pasos en orden. Al final, la API debe responder en `http://localhost:8080`.

## 1. Requisitos

| Herramienta | Versión | Cómo comprobarla |
|-------------|---------|------------------|
| Java (JDK) | 25 | `java -version` |
| MySQL | 8 | `mysql --version` |
| Git | cualquiera reciente | `git --version` |
| Maven | 3.9 o superior (opcional, el proyecto trae `mvnw`) | `mvn -version` |

`java -version` debe mostrar una versión que empiece con `25`. Si tienes otra, instala el JDK 25 o revisa la propiedad `java.version` en `pom.xml`.

## 2. Obtener el código

Con Git:

```bash
git clone https://github.com/LDSM-25001751/Hospital.git
cd Hospital
```

O descomprime `Hospital.zip` y abre una terminal dentro de la carpeta `Hospital`.

## 3. Crear la base de datos

Entra a MySQL con tu usuario:

```bash
mysql -u root -p
```

Y ejecuta:

```sql
CREATE DATABASE papoisenterprise;
```

Las tablas se crean solas la primera vez que arranca la aplicación (`ddl-auto=update`), no necesitas crearlas a mano.

## 4. Configurar la conexión

Abre `src/main/resources/application.properties` y cambia estas dos líneas por tu usuario y contraseña de MySQL:

```properties
spring.datasource.username= DB_USERNAME
spring.datasource.password= DB_PASSWORD
```

La URL ya apunta a `localhost:3306/papoisenterprise`. Si tu MySQL usa otro puerto, cámbialo en `spring.datasource.url`.


## 5. Compilar y ejecutar

En la sección del proyecto: HospitalApplication

Para después presionar el botón verde en la parte superior.

La primera vez descarga dependencias y puede tardar unos minutos. Termina cuando la consola muestra una línea como `Started HospitalApplication in ... seconds`.

## 6. Verificar que funcionó

Abre en el navegador:

```
http://localhost:8080/api/doctores
```

Debe mostrarse `[]` (lista JSON vacía) o la lista de doctores registrados. Lo mismo para `http://localhost:8080/api/personas`.

## Problemas comunes

| Problema | Causa probable | Qué hacer |
|----------|----------------|-----------|
| `Access denied for user ...` | Usuario o contraseña incorrectos | Revisa `spring.datasource.username` y `spring.datasource.password` |
| `Unknown database 'papoisenterprise'` | No creaste la base de datos | Ejecuta `CREATE DATABASE papoisenterprise;` |
| `Communications link failure` | MySQL apagado o puerto distinto | Inicia el servicio de MySQL y confirma que usa el puerto 3306 |
| `Port 8080 was already in use` | Otro programa usa el puerto | Ciérralo, o agrega `server.port=8081` en `application.properties` |
| `invalid target release: 25` o error de versión de Java | Tienes un JDK anterior al 25 | Instala el JDK 25 y confirma con `java -version` |
| `mvnw: Permission denied` (Linux/macOS) | El script no tiene permiso de ejecución | Ejecuta `chmod +x mvnw` |
| Los datos de ejemplo no aparecen | La base de datos está vacía | Es normal: crea registros con los ejemplos del [MANUAL.md](MANUAL.md) |