package org.engyne;

import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class Application {

    private final DeviceRepository deviceRepository;

    public Application(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

    @EventListener
    @Transactional
    void startup(StartupEvent startupEvent) {
        deviceRepository.saveAll(List.of(
                new Device(null, "cisco", "8300", "iOS", 2018, 9),
                new Device(null, "cisco", "2800", "iOS", 2013, 5),

                new Device(null, "juniper", "MX5", "junos", 2016, 4),
                new Device(null, "juniper", "MX204", "junos", 2020, 8),

                new Device(null, "arista", "7280R4", "EOS", 2017, 9),
                new Device(null, "arista", "7280R3", "EOS", 2021, 6),

                new Device(null, "d-link", "R36", "linux", 2016, 1),
                new Device(null, "d-link", "M36", "linux", 2014, 6),

                new Device(null, "F5", "r2600", "F5OS", 2011, 7),
                new Device(null, "F5", "r5800", "F5OS", 2018, 2)
           )
        );
    }

}

/* Endpoint testing:
   http://localhost:8080/devices/makes
   $ curl http://localhost:8080/devices/makes
*/