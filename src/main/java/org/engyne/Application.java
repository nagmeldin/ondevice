package org.engyne;

import org.slf4j.bridge.SLF4JBridgeHandler;
import io.micronaut.runtime.Micronaut;
import jakarta.inject.Singleton;

@Singleton
public class Application {

    /*
    private final DeviceRepository deviceRepository;
    private final RankRepository rankRepository;
    private final PointRepository pointRepository;
    private final LocationRepository locationRepository;

    public Application(DeviceRepository deviceRepository, RankRepository rankRepository,PointRepository pointRepository,LocationRepository locationRepository) {
        this.deviceRepository = deviceRepository;
        this.rankRepository = rankRepository;
        this.pointRepository = pointRepository;
        this.locationRepository = locationRepository;
    } */

    public static void main(String[] args) {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
        Micronaut.run(Application.class, args);
    }

    /*
    @EventListener
    @Transactional
    void startup(StartupEvent startupEvent) {
        deviceRepository.saveAll(List.of(
                new Device(null, "cisco", "8300", "iOS", 2018, 9),
                new Device(null, "cisco", "2800", "iOS", 2013, 5),

                new Device(null, "juniper", "MX5", "junos", 2016, 4),
                new Device(null, "juniper", "MX204", "junos", 2020, 8),

                new Device(null, "arista", "7280R4", "EOS", 2017, 9),
                new Device(null, "arista", "7280R3", "EOS", 2021, 6),

                new Device(null, "d-link", "R360", "Linux", 2016, 1),
                new Device(null, "d-link", "M370", "Linux", 2014, 6),

                new Device(null, "F5", "r2700", "F5OS", 2011, 7),
                new Device(null, "F5", "r5800", "F5OS", 2018, 3)
           )
        ); // End devices

        rankRepository.saveAll(List.of(
                        new Rank(null, 3, Rank.Status.READY, "To be deployed in lab-1 soon"),
                        new Rank(null, 2, Rank.Status.PHASEOUT, "Has been sold to client"),
                        new Rank(null, 4, Rank.Status.STOPPED, "Under going maintenance")
                )
        ); // End ranks


        pointRepository.saveAll(List.of(
                new Point(1L, 5123.23, -7342.52),
                new Point(2L, -7023.10, 8211.09),
                new Point(3L, -2371.42, -7002.12),
                new Point(4L, 4404.67, 9881.03),
                new Point(5L, 1711.02, -7002.79)
                )
        ); // End points

        locationRepository.saveAll(List.of(
                new Location( 1L, "Denver", "West",new Point(1L,5123.23,-7342.52 )),
                new Location( 2L, "Chicago", "Midwest",new Point(2L,-7023.10, 8211.09 )),
                new Location( 3L, "Oakland", "West",new Point( 3L,-2371.42, -6002.12 )),
                new Location( 4L, "Boston", "East",new Point(4L,4404.67, 9881.03 )),
                new Location( 5L, "Atlanta", "South",new Point(5L,1711.02, -7002.79 ))
                )
        ); // End locations

     */


}

