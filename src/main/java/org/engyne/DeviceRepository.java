package org.engyne;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

import java.util.List;

@JdbcRepository(dialect = Dialect.H2)
public interface DeviceRepository extends CrudRepository<@Valid Device, @Positive Long> {

    List<String> findMake(); // User method to be used in Device Controller

    List<Device> findByHealthCheckGreaterThan(int healthCheck);
   //  List<DeviceDTO> list();  // For DTO reason

}
