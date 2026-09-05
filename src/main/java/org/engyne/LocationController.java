package org.engyne;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller("/locales")
public class LocationController {


    final LocationRepository locationRepository;

    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    //EndPoints design:
    @Get("/")
    public String index() {
        return "Device Inventory Locations"; // 4
    }

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

    @Post("/add")                 //TBD
    @Status(HttpStatus.OK)
    public HttpResponse<Location> addLocation(@Body Location location) {

        this.locationRepository.save(location);
        return HttpResponse.status(HttpStatus.CREATED).body(location);
    }

    @Put("/{id}/update")            //TBD
    @Status(HttpStatus.OK)
    public HttpResponse<Location> updateLocation(Long id, @Body Location updatedLocation) {

        Location locationExiting = locationRepository.findById(id).orElseThrow(() -> new RuntimeException("Location is not found"));

        //1) Updating city and market fields of existing location with user's:
        updatedLocation = locationExiting.withCityMarket(updatedLocation.getCity(), updatedLocation.getMarket());

        this.locationRepository.update(updatedLocation);

        return HttpResponse.ok(updatedLocation);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteLocation(Long id) {
        this.locationRepository.deleteById(id);
    }

}