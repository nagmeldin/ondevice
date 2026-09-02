package org.engyne;


import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import io.micronaut.data.model.naming.NamingStrategies; //Tackles camelback parsing




//@MappedEntity(namingStrategy = NamingStrategies.Raw.class)
@Serdeable
@MappedEntity("device")
public record Device(
        //@GeneratedValue
        @Id
        Long id,

        @NotNull
        String make,

        @NotNull
        String model,

        String os,

        @Positive
        int year,

        @Min(1)
        @Max(10)
        int health
) {
        // Kinda constructor setters():
        public Device withMake(String make) {
                return new Device(id, make, model, os, year, health);
        }
        public Device withModel(String model) {
                return new Device(id, make, model, os, year, health);
        }
        // Getters() allowable-but not setters()
        public Long getId() { return id; }
        public String getMake() { return make; }
        public String getModel() { return model; }
        public String getOs() { return os; }
        public int getYear() { return year; }
        public int getHealth() { return health; }

}
