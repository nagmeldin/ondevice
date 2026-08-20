package org.engyne;


import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

@MappedEntity
public record Point(
        @Id
        Long id,
        Double x,
        Double y
) {}

/* Endpoint testing:
    http://localhost:8080/points/xs
    http://localhost:8080/points/ys
   $ curl http://localhost:8080/points/xs
    $ curl http://localhost:8080/points/ys
*/