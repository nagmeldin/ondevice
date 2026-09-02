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


    @Post("/add")
    @Status(HttpStatus.OK)
    public HttpResponse<Device> addDevice(@Body Device device) {

        this.deviceRepository.save(device);
        return HttpResponse.status(HttpStatus.CREATED).body(device);
    }
    // curl -X POST http://localhost:8080/devices/add  -H "Content-Type: application/json" -d '{ "id": 7, "make":"arsta", "model":"7280R3", "os": "eos" , "year": 2023, "health": 2 }'


    @Put("/{id}")
    @Status(HttpStatus.OK)
    public HttpResponse<Device> updateDevice(Long id,@Body Device updatedDevice) {
       updatedDevice = this.deviceRepository.findById(id).orElse(null);;
       if (updatedDevice != null) {
           this.deviceRepository.update(updatedDevice);
       }

        return HttpResponse.status(HttpStatus.CREATED).body(updatedDevice);
    }
    // $ curl -X PUT "http://localhost:8080/devices/1"  -H "Content-Type: application/json" -d '{"make": "CISCO1"}'

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteDevice(Long id) {
        this.deviceRepository.deleteById(id);
    }
    // $ curl -i -X DELETE http://localhost:8080/devices/1

}