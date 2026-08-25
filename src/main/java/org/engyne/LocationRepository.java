package org.engyne;

 import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

import java.util.List;

@JdbcRepository(dialect = Dialect.H2)
public interface LocationRepository extends CrudRepository<@Valid Location, @Positive Long> {

    List<String> findCity(); // User method to be used in Location Controller
    List<String> findMarket(); // User method to be used in Location Controller
    List<Point> findPoint(); // User method to be used in Location Controller
}
