package org.engyne;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;

import java.math.BigDecimal;

@Serdeable
@MappedEntity
public record Point(
        @Id
        Long id,
        Double x,
        Double y
) {

        // Getters() allowable-but not setters()
        public Long getId() { return id; }
        public Double getX() { return x; }
        public Double getY() { return y; }
}
