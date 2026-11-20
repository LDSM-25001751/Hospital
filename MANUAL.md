# Manual de usuario

## ¿Qué hace?

Hospital API guarda y consulta los datos de las personas y de los doctores del hospital. Permite registrar a alguien nuevo, ver su información, corregirla y eliminarla. Revisa que los datos sean válidos y avisa si ya existe una persona con la misma CURP o un doctor con la misma cédula.

Antes de empezar, la aplicación debe estar corriendo (ver [INSTALACION.md](INSTALACION.md)).

## Cómo hacer las peticiones

Puedes usar Postman, Insomnia, Thunder Client (extensión de VS Code) o `curl`. La dirección base es:

```
http://localhost:8080
```

En las peticiones con cuerpo (POST y PUT), configura el encabezado `Content-Type: application/json`.

## Datos que se piden

### Persona

| Campo | Tipo | Reglas |
|-------|------|--------|
| `nombre` | texto | Obligatorio, de 2 a 100 caracteres, solo letras y espacios |
| `apellidoP` | texto | Obligatorio, de 2 a 50 caracteres, solo letras y espacios |
| `apellidoM` | texto | Obligatorio, de 2 a 50 caracteres, solo letras y espacios |
| `fechaNacimiento` | fecha `AAAA-MM-DD` | Obligatoria, no puede ser futura |
| `edad` | número entero | Obligatoria, de 1 a 120 |
| `genero` | texto | Obligatorio |
| `curp` | texto | Obligatoria, exactamente 18 caracteres, no repetida |
| `estatus` | `true` o `false` | Obligatorio |

### Doctor

Lleva todos los campos de Persona, más:

| Campo | Tipo | Reglas |
|-------|------|--------|
| `especialidad` | texto | Obligatoria |
| `sueldo` | número | Obligatorio, mayor a 0 |
| `numeroCedula` | texto | Obligatoria, exactamente 8 caracteres, no repetida |


### 1. Registrar un doctor

- **Método y ruta:** `POST /api/doctores`
- **Cuerpo (copia y pega):**

```json
{
  "nombre": "Juan",
  "apellidoP": "Gómez",
  "apellidoM": "Ramírez",
  "fechaNacimiento": "1990-05-15",
  "edad": 36,
  "genero": "Masculino",
  "curp": "GOMR900515HGTMRN05",
  "estatus": true,
  "especialidad": "Cardiología",
  "sueldo": 25000.50,
  "numeroCedula": "12345678"
}
```

- **Resultado:** código `201 Created` y el doctor guardado, con su `idPersona` asignado.


### 2. Ver todos los doctores

- **Método y ruta:** `GET /api/doctores`
- **Resultado:** `200 OK` y la lista de doctores.

### 3. Buscar un doctor por id

- **Método y ruta:** `GET /api/doctores/1` (cambia `1` por el id que quieras)
- **Resultado:** `200 OK` y los datos del doctor.

### 4. Actualizar un doctor

- **Método y ruta:** `PUT /api/doctores/1`
- **Cuerpo:** el mismo formato del paso 1, con los datos corregidos. Hay que enviar **todos** los campos, no solo el que cambia.
- **Resultado:** `200 OK` y el doctor actualizado.

### 5. Eliminar un doctor

- **Método y ruta:** `DELETE /api/doctores/1`
- **Resultado:** `204 No Content` (sin cuerpo). El doctor ya no aparece en la lista.

### 6. Registrar y administrar personas

Funciona igual que con los doctores, usando `/api/personas` y los campos de Persona.

```json
{
  "nombre": "María",
  "apellidoP": "López",
  "apellidoM": "Hernández",
  "fechaNacimiento": "1985-11-02",
  "edad": 41,
  "genero": "Femenino",
  "curp": "LOHM851102MGTPRR08",
  "estatus": true
}
```

## Errores comunes

| Código | Qué significa | Qué hacer |
|--------|---------------|-----------|
| `400 Bad Request` | Algún dato no cumple las reglas (campo vacío, CURP con otra longitud, fecha futura...) | Revisa el mensaje del error y corrige ese campo según las tablas de arriba |
| `404 Not Found` | No existe una persona o doctor con ese id (el mensaje dice, por ejemplo, `Doctor no encontrado: 7`) | Consulta la lista con `GET` y usa un id existente |
| `409 Conflict` | Ya existe un registro con esa CURP o esa cédula | Usa una CURP o cédula distinta, o actualiza el registro existente |
| `415 Unsupported Media Type` | Falta el encabezado `Content-Type: application/json` | Agrégalo en tu herramienta |
| `400` con "JSON parse error" | El JSON está mal escrito (comas, comillas) o la fecha no tiene el formato `AAAA-MM-DD` | Revisa el JSON y la fecha |
| No responde / "Connection refused" | La aplicación no está corriendo | Inicia el proyecto con `./mvnw spring-boot:run` |
|                                    |                                 |                                                 |