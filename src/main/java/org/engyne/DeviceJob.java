package org.engyne;

import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Singleton;

@Singleton
public class DeviceJob {

    private final DeviceHealthJobConfiguration configuration;

    // Constructor overloading
    public DeviceJob(DeviceHealthJobConfiguration configuration) {
        this.configuration = configuration;
    }

    public DeviceHealthJobConfiguration getConfiguration() {
        return configuration;
    }


    @Scheduled( fixedRate = "25s", condition = "#{!this.configuration.isPaused }")
    void reportUnhealthy() {

        System.out.println("Device is unhealthy");

    }
}
