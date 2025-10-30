# 🏢 Sucursales API

API REST para la gestión integral de sucursales empresariales, construida con **Spring Boot** siguiendo los principios de **Arquitectura Hexagonal** (Puertos y Adaptadores) y **Domain-Driven Design (DDD)**.

## 📋 Tabla de Contenidos

- [Características](#-características)
- [Tecnologías](#-tecnologías)
- [Arquitectura](#-arquitectura)
- [Módulos del Sistema](#-módulos-del-sistema)
- [Requisitos Previos](#-requisitos-previos)
- [Instalación](#-instalación)
- [Configuración](#-configuración)
- [Ejecución](#-ejecución)
- [API Endpoints](#-api-endpoints)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Seguridad y Autenticación](#-seguridad-y-autenticación)

---

## ✨ Características

- ✅ **Arquitectura Hexagonal** (Puertos y Adaptadores)
- ✅ **Domain-Driven Design (DDD)** con Value Objects y Agregados
- ✅ **Autenticación JWT** (JSON Web Tokens)
- ✅ **RESTful API** con operaciones CRUD completas
- ✅ **Validaciones robustas** en capa de dominio
- ✅ **Manejo global de excepciones**
- ✅ **Gestión de archivos** (imágenes de sucursales)
- ✅ **Base de datos relacional** MySQL
- ✅ **Spring Security** configurado
- ✅ **8 módulos** independientes y escalables

---

## 🛠 Tecnologías

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| **Java** | 17 | Lenguaje de programación |
| **Spring Boot** | 3.5.7 | Framework principal |
| **Spring Data JPA** | 3.5.7 | Persistencia de datos |
| **Spring Security** | 6.x | Seguridad y autenticación |
| **MySQL** | 8.x | Base de datos relacional |
| **JWT (JJWT)** | 0.12.3 | Tokens de autenticación |
| **Lombok** | Latest | Reducción de boilerplate |
| **Maven** | 3.x | Gestión de dependencias |
| **Hibernate** | 6.x | ORM |

---

## 🏗 Arquitectura

Este proyecto implementa **Arquitectura Hexagonal** con las siguientes capas:

```
┌─────────────────────────────────────────┐
│         INFRASTRUCTURE LAYER            │
│  (Controllers, Persistence, Config)     │
│                                         │
│  ┌───────────────────────────────────┐ │
│  │      APPLICATION LAYER            │ │
│  │  (Use Cases, Services, DTOs)      │ │
│  │                                   │ │
│  │  ┌─────────────────────────────┐ │ │
│  │  │      DOMAIN LAYER           │ │ │
│  │  │  (Entities, Value Objects,  │ │ │
│  │  │   Business Logic, Ports)    │ │ │
│  │  └─────────────────────────────┘ │ │
│  └───────────────────────────────────┘ │
└─────────────────────────────────────────┘
```

### Principios Aplicados

- **Inversión de Dependencias**: Las capas externas dependen de las internas
- **Separación de Responsabilidades**: Cada capa tiene un propósito único
- **Puertos y Adaptadores**: Interfaces que definen contratos entre capas
- **Value Objects**: Objetos inmutables con validación encapsulada
- **Agregados**: Entidades con límites claros de consistencia
- **Use Cases**: Lógica de aplicación independiente de frameworks

---

## 📦 Módulos del Sistema

### 1. 🔐 **Auth** (Autenticación)
Sistema de autenticación con JWT para login/logout y generación de tokens.

### 2. 🏪 **Sucursales**
Gestión completa de sucursales con coordenadas, direcciones y teléfonos.

**Value Objects**: `SucursalId`, `Coordenadas`, `Direccion`, `TelefonoPrincipal`

### 3. 🕒 **Horarios de Sucursal**
Administración de horarios de operación por día de la semana.

**Value Objects**: `HorarioSucursalId`, `DiaSemana`, `HoraApertura`, `HoraCierre`

### 4. 📞 **Contactos de Sucursal**
Registro de múltiples contactos por sucursal (WhatsApp, email, etc.).

**Value Objects**: `ContactoSucursalId`, `NumeroContacto`, `TipoContacto`

### 5. 👥 **Personal**
Gestión de empleados asignados a sucursales.

**Value Objects**: `PersonalId`, `NombreCompleto`, `Cargo`, `CorreoInstitucional`

### 6. 📱 **Teléfonos del Personal**
Administración de números telefónicos de empleados.

**Value Objects**: `TelefonoPersonalId`, `NumeroTelefono`, `TipoTelefono`

### 7. 🏢 **Números Corporativos**
Gestión de números corporativos asignables a empleados.

**Value Objects**: `NumeroCorporativoId`, `Numero`

### 8. 🖼️ **Imágenes de Sucursal**
Upload y gestión de imágenes asociadas a sucursales.

**Value Objects**: `ImagenSucursalId`, `NombreArchivo`, `RutaArchivo`, `Descripcion`

---

## 📋 Requisitos Previos

- **Java JDK 17** o superior
- **Maven 3.6+**
- **MySQL 8.0+**
- **Git**

---

## 🚀 Instalación

### 1. Clonar el repositorio

```bash
git clone <url-del-repositorio>
cd sucursales-api
```

### 2. Configurar la base de datos MySQL

```sql
CREATE DATABASE sucursales_db;
```

### 3. Configurar credenciales

Editar `src/main/resources/application.properties`:

```properties
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

### 4. Instalar dependencias

```bash
mvn clean install
```

---

## ⚙️ Configuración

### application.properties

```properties
# Aplicación
spring.application.name=Sucursales API

# Base de Datos
spring.datasource.url=jdbc:mysql://localhost:3306/sucursales_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Servidor
server.port=8080

# JWT
jwt.secret=tu_clave_secreta_segura
jwt.expiration=86400000

# File Upload
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
```

---

## ▶️ Ejecución

### Usando Maven

```bash
mvn spring-boot:run
```

### Usando el JAR

```bash
mvn clean package
java -jar target/sucursales-api-0.0.1-SNAPSHOT.jar
```

**La aplicación estará disponible en**: `http://localhost:8080`

---

## 📡 API Endpoints

### 🔐 Autenticación

| Método | Endpoint | Descripción | Auth |
|--------|----------|-------------|------|
| `POST` | `/api/auth/login` | Iniciar sesión (obtener JWT) | ❌ |
| `POST` | `/api/auth/logout` | Cerrar sesión | ✅ |

### 🏪 Sucursales

| Método | Endpoint | Descripción | Auth |
|--------|----------|-------------|------|
| `POST` | `/api/sucursales` | Crear sucursal | ✅ |
| `GET` | `/api/sucursales/{id}` | Obtener por ID | ✅ |
| `GET` | `/api/sucursales?onlyActive=true` | Solo activas | ✅ |
| `PUT` | `/api/sucursales/{id}` | Actualizar | ✅ |
| `PATCH` | `/api/sucursales/{id}/deactivate` | Desactivar | ✅ |
| `DELETE` | `/api/sucursales/{id}` | Eliminar | ✅ |

### Otros Endpoints

Ver documentación completa en [ENDPOINTS.md](./ENDPOINTS.md) que incluye:
- 🕒 Horarios de Sucursal (5 endpoints)
- 📞 Contactos de Sucursal (5 endpoints)
- 👥 Personal (7 endpoints)
- 📱 Teléfonos del Personal (5 endpoints)
- 🏢 Números Corporativos (9 endpoints)
- 🖼️ Imágenes de Sucursal (5 endpoints)

**Total: 45+ endpoints RESTful**

---

## 🔐 Seguridad y Autenticación

### JWT (JSON Web Tokens)

La API utiliza JWT para autenticación:

1. **Login**: Enviar credenciales a `/api/auth/login`
2. **Token**: El servidor responde con un JWT válido por 24 horas
3. **Uso**: Incluir el token en cada petición:

```http
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

### Ejemplo de Login

**Request**:
```json
POST /api/auth/login
Content-Type: application/json

{
  "correoInstitucional": "usuario@empresa.com",
  "contrasena": "password123"
}
```

**Response**:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "type": "Bearer",
  "correoInstitucional": "usuario@empresa.com"
}
```

### Endpoints Públicos vs Protegidos

- **Público**: `/api/auth/login`
- **Protegidos**: Todos los demás requieren JWT en el header `Authorization`

---

## 📁 Estructura del Proyecto

```
src/
└── main/
    ├── java/
    │   └── com/empresa/sucursales_api/
    │       ├── domain/
    │       │   ├── sucursal/
    │       │   │   ├── model/
    │       │   │   │   └── Sucursal.java                # Entidad de dominio (agregado)
    │       │   │   └── valueobject/
    │       │   │       ├── SucursalId.java              # VO: identificador único
    │       │   │       ├── Coordenadas.java             # VO: latitud/longitud con validación
    │       │   │       ├── Direccion.java               # VO: dirección con validación
    │       │   │       └── TelefonoPrincipal.java       # VO: teléfono con validación de longitud
    │       │   │
    │       │   ├── horariosucursal/
    │       │   │   ├── model/
    │       │   │   │   └── HorarioSucursal.java         # Entidad de dominio (agregado)
    │       │   │   └── valueobject/
    │       │   │       ├── HorarioSucursalId.java       # VO: identificador único
    │       │   │       ├── DiaSemana.java               # Enum: días de la semana
    │       │   │       ├── HoraApertura.java            # VO: hora de apertura con validación
    │       │   │       └── HoraCierre.java              # VO: hora de cierre con validación
    │       │   │
    │       │   └── contactosucursal/
    │       │       ├── model/
    │       │       │   └── ContactoSucursal.java        # Entidad de dominio (agregado)
    │       │       ├── valueobject/
    │       │       │   ├── ContactoSucursalId.java      # VO: identificador único
    │       │       │   ├── NumeroContacto.java          # VO: número con validación
    │       │       │   └── TipoContacto.java            # VO: tipo con validación
    │       │       └── port/
    │       │           └── out/
    │       │               └── ContactoSucursalRepositoryPort.java
    │       │   │
    │       │   └── personal/
    │       │       ├── model/
    │       │       │   └── Personal.java                # Entidad de dominio
    │       │       ├── valueobject/
    │       │       │   ├── PersonalId.java              # VO: identificador único
    │       │       │   ├── NombreCompleto.java          # VO: nombre con validación
    │       │       │   ├── Cargo.java                   # VO: cargo opcional
    │       │       │   └── CorreoInstitucional.java     # VO: correo con validación
    │       │       └── port/
    │       │           └── out/
    │       │               └── PersonalRepositoryPort.java
    │       │   │
    │       │   └── telefonopersonal/
    │       │       ├── model/
    │       │       │   └── TelefonoPersonal.java        # Entidad de dominio
    │       │       ├── valueobject/
    │       │       │   ├── TelefonoPersonalId.java      # VO: identificador único
    │       │       │   ├── NumeroTelefono.java          # VO: número con validación
    │       │       │   └── TipoTelefono.java            # VO: tipo con validación
    │       │       └── port/
    │       │           └── out/
    │       │               └── TelefonoPersonalRepositoryPort.java
    │       │   │
    │       │   └── numerocorporativo/
    │       │       ├── model/
    │       │       │   └── NumeroCorporativo.java       # Entidad de dominio
    │       │       ├── valueobject/
    │       │       │   ├── NumeroCorporativoId.java     # VO: identificador único
    │       │       │   └── Numero.java                  # VO: número con validación única
    │       │       └── port/
    │       │           └── out/
    │       │               └── NumeroCorporativoRepositoryPort.java
    │       │   │
    │       │   └── imagensucursal/
    │       │       ├── model/
    │       │       │   └── ImagenSucursal.java          # Entidad de dominio
    │       │       ├── valueobject/
    │       │       │   ├── ImagenSucursalId.java        # VO: identificador único
    │       │       │   ├── NombreArchivo.java           # VO: nombre con validación
    │       │       │   ├── RutaArchivo.java             # VO: ruta con validación
    │       │       │   └── Descripcion.java             # VO: descripción opcional
    │       │       └── port/
    │       │           └── out/
    │       │               └── ImagenSucursalRepositoryPort.java
    │       │
    │       ├── application/
    │       │   ├── auth/
    │       │   │   ├── dto/
    │       │   │   │   ├── LoginRequest.java            # DTO de entrada para login
    │       │   │   │   ├── LoginResponse.java           # DTO de salida con token
    │       │   │   │   └── LogoutResponse.java          # DTO de salida para logout
    │       │   │   ├── port/
    │       │   │   │   ├── in/
    │       │   │   │   │   └── AuthUseCase.java         # Caso de uso de autenticación
    │       │   │   │   └── out/
    │       │   │   │       └── (Usa PersonalRepositoryPort)
    │       │   │   └── service/
    │       │   │       └── AuthService.java             # Implementación de autenticación
    │       │   │
    │       │   ├── sucursal/
    │       │   │   ├── dto/
    │       │   │   │   ├── SucursalRequest.java         # DTO de entrada para crear
    │       │   │   │   ├── SucursalResponse.java        # DTO de salida
    │       │   │   │   └── SucursalUpdateRequest.java   # DTO de entrada para actualizar
    │       │   │   ├── port/
    │       │   │   │   ├── in/                          # Puertos de entrada (Use Cases)
    │       │   │   │   │   ├── CreateSucursalUseCase.java
    │       │   │   │   │   ├── GetSucursalUseCase.java
    │       │   │   │   │   ├── UpdateSucursalUseCase.java
    │       │   │   │   │   └── DeleteSucursalUseCase.java
    │       │   │   │   └── out/                         # Puertos de salida (repositorio)
    │       │   │   │       └── SucursalRepositoryPort.java
    │       │   │   └── service/
    │       │   │       └── SucursalService.java         # Implementación de casos de uso
    │       │   │
    │       │   └── horariosucursal/
    │       │       ├── dto/
    │       │       │   ├── HorarioSucursalRequest.java
    │       │       │   ├── HorarioSucursalResponse.java
    │       │       │   └── HorarioSucursalUpdateRequest.java
    │       │       ├── port/
    │       │       │   ├── in/
    │       │       │   │   ├── CreateHorarioSucursalUseCase.java
    │       │       │   │   ├── GetHorarioSucursalUseCase.java
    │       │       │   │   ├── UpdateHorarioSucursalUseCase.java
    │       │       │   │   └── DeleteHorarioSucursalUseCase.java
    │       │       │   └── out/
    │       │       │       └── HorarioSucursalRepositoryPort.java
    │       │       └── service/
    │       │           └── HorarioSucursalService.java
    │       │
    │       │   └── contactosucursal/
    │       │       ├── dto/
    │       │       │   ├── ContactoSucursalRequest.java
    │       │       │   ├── ContactoSucursalResponse.java
    │       │       │   └── ContactoSucursalUpdateRequest.java
    │       │       ├── port/
    │       │       │   ├── in/
    │       │       │   │   └── ManageContactoSucursalUseCase.java
    │       │       │   └── out/
    │       │       │       └── ContactoSucursalRepositoryPort.java
    │       │       └── service/
    │       │           └── ContactoSucursalService.java
    │       │
    │       │   └── personal/
    │       │       ├── dto/
    │       │       │   ├── PersonalRequest.java
    │       │       │   ├── PersonalResponse.java
    │       │       │   └── PersonalUpdateRequest.java
    │       │       ├── port/
    │       │       │   ├── in/
    │       │       │   │   └── ManagePersonalUseCase.java
    │       │       │   └── out/
    │       │       │       └── PersonalRepositoryPort.java
    │       │       └── service/
    │       │           └── PersonalService.java
    │       │
    │       │   └── telefonopersonal/
    │       │       ├── dto/
    │       │       │   ├── TelefonoPersonalRequest.java
    │       │       │   ├── TelefonoPersonalResponse.java
    │       │       │   └── TelefonoPersonalUpdateRequest.java
    │       │       ├── port/
    │       │       │   ├── in/
    │       │       │   │   └── ManageTelefonoPersonalUseCase.java
    │       │       │   └── out/
    │       │       │       └── TelefonoPersonalRepositoryPort.java
    │       │       └── service/
    │       │           └── TelefonoPersonalService.java
    │       │
    │       │   └── numerocorporativo/
    │       │       ├── dto/
    │       │       │   ├── NumeroCorporativoRequest.java
    │       │       │   ├── NumeroCorporativoResponse.java
    │       │       │   └── NumeroCorporativoUpdateRequest.java
    │       │       ├── port/
    │       │       │   ├── in/
    │       │       │   │   └── ManageNumeroCorporativoUseCase.java
    │       │       │   └── out/
    │       │       │       └── NumeroCorporativoRepositoryPort.java
    │       │       └── service/
    │       │           └── NumeroCorporativoService.java
    │       │
    │       │   └── imagensucursal/
    │       │       ├── dto/
    │       │       │   ├── ImagenSucursalRequest.java
    │       │       │   ├── ImagenSucursalResponse.java
    │       │       │   └── ImagenSucursalUpdateRequest.java
    │       │       ├── port/
    │       │       │   ├── in/
    │       │       │   │   └── ManageImagenSucursalUseCase.java
    │       │       │   └── out/
    │       │       │       └── ImagenSucursalRepositoryPort.java
    │       │       └── service/
    │       │           └── ImagenSucursalService.java
    │       │
    │       └── infrastructure/
    │           ├── auth/
    │           │   ├── controller/
    │           │   │   └── AuthController.java          # Controlador de autenticación
    │           │   └── security/
    │           │       ├── JwtAuthenticationFilter.java # Filtro JWT
    │           │       ├── JwtUtil.java                 # Utilidad para manejar JWT
    │           │       └── CustomUserDetailsService.java # Servicio de carga de usuarios
    │           │
    │           ├── sucursal/
    │           │   ├── controller/
    │           │   │   └── SucursalController.java      # Controlador REST
    │           │   └── persistence/
    │           │       ├── SucursalEntity.java          # Entidad JPA
    │           │       ├── SucursalJpaRepository.java   # Repositorio Spring Data
    │           │       ├── SucursalMapper.java          # Mapper Domain <-> Entity
    │           │       └── SucursalPersistenceAdapter.java  # Implementación del puerto
    │           │
    │           ├── horariosucursal/
    │           │   ├── controllers/
    │           │   │   └── HorarioSucursalController.java
    │           │   └── persistence/
    │           │       ├── HorarioSucursalEntity.java
    │           │       ├── HorarioSucursalJpaRepository.java
    │           │       ├── HorarioSucursalMapper.java
    │           │       └── HorarioSucursalPersistenceAdapter.java
    │           │
    │           ├── contactosucursal/
    │           │   ├── controllers/
    │           │   │   └── ContactoSucursalController.java
    │           │   └── persistence/
    │           │       ├── ContactoSucursalEntity.java
    │           │       ├── ContactoSucursalJpaRepository.java
    │           │       ├── ContactoSucursalMapper.java
    │           │       └── ContactoSucursalPersistenceAdapter.java
    │           │
    │           ├── personal/
    │           │   ├── controller/
    │           │   │   └── PersonalController.java
    │           │   └── persistence/
    │           │       ├── PersonalEntity.java
    │           │       ├── PersonalJpaRepository.java
    │           │       ├── PersonalMapper.java
    │           │       └── PersonalPersistenceAdapter.java
    │           │
    │           ├── telefonopersonal/
    │           │   ├── controller/
    │           │   │   └── TelefonoPersonalController.java
    │           │   └── persistence/
    │           │       ├── TelefonoPersonalEntity.java
    │           │       ├── TelefonoPersonalJpaRepository.java
    │           │       ├── TelefonoPersonalMapper.java
    │           │       └── TelefonoPersonalPersistenceAdapter.java
    │           │
    │           ├── numerocorporativo/
    │           │   ├── controller/
    │           │   │   └── NumeroCorporativoController.java
    │           │   └── persistence/
    │           │       ├── NumeroCorporativoEntity.java
    │           │       ├── NumeroCorporativoJpaRepository.java
    │           │       ├── NumeroCorporativoMapper.java
    │           │       └── NumeroCorporativoPersistenceAdapter.java
    │           │
    │           ├── imagensucursal/
    │           │   ├── controller/
    │           │   │   └── ImagenSucursalController.java
    │           │   └── persistence/
    │           │       ├── ImagenSucursalEntity.java
    │           │       ├── ImagenSucursalJpaRepository.java
    │           │       ├── ImagenSucursalMapper.java
    │           │       └── ImagenSucursalPersistenceAdapter.java
    │           │
    │           └── config/
    │               ├── SucursalConfig.java              # Configuración de beans
    │               ├── HorarioSucursalConfig.java       # Configuración de beans
    │               ├── ContactoSucursalConfig.java      # Configuración de beans
    │               ├── PersonalConfig.java              # Configuración de beans
    │               ├── TelefonoPersonalConfig.java      # Configuración de beans
    │               ├── NumeroCorporativoConfig.java     # Configuración de beans
    │               ├── ImagenSucursalConfig.java        # Configuración de beans
    │               ├── SecurityConfig.java              # Configuración de seguridad (dev)
    │               └── GlobalExceptionHandler.java      # Manejo de excepciones global
    │
    └── resources/
        ├── application.properties                       # Configuración de la aplicación
        └── schema.sql                                   # Script SQL para crear tablas
    
src/main/uploads/                                         # Directorio para archivos de imágenes
    └── sucursales/                                       # Subdirectorio específico para imágenes de sucursales
```

---

## 📊 Resumen del Proyecto

| Característica | Valor |
|----------------|-------|
| **Módulos** | 8 (Auth, Sucursales, Horarios, Contactos, Personal, Teléfonos, Números Corp., Imágenes) |
| **Endpoints** | 45+ endpoints RESTful |
| **Arquitectura** | Hexagonal (Puertos y Adaptadores) |
| **Patrón de Diseño** | Domain-Driven Design (DDD) |
| **Base de Datos** | MySQL con relaciones y constraints |
| **Autenticación** | JWT (JSON Web Tokens) |
| **Framework** | Spring Boot 3.5.7 |
| **Java Version** | 17 |

---

## 🎯 Próximos Pasos

Después de ejecutar la aplicación:

1. ✅ Probar el endpoint de login: `POST /api/auth/login`
2. ✅ Usar el token JWT recibido en las demás peticiones
3. ✅ Crear sucursales y sus datos relacionados
4. ✅ Subir imágenes de sucursales
5. ✅ Consultar el archivo [ENDPOINTS.md](./ENDPOINTS.md) para ver todos los endpoints disponibles

---

## 📝 Notas Importantes

- **Contraseñas**: Las contraseñas del Personal están encriptadas con BCrypt
- **Tokens JWT**: Expiran después de 24 horas (configurable)
- **Archivos**: Las imágenes se almacenan en `src/main/uploads/sucursales/`
- **Base de Datos**: Se crea automáticamente si no existe (con `createDatabaseIfNotExist=true`)
- **Seguridad**: La configuración actual es para desarrollo, ajustar para producción

---

## 👨‍💻 Desarrollo

Este proyecto sigue las mejores prácticas de:
- Clean Architecture
- SOLID Principles
- Domain-Driven Design
- Hexagonal Architecture
- REST API Design

---

**Desarrollado con ❤️ usando Spring Boot y Arquitectura Hexagonal**
