package com.xpi.xpiserver.service.dataValidation;

import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

@Service
public class AadhaarService {
    public Boolean validateAadhaar(final String aadhaar) {
        return Pattern.matches("^[0-9]{4}[ -]?[0-9]{4}[ -]?[0-9]{4}$\n", aadhaar);
    }
}
