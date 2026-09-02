package org.engyne;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import java.util.List;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface DeviceRepository extends CrudRepository< Device, Long> {

    // Inherits standard CRUD operations:
        // 1) Device save(Device newDevice);
        // 2) Device update(Device updatedDevice);

     List<String> findMake(); // User method to be used in Device Controller
     List<String> findModel(); // User method to be used in Device Controller
     List<Device> findByHealthGreaterThan(int health);

     List<DeviceDTO> list();  // For DTO class

 }