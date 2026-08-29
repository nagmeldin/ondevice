package org.engyne;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
// import jakarta.validation.Valid;
// import jakarta.validation.constraints.Positive;

import java.util.List;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface RankRepository extends CrudRepository< Rank, Long> {

    List<Integer> findGrade();      // User method to be used in Rank Controller
    List<Rank.Status> findStatus(); // User method to be used in Rank Controller
}