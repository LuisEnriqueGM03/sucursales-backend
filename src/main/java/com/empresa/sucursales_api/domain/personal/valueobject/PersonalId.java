package com.empresa.sucursales_api.domain.personal.valueobject;
import lombok.Value;
@Value(staticConstructor = "of")
public class PersonalId {
    Long value;
}
