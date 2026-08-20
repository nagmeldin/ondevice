package org.engyne;


import io.micronaut.http.annotation.Controller;

@Controller("/locales")
public class LocationController {

    final LocationRepository locationRepository;


    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


}
