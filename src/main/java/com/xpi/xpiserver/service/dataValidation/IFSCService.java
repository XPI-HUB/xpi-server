package com.xpi.xpiserver.service.dataValidation;

import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

@Service
public class IFSCService {
    public Boolean validateIFSC(final String ifscCode) {
        return Pattern.matches("^[A-Z]{4}0[A-Z0-9]{6}$", ifscCode);
    }
}
