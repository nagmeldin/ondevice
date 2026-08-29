package org.engyne;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;

import java.math.BigDecimal;

//@Serdeable.Deserializable
@MappedEntity
public record Point(
        @Id
        Long id,
        Double x,
        Double y
) {
}
