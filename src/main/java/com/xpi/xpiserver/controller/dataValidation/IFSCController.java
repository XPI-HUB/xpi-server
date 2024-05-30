package com.xpi.xpiserver.controller.dataValidation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xpi.xpiserver.model.dataValidation.BankDetails;
import com.xpi.xpiserver.model.dataValidation.IfscCode;
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

    @GetMapping("/getBankDetailsByIFSC")
    public IfscCode getBankDetailsByIFSC(@RequestParam final String ifscCode) {
        return ifscService.getBankDetailsByIFSC(ifscCode.toUpperCase());
    }

    @GetMapping("/getBankDetails")
    public BankDetails getBranchDetailsByBankCodeDistrictState(
        @RequestParam(required = false) final String bankCode,
        @RequestParam(required = false) final String district,
        @RequestParam(required = false) final String state)
        throws JsonProcessingException {
        return ifscService.getBranchDetailsByBankCodeDistrictState(
            bankCode != null ? bankCode.toUpperCase() : null,
            district != null ? district.toUpperCase() : null,
            state != null ? state.toUpperCase() : null);
    }
}
