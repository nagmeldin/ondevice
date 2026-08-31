package org.engyne;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@Controller("/devices")
public class DeviceController {


    final DeviceRepository deviceRepository;

    public DeviceController(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

//EndPoints design:

    @Get("/")
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

    @Post("/")
    public HttpResponse<?> saveDevice(@Body @Valid Device device) {

        this.deviceRepository.save(device);
        return HttpResponse.status(HttpStatus.CREATED).body(device);
    }

    /*
    @Put("/{id}")
    Device update(Long id, @Body Device updatedBook) {
        Long index = devices.findIndexOf { it.id == id }
        if (index != -1) {
            devices[index].make = updatedDevice.make
            devices[index].author = updatedDevice.make
            return devices[index]
        }
        null

     @Put("/")
    public HttpResponse<?> updateDevice(@Body @Valid Device device) {
    } */

   /*
    @Delete("/{id}")
    void delete(Long id) {
        devices.removeIf { it.id == id }
    }
   } */


}