package org.engyne;

import io.micronaut.data.annotation.Id;
import jakarta.validation.constraints.NotNull;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@MappedEntity("home")
public record Home(
        @Id
        Long id,

        @NotNull
        String info,

        String about
) {

    public Long getId() { return id; }
    public String getInfo() { return info; }
    public String getAbout() { return about; }
}
