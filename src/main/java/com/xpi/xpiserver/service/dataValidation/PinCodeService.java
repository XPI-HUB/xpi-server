package com.xpi.xpiserver.service.dataValidation;

import com.fasterxml.jackson.databind.JsonNode;
import com.xpi.xpiserver.model.dataValidation.PinCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@Service
public class PinCodeService {

    private final RestClient restClient;

    public PinCodeService() {
        this.restClient = RestClient
            .builder()
            .baseUrl("https://api.postalpincode.in/")
            .build();
    }

    private static List<PinCode> convertJsonDataToList(final JsonNode jsonNode,
                                                       final List<PinCode> pinCodeList) {
        for (JsonNode node : jsonNode) {
            pinCodeList.add(new PinCode(
                node.findValue("Name") == null ? "" : node.get("Name").asText(),
                node.findValue("Description") == null ? "" : node.get("Description").asText(),
                node.findValue("BranchType") == null ? "" : node.get("BranchType").asText(),
                node.findValue("DeliveryStatus") == null ? "" : node.get("DeliveryStatus").asText(),
                node.findValue("Circle") == null ? "" : node.get("Circle").asText(),
                node.findValue("District") == null ? "" : node.get("District").asText(),
                node.findValue("Division") == null ? "" : node.get("Division").asText(),
                node.findValue("Region") == null ? "" : node.get("Region").asText(),
                node.findValue("Block") == null ? "" : node.get("Block").asText(),
                node.findValue("State") == null ? "" : node.get("State").asText(),
                node.findValue("Country") == null ? "" : node.get("Country").asText(),
                node.findValue("Pincode") == null ? "" : node.get("Pincode").asText()
            ));
        }
        return pinCodeList;
    }

    public ResponseEntity<List<PinCode>> getPinCodeByPin(final String pinCode) {
        List<PinCode> pinCodeList = new ArrayList<>();

        JsonNode jsonNode =
            Objects.requireNonNull(restClient
                    .get()
                    .uri("pincode/{PINCODE}", pinCode)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .body(JsonNode.class))
                .findValue("PostOffice");
        return new ResponseEntity<>(convertJsonDataToList(jsonNode, pinCodeList), HttpStatus.OK);
    }

    public ResponseEntity<List<PinCode>> getPostOfficeNameByPlaceName(final String placeName) {
        List<PinCode> pinCodeList = new ArrayList<>();

        JsonNode jsonNode =
            Objects.requireNonNull(restClient
                    .get()
                    .uri("postoffice/{POSTOFFICEBRANCHNAME}", placeName)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .body(JsonNode.class))
                .findValue("PostOffice");
        return new ResponseEntity<>(convertJsonDataToList(jsonNode, pinCodeList), HttpStatus.OK);
    }
}
