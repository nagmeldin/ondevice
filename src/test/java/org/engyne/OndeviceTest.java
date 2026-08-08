package org.engyne;


import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Retryable;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import java.util.List;

@MicronautTest
class OndeviceTest {

    @Inject
    EmbeddedApplication<?> application;

    // 1. Database testing:
    @Test
    void testItWorks( DeviceRepository deviceRepository) {
        Assertions.assertEquals( 10, deviceRepository.count());
    }

    // 2. EndPoints testing:
    @Test // use interface hereunder
    void testEndPoint(DeviceClient deviceClient) {
        List<String> makes = deviceClient.getMake();       // from hereunder
        Assertions.assertEquals( 10, makes.size());
    }
    /* -----***----- */
    @Retryable
    @Client("/devices")
    interface DeviceClient {

        @Get("/makes")
        List<String> getMake();

    }

}
