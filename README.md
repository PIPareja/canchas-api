# 🏟️ Canchas API

REST API para gestión de reservas de canchas deportivas, desarrollada con Java y Spring Boot.

## 🛠️ Stack

- **Java 21**
- **Spring Boot 3.5**
- **Spring Data JPA + Hibernate**
- **MySQL**
- **Maven**
- **Lombok**

## 📋 Funcionalidades

- CRUD completo de canchas deportivas
- CRUD completo de reservas
- Validación de conflictos de horario (no permite reservas solapadas)
- Validación de disponibilidad de cancha
- Manejo global de errores con mensajes descriptivos
- Relaciones entre entidades con foreign keys generadas automáticamente

## 🚀 Cómo correr el proyecto localmente

### Requisitos
- Java 21
- Maven
- MySQL

### Pasos

1. Clona el repositorio
```bash
   git clone https://github.com/PIPareja/canchas-api.git
```

2. Crea la base de datos
```sql
   CREATE DATABASE canchas;
```

3. Configura las credenciales en `src/main/resources/application.properties`
```properties
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
```

4. Ejecuta el proyecto
```bash
   mvn spring-boot:run
```

El servidor queda disponible en `http://localhost:8080`

## 📡 Endpoints

### Canchas

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/canchas` | Obtener todas las canchas |
| GET | `/api/canchas/{id}` | Obtener cancha por ID |
| POST | `/api/canchas` | Crear cancha |
| PUT | `/api/canchas/{id}` | Actualizar cancha |
| DELETE | `/api/canchas/{id}` | Eliminar cancha |

### Reservas

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/reservas` | Obtener todas las reservas |
| GET | `/api/reservas/{id}` | Obtener reserva por ID |
| POST | `/api/reservas` | Crear reserva |
| PUT | `/api/reservas/{id}` | Actualizar reserva |
| DELETE | `/api/reservas/{id}` | Eliminar reserva |

## 📦 Ejemplo de uso

### Crear una cancha
```json
POST /api/canchas
{
    "nombre": "Cancha 1",
    "tipo": "Fútbol",
    "disponible": true
}
```

### Crear una reserva
```json
POST /api/reservas
{
    "nombreUsuario": "Pablo Pareja",
    "fechaInicio": "2026-05-15T10:00:00",
    "fechaFin": "2026-05-15T12:00:00",
    "cancha": {
        "id": 1
    }
}
```