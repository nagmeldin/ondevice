package org.engyne;

import io.micronaut.data.annotation.MappedEntity;
import jakarta.validation.constraints.*;

@MappedEntity
public record Rank(
        @Positive
        @Min(1)
        @Max(5)
        @NotBlank
        int grade,
        @NotBlank
        Status status,
        @Size(max = 255)
        String note
) {

}
