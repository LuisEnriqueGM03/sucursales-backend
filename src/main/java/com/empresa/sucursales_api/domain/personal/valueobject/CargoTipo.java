package com.empresa.sucursales_api.domain.personal.valueobject;

public enum CargoTipo {
    ADMIN("Admin"),
    GERENTE("Gerente"),
    ENCARGADO("Encargado"),
    PERSONAL("Personal");

    private final String displayName;

    CargoTipo(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static CargoTipo fromString(String value) {
        if (value == null) {
            return null;
        }
        
        for (CargoTipo tipo : CargoTipo.values()) {
            if (tipo.name().equalsIgnoreCase(value) || 
                tipo.displayName.equalsIgnoreCase(value)) {
                return tipo;
            }
        }
        
        throw new IllegalArgumentException("Cargo inválido: " + value + 
            ". Los valores permitidos son: ADMIN, GERENTE, ENCARGADO, PERSONAL");
    }
}
