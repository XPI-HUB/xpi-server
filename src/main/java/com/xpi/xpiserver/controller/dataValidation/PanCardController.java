package com.xpi.xpiserver.controller.dataValidation;

import com.xpi.xpiserver.service.dataValidation.PanCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PanCardController {

    @Autowired
    PanCardService panCardService;


}
