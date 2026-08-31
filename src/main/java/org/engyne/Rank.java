package org.engyne;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.*;

@Serdeable
@MappedEntity
public record Rank(
        @Id
        @GeneratedValue
        Long id,
        @Positive
        @Min(1)
        @Max(5)
        Integer grade,

        @NotNull
        Status status,

        @Size(max = 255)
        String note
) {

    public enum Status {
        READY,
        RUNNING,
        STOPPED,
        PHASEOUT
    }

    public Rank(int grade, Status status, String note) {
        this( null, grade,  status, note);
    }
}
