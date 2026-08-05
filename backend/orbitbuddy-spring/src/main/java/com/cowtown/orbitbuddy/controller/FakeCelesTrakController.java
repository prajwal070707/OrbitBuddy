package com.cowtown.orbitbuddy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FakeCelesTrakController {

    @GetMapping("/NORAD/elements/gp.php")
    public String getFakeTle(
            @RequestParam("GROUP") String group,
            @RequestParam("FORMAT") String format) {

        if ("stations".equalsIgnoreCase(group) && "tle".equalsIgnoreCase(format)) {

            String issTle = """
                ISS (ZARYA)
                1 25544U 98067A   24215.50000000  .00015000  00000+0  10200-3 0  9993
                2 25544  51.6430  80.0000 0003000  90.0000 270.0000 15.50000000  1234
                """;

            String tiangongTle = """
                TIANGONG
                1 48274U 21035A   24215.50000000  .00015000  00000+0  10200-3 0  9993
                2 48274  41.4700  80.0000 0003000  90.0000 270.0000 15.50000000  1234
                """;

            return issTle + "\n" + tiangongTle;
        }

        return "Invalid GROUP or FORMAT";
    }
}
