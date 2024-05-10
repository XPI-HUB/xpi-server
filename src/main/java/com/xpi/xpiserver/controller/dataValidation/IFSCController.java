package com.xpi.xpiserver.controller.dataValidation;

import com.xpi.xpiserver.service.dataValidation.IFSCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IFSCController {

    @Autowired
    IFSCService ifscService;

    @GetMapping("/validateIFSC")
    public Boolean validateIFSC(@RequestParam final String ifscCode) {
        return ifscService.validateIFSC(ifscCode);
    }

}
