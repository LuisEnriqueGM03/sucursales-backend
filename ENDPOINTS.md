# API Endpoints - Sucursales API

## 📍 Sucursales

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/sucursales` | Crear nueva sucursal |
| `GET` | `/api/sucursales/{id}` | Obtener sucursal por ID |
| `GET` | `/api/sucursales` | Listar todas las sucursales |
| `GET` | `/api/sucursales?onlyActive=true` | Listar solo sucursales activas |
| `PUT` | `/api/sucursales/{id}` | Actualizar sucursal |
| `PATCH` | `/api/sucursales/{id}/deactivate` | Desactivar sucursal |
| `DELETE` | `/api/sucursales/{id}` | Eliminar sucursal |

## 🕒 Horarios de Sucursal

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/horarios-sucursales` | Crear horario de sucursal |
| `GET` | `/api/horarios-sucursales/{id}` | Obtener horario por ID |
| `GET` | `/api/horarios-sucursales` | Listar todos los horarios |
| `GET` | `/api/horarios-sucursales/sucursal/{sucursalId}` | Listar horarios de una sucursal |
| `PUT` | `/api/horarios-sucursales/{id}` | Actualizar horario |
| `DELETE` | `/api/horarios-sucursales/{id}` | Eliminar horario |

## 📞 Contactos de Sucursal

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/contactos-sucursal` | Crear contacto de sucursal |
| `GET` | `/api/contactos-sucursal/{id}` | Obtener contacto por ID |
| `GET` | `/api/contactos-sucursal` | Listar todos los contactos |
| `GET` | `/api/contactos-sucursal/sucursal/{sucursalId}` | Listar contactos de una sucursal |
| `PUT` | `/api/contactos-sucursal/{id}` | Actualizar contacto |
| `DELETE` | `/api/contactos-sucursal/{id}` | Eliminar contacto |

## 👥 Personal

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/personal` | Crear empleado |
| `GET` | `/api/personal/{id}` | Obtener empleado por ID |
| `GET` | `/api/personal` | Listar todos los empleados |
| `GET` | `/api/personal?onlyActive=true` | Listar solo empleados activos |
| `GET` | `/api/personal/sucursal/{sucursalId}` | Listar empleados de una sucursal |
| `PUT` | `/api/personal/{id}` | Actualizar empleado |
| `PATCH` | `/api/personal/{id}/deactivate` | Desactivar empleado |
| `DELETE` | `/api/personal/{id}` | Eliminar empleado |

## 📱 Teléfonos del Personal

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/telefonos-personal` | Crear teléfono de empleado |
| `GET` | `/api/telefonos-personal/{id}` | Obtener teléfono por ID |
| `GET` | `/api/telefonos-personal` | Listar todos los teléfonos |
| `GET` | `/api/telefonos-personal/personal/{personalId}` | Listar teléfonos de un empleado |
| `PUT` | `/api/telefonos-personal/{id}` | Actualizar teléfono |
| `DELETE` | `/api/telefonos-personal/{id}` | Eliminar teléfono |

## 🏢 Números Corporativos

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/numeros-corporativos` | Crear número corporativo |
| `GET` | `/api/numeros-corporativos/{id}` | Obtener número por ID |
| `GET` | `/api/numeros-corporativos/numero/{numero}` | Obtener número por valor |
| `GET` | `/api/numeros-corporativos` | Listar todos los números |
| `GET` | `/api/numeros-corporativos/sucursal/{sucursalId}` | Listar números de una sucursal |
| `GET` | `/api/numeros-corporativos/personal/{personalId}` | Listar números asignados a empleado |
| `PUT` | `/api/numeros-corporativos/{id}` | Actualizar número |
| `PATCH` | `/api/numeros-corporativos/{id}/assign/{personalId}` | Asignar número a empleado |
| `PATCH` | `/api/numeros-corporativos/{id}/unassign` | Desasignar número de empleado |
| `DELETE` | `/api/numeros-corporativos/{id}` | Eliminar número |

## 🖼️ Imágenes de Sucursal

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/imagenes-sucursal` | Subir imagen de sucursal (multipart/form-data) |
| `GET` | `/api/imagenes-sucursal/{id}` | Obtener imagen por ID |
| `GET` | `/api/imagenes-sucursal` | Listar todas las imágenes |
| `GET` | `/api/imagenes-sucursal/sucursal/{sucursalId}` | Listar imágenes de una sucursal |
| `PUT` | `/api/imagenes-sucursal/{id}` | Actualizar descripción de imagen |
| `DELETE` | `/api/imagenes-sucursal/{id}` | Eliminar imagen |

---

## 📊 Resumen Total

- **7 módulos** principales
- **42 endpoints** totales
- **Arquitectura**: Hexagonal (puertos y adaptadores)
- **Base de datos**: MySQL con relaciones y constraints
- **Autenticación**: No implementada (desarrollo)

## 🔧 Configuración

- **Puerto**: `8080`
- **Base de datos**: `sucursales_db`
- **Archivos**: Se almacenan en `src/main/uploads/sucursales/`