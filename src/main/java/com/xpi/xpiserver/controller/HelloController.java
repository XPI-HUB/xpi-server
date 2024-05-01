package com.xpi.xpiserver.controller;

/*
 * User: Avinash Vijayvargiya
 * Date: 26/04/24
 * Time: 6:38 pm
 */

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/hello")
    public Map<String, String> hellos(final @RequestBody Map<String, String> input) {
        return input;
    }
}
