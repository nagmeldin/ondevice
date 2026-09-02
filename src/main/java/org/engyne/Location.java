package org.engyne;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@MappedEntity
public record Location(

        @Id
        Long id,

        String city,
        String market,

        @Relation(Relation.Kind.ONE_TO_ONE)
        // @Relation(Relation.Kind.ONE_TO_MANY) List<Point> point
        Point point
) {
        // Getters() allowable-but not setters():
        public Long getId() { return id; }
        public String getCity() { return city; }
        public String getMarket() { return market; }
        public Point getPoint(){ return point; }
}