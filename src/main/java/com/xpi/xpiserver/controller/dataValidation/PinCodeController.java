package com.xpi.xpiserver.controller.dataValidation;

import com.xpi.xpiserver.service.dataValidation.PinCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PinCodeController {

    @Autowired
    PinCodeService pinCodeService;

    @GetMapping("/pincode")
    public ResponseEntity<?> validatePinCode(@RequestParam final String pinCode) {
        return pinCodeService.validatePincode(pinCode);
    }
}
