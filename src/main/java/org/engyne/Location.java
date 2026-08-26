package org.engyne;


import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.serde.annotation.Serdeable;

//@Serdeable.Deserializable
@MappedEntity
public record Location(

        @Id
        Long id,

        String city,
        String market,

        @Relation(Relation.Kind.ONE_TO_ONE)
        // @Relation(Relation.Kind.ONE_TO_MANY) List<Point> point
        Point point
) { }


