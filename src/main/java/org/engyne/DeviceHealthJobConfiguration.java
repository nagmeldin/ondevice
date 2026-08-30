package org.engyne;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("devices.job")  // in conjunction with DeviceJob singleton class
public record DeviceHealthJobConfiguration(
        boolean isPaused, // To be set in application.properties as on or off if not needed
        int unhealthy     // A threshold to be set in application.properties
) {

}