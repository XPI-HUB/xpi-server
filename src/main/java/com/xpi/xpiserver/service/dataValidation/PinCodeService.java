package com.xpi.xpiserver.service.dataValidation;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class PinCodeService {

    private final RestClient restClient;

    public PinCodeService() {
        this.restClient = RestClient
                .builder()
                .baseUrl("http://localhost:8080")
                .build();
    }

    public ResponseEntity<?> validatePincode(final String pinCode) {
        return restClient.get()
                .uri("/pincode/" + pinCode)
                .retrieve()
                .body(ResponseEntity.class);
    }
}
