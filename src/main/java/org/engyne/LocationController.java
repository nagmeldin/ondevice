package org.engyne;


import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.ArrayList;
import java.util.List;

@Controller("/locales")
public class LocationController {

    final LocationRepository locationRepository;

    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    //EndPoints design:

    @Get("/cities")
    List<String> listCities(){
        return this.locationRepository.findCity(); // findCity() method is to be created in locationRepository
    }

    @Get("/markets")
    List<String> listMarkets(){
        return this.locationRepository.findMarket(); // findMarket() method is to be created in locationRepository
    }

}
