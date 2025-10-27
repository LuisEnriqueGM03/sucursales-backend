
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
