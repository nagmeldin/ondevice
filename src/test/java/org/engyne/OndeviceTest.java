package org.engyne;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Retryable;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import jakarta.inject.Inject;
import java.util.List;

@MicronautTest
class OndeviceTest {

    @Inject
    EmbeddedApplication<?> application;

    // A. Database testing(Server-side):
    @Test
    void testDeviceData( DeviceRepository deviceRepository) {
        Assertions.assertEquals( 2, deviceRepository.count());
    }

    @Test
    void testRankData( RankRepository rankRepository) {
        Assertions.assertEquals( 2, rankRepository.count());
    }

    @Test
    void testPointeData( PointRepository pointRepository) {
        Assertions.assertEquals( 2, pointRepository.count());
    }
    @Test
    void testLocationData( LocationRepository locationRepository) {
        Assertions.assertEquals( 2, locationRepository.count());
    }


    // B. EndPoints testing(client-side):

    @Test // use interface hereunder
    void testDeviceMakeEndPoint(DeviceClient deviceClient) {
        List<String> makes = deviceClient.getMake();
        Assertions.assertEquals( 2, makes.size());
    }

    @Test // use interface hereunder
    void testDeviceModelEndPoint(DeviceClient deviceClient) {
        List<String> models = deviceClient.getModel();
        Assertions.assertEquals( 2, models.size());
    }

    @Test // use interface hereunder
    void testRankGradeEndPoint(RankClient rankClient) {
        List<String> grades = rankClient.getGrade();
        Assertions.assertEquals( 2, grades.size());
    }


    @Test // use interface hereunder
    void testPointXEndPoint(PointClient pointClient) {
        List<String> xs = pointClient.getX();
        Assertions.assertEquals( 2, xs.size());
    }

    @Test // use interface hereunder
    void testPointYEndPoint(PointClient pointClient) {
        List<String> ys = pointClient.getY();
        Assertions.assertEquals( 2, ys.size());
    }


    @Test // use interface hereunder
    void testLocationCityEndPoint(LocationClient locationClient) {
        List<String> cities = locationClient.getCity();
        Assertions.assertEquals( 2, cities.size());
    }

    @Test // use interface hereunder
    void testLocationMarketEndPoint(LocationClient locationClient) {
        List<String> markets = locationClient.getMarket();
        Assertions.assertEquals( 2, markets.size());
    }

    /*
    @Test // use interface hereunder
    void testLocationPointEndPoint(LocationClient locationClient) {
        List<Point> points = locationClient.getPoint();
        Assertions.assertEquals( 5,points.size()  );
    }*/

    /* ------------*** Interfaces *******--------------------- */


    @Retryable
    @Client("/devices")
    interface DeviceClient {

        @Get("/makes")
        List<String> getMake();

        @Get("/models")
        List<String> getModel();
    }

    @Retryable
    @Client("/ranks")
    interface RankClient {

        @Get("/grades")
        List<String> getGrade();

    }

    @Retryable
    @Client("/points")
    interface PointClient {

        @Get("/xs")
        List<String> getX();

        @Get("/ys")
        List<String> getY();
    }

    @Retryable
    @Client("/locales")
    interface LocationClient {

        @Get("/cities")
        List<String> getCity();

        @Get("/markets")
        List<String> getMarket();

        @Get("/points")
        List<Point> getPoint();
    }

}
