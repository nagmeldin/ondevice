package org.engyne;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller("/points")
public class PointController {

    final PointRepository pointRepository;

    public PointController(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    //EndPoints design:

    @Get("/")
    public String index() {
        return "Device Inventory focal points"; // 4
    }

    @Get("/xs")
    List<String> listX(){
        List<String> resultStr = new ArrayList<>();
        List<Double> results = this.pointRepository.findX(); // findX() method is to be created in pointRepository
        for ( Double number: results) {
            resultStr.add(String.valueOf(number));
        }
        return resultStr;
    }

    // curl http://localhost:8080/points/xs

    @Get("/ys")
    List<String> listY(){
        List<String> resultStr = new ArrayList<>();
        List<Double> results = this.pointRepository.findY(); // findY() method is to be created in pointRepository
        for ( Double number: results) {
            resultStr.add(String.valueOf(number));
        }
        return resultStr;
    }

    // curl http://localhost:8080/points/ys

    @Get("/distances")
    List<String> getDistances(){

        List<String> distancesStr = new ArrayList<>();
        List<Double> results = new ArrayList<>();
        List<Double> xList = this.pointRepository.findX(); // findX() method is to be created in pointRepository
        List<Double> yList = this.pointRepository.findY(); // findY() method is to be created in pointRepository

        for (int i = 0; i < xList.size(); i++) {
            double dx = xList.get(i);
            double dy = yList.get(i);
            double result = Math.sqrt(dx * dx + dy * dy);
            results.add(result);
        }

        for ( Double number: results) {
            distancesStr.add(String.valueOf(number));
        }
        return distancesStr;
    }

    @Get("/closest")
    String getClosestDistance(){

        List<Double> results = new ArrayList<>();
        List<Double> xList = this.pointRepository.findX(); // findX() method is to be created in pointRepository
        List<Double> yList = this.pointRepository.findY(); // findY() method is to be created in pointRepository

        for (int i = 0; i < xList.size(); i++) {
            double dx = xList.get(i);
            double dy = yList.get(i);
            double result = Math.sqrt(dx * dx + dy * dy);
            results.add(result);
        }
        double closest = Collections.min(results);

        return String.valueOf(closest);
    }

    @Post("/add")
    @Status(HttpStatus.OK)
    public HttpResponse<Point> addPoint(@Body Point point) {

        this.pointRepository.save(point);
        return HttpResponse.status(HttpStatus.CREATED).body(point);
    }
    // $ curl -X POST http://localhost:8080/points/add  -H "Content-Type: application/json" -d '{ "id": 3, "x":-2371.42, "y":-6002.12 }'

    @Put("/{id}/update")
    @Status(HttpStatus.OK)
    public HttpResponse<Point> updatePoint(Long id, @Body Point updatedPoint) {

        Point pointExiting = pointRepository.findById(id).orElseThrow(() -> new RuntimeException("Point is not found"));

        //1) Updating x-y coordinates of existing point with user's:
        updatedPoint = pointExiting.withXY(updatedPoint.getX(), updatedPoint.getY());

        // Updating repo:
        this.pointRepository.update(updatedPoint);

        return HttpResponse.ok(updatedPoint);
    }

    // $ curl -X PUT http://localhost:8080/points/1/update  -H "Content-Type: application/json" -d '{ "id": 1, "x":-2371.99, "y":-6002.99 }'

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deletePoint(Long id) {
        this.pointRepository.deleteById(id);
    }

    //  $ curl -i -X DELETE http://localhost:8080/points/2
}