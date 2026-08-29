package org.engyne;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

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


}