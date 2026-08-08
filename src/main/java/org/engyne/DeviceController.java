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
@Get("/makes")
List<String> listMake(){
    return this.deviceRepository.findMake(); // findMake() method is to be created in deviceRepository
   }

}
/* Browser-endpoint:
   http://localhost:8080/devices/makes
*/