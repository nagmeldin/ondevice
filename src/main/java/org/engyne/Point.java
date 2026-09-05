package org.engyne;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@MappedEntity
public record Point(
        @Id
        Long id,
        Double x,
        Double y
) {

        // Kinda of constructor setter():
        public Point withXY(Double x, Double y) {
                return new Point(id, x, y);
        }
        // Getters() allowable-but not setters()
        public Long getId() { return id; }
        public Double getX() { return x; }
        public Double getY() { return y; }
}
