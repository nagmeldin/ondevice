package org.engyne;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;


// Data Transfer Object class (where only make and year fields are needed from db query)
@Serdeable.Serializable
public record DeviceDTO(
        String make,
        int year
) {

}
