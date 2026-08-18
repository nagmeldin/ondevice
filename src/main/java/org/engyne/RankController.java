package org.engyne;


import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import java.util.ArrayList;
import java.util.List;

@Controller("/ranks")
public class RankController {

    final RankRepository rankRepository;

    public RankController(RankRepository rankRepository) {
        this.rankRepository = rankRepository;
    }

    //EndPoints design:
    @Get("/grades")
    List<String> listGrades(){                        // findGrades() method is to be created in rankRepository
        List<Integer> results = new ArrayList<>();
        List<String> resultStr = new ArrayList<>();

        results =  this.rankRepository.findGrade();   // SQL query

        for ( Integer number: results) {
            resultStr.add(String.valueOf( number));
        }
        return resultStr;
    }

    @Get("/statuses")
    List<String> listStatus(){                        // findStatus() method is to be created in rankRepository

        List<Rank.Status> results = new ArrayList<>();
        results = rankRepository.findStatus();       // SQL query

        List<String> resultStr = new ArrayList<>();

        for ( Rank.Status result: results )  {

            resultStr.add(result.name());
        }
        return resultStr;
    }
}

/* Endpoint testing:
   http://localhost:8080/ranks/grades
   http://localhost:8080/ranks/statuses
*/