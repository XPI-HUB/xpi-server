package com.xpi.xpiserver.controller.standardData;

import com.xpi.xpiserver.service.standardData.TimeZoneService;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<HashMap<String, String>> getTimeZones() {
        return timeZoneService.getTimeZone();
    }

    @PostMapping("/getTimeZoneFromIds")
    public ResponseEntity<HashMap<String, String>> getTimeZoneFromIds(
            @RequestBody final List<String> timeZoneIds) {
        return timeZoneService.getTimeZoneById(timeZoneIds);
    }
}
