package org.engyne;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface PointRepository extends CrudRepository<@Valid Point, @Positive Long>  {

    List<Double> findX(); // User method to be used in Point Controller
    List<Double> findY(); // User method to be used in Point Controller

}
