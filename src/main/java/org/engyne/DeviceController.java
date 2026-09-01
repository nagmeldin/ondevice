package org.engyne;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.http.multipart.CompletedFileUpload;
import io.micronaut.http.uri.UriBuilder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.net.URI;
import java.util.List;

@Controller("/devices")
public class DeviceController {


    final DeviceRepository deviceRepository;

    public DeviceController(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

//EndPoints design:

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    public String index() {
        return "Device Inventory Homepage"; // 4
    }

    @Get("/makes")
    List<String> listMake() {
        return this.deviceRepository.findMake(); // findMake() method is to be created in deviceRepository
    }

    @Get("/models")
    List<String> listModel() {
        return this.deviceRepository.findModel(); // findModel() method is to be created in deviceRepository
    }

    @Get("/list")
    List<DeviceDTO> list() {
        return this.deviceRepository.list(); // returns only make and year
    }

    @Post
    public Device createDevice(@Body Device device) {
        this.deviceRepository.save(device);
        return device;
    }

    @Post
    public HttpResponse<Device> addDevice(@Body Device device) {
        this.deviceRepository.save(device);
        URI location = UriBuilder.of("/devices").path(device.getId().toString()).build();
        return HttpResponse.created(device, location);
    }
    // curl -X POST http://localhost:8080/devices  -H "Content-Type: application/json" -d '{ "id": 3, "make":"arsta", "model":"7280R3", "os": "eos" , "year": 2023, "healthCheck": 3 }'

    @Put("/{id}")
    public HttpResponse<Device> update(@PathVariable Long id, @Body Device updatedDevice) {

        Device device = deviceRepository.findById(id).orElse(null);

        if (device == null) {
            return HttpResponse.notFound();
        }

        device.setMake(updatedDevice.getMake());
        device.setModel(updatedDevice.getModel());
        deviceRepository.update(device);

        return HttpResponse.ok(device);
    }
    // $ curl -X PUT "http://localhost:8080/devices/1"  -H "Content-Type: application/json" -d '{"make": "CISCO"}'

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteDevice(Long id) {
        this.deviceRepository.deleteById(id);
    }
    // $ curl -i -X DELETE http://localhost:8080/devices/1

}