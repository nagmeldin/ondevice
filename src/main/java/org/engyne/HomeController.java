package org.engyne;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;



@Controller("/")
public class HomeController {

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    public String index() {
        return "  OnDevice Inventory App Homepage \n\n\n\n\n\n\n\n\n\n -------------------------------- \n © 2020 COPYRIGHT ENGYNE ANALYTICS";
    }

}
