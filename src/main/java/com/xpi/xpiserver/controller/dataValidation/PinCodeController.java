package com.xpi.xpiserver.controller.dataValidation;

import com.xpi.xpiserver.service.dataValidation.PinCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PinCodeController {

    private final PinCodeService pinCodeService;

    private PinCodeController() {
        this.pinCodeService = new PinCodeService();
    }

    @GetMapping("/getPostOfficeNameByPinCode")
    public ResponseEntity<?> getPostOfficeNameByPinCode(@RequestParam final String pinCode) {
        return pinCodeService.getPinCodeByPin(pinCode);
    }

    @GetMapping("/getPostOfficeNameByPlaceName")
    public ResponseEntity<?> getPostOfficeNameByPlaceName(@RequestParam final String placeName) {
        return pinCodeService.getPostOfficeNameByPlaceName(placeName);
    }
}
