package org.engyne;

import jakarta.validation.constraints.*;

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
