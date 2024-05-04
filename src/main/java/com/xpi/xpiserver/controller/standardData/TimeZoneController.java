package com.xpi.xpiserver.controller.standardData;

import com.xpi.xpiserver.service.standardData.TimeZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/*
 * User: Avinash Vijayvargiya
 * Date: 03/05/24
 * Time: 9:36am
 */
@RestController
@RequestMapping("/api")
public class TimeZoneController {

    @Autowired
    private TimeZoneService timeZoneService;

    @GetMapping("/getTimeZone")
    public HashMap<String, String> getTimeZones() {
        return timeZoneService.getTimeZone();
    }

    @PostMapping("/getTimeZoneFromIds")
    public HashMap<String, String> getTimeZoneFromIds(@RequestBody List<String> timeZoneIds) {
        return timeZoneService.getTimeZoneById(timeZoneIds);
    }
}
