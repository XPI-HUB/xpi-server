package com.xpi.xpiserver.controller.dataValidation;

import com.xpi.xpiserver.service.dataValidation.AadhaarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AadhaarController {

    @Autowired
    AadhaarService aadhaarService;

    @GetMapping("validateAadhaar")
    public Boolean validateAadhaar(@RequestParam final String aadhaar) {
        return aadhaarService.validateAadhaar(aadhaar);
    }
}
