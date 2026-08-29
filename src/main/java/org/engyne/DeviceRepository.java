package org.engyne;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
//import jakarta.validation.Valid;
//import jakarta.validation.constraints.Positive;
import java.util.List;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface DeviceRepository extends CrudRepository< Device, Long> {

    List<String> findMake(); // User method to be used in Device Controller
    List<String> findModel(); // User method to be used in Device Controller

    List<Device> findByHealthCheckGreaterThan(int healthCheck);

    //List<DeviceDTO> list();  // For DTO class

}