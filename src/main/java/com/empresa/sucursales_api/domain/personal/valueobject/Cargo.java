package com.empresa.sucursales_api.domain.personal.valueobject;
import lombok.Value;

@Value
public class Cargo {
    CargoTipo value;
    
    public static Cargo of(CargoTipo cargoTipo) {
        return new Cargo(cargoTipo);
    }
    
    public static Cargo of(String cargo) {
        if (cargo == null || cargo.trim().isEmpty()) {
            return new Cargo(null);
        }
        return new Cargo(CargoTipo.fromString(cargo.trim()));
    }
}
