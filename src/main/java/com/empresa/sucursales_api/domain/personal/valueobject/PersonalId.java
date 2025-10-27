package com.empresa.sucursales_api.domain.personal.valueobject;

import lombok.Value;

/**
 * Value Object para el identificador del personal
 */
@Value(staticConstructor = "of")
public class PersonalId {
    Long value;
}
