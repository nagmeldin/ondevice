package org.engyne;


import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.validation.constraints.*;


@MappedEntity
public record Device(
        @GeneratedValue
        @Id
        Long id,
        @NotNull
        String make,
        String model,
        String os,
        @Positive
        int year,
        @Min(1)
        @Max(10)
        int healthCheck

) {
}

