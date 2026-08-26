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

    @Get("/points")
    List<String> listPoints(){

        List<String> resultStr = new ArrayList<>();
        List<Point> points = new ArrayList<>();

        points = this.locationRepository.findPoint(); // findMarket() method is to be created in locationRepository

        for (Point point : points) {
            double x = point.x();
            double y = point.y();
            resultStr.add( "(" + String.valueOf(x) + "," + String.valueOf(y) + ")" );
        }
        return resultStr;
    }

}
