package com.xpi.xpiserver.controller;

/*
 * User: Avinash Vijayvargiya
 * Date: 26/04/24
 * Time: 6:38 pm
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
