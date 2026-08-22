package org.engyne;


import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.ArrayList;
import java.util.List;

@Controller("/points")
public class PointController {
    final PointRepository pointRepository;

    public PointController(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    //EndPoints design:

    @Get("/xs")
    List<String> listX(){
        List<String> resultStr = new ArrayList<>();
        List<Double> results = this.pointRepository.findX(); // findX() method is to be created in pointRepository
        for ( Double number: results) {
            resultStr.add(String.valueOf(number));
        }
        return resultStr;
    }
    @Get("/ys")
    List<String> listY(){
        List<String> resultStr = new ArrayList<>();
        List<Double> results = this.pointRepository.findY(); // findY() method is to be created in pointRepository
        for ( Double number: results) {
            resultStr.add(String.valueOf(number));
        }
        return resultStr;
    }

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




}

