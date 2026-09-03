package org.engyne;


import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Retryable;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.List;

@MicronautTest
public class DeviceControllerTest {


    @Test
    void testCrudOperations(DeviceClient deviceClient) {

        // 1. READ (GET):
        List<String> makes = deviceClient.getMake();                                          // getMake() defined hereunder
        assertEquals( 2, makes.size());

        // 2. CREATE (POST):
        Device testDevice = new Device(10L, "Cisco", "X4000", "iOS", 2022, 5 );
        HttpResponse<Device> response =  deviceClient.addDevice(testDevice);                   // addDevice() defined hereunder
        assertEquals(201, response.getStatus().getCode());

        // 3. UPDATE (PUT):
        Device updatedDevice = new Device(1L, "CISCOx", "X4000", "iOS", 2022, 5 );
        HttpResponse<Device> updatedResponse = deviceClient.updateDevice(1L, updatedDevice); // updateDevice() defined hereunder
        assertEquals(200, updatedResponse.getStatus().getCode());

        // 4. DELETE :
        deviceClient.deleteDevice(1L);
        assertEquals(200, updatedResponse.getStatus().getCode());                        // deletedDevice() defined hereunder
    }

    /* ------------*** Interfaces *******--------------------- */

    @Retryable
    @Client("/devices")
    interface DeviceClient {

        @Get("/makes")
        List<String> getMake();

        @Get("/models")
        List<String> getModel();

        @Post("/add")
        public HttpResponse<Device> addDevice(@Body Device device);

        @Put("/{id}/update")
        public HttpResponse<Device> updateDevice(Long id, @Body Device updatedDevice);

        @Delete("/{id}")
        public void deleteDevice(Long id);

    }

}
