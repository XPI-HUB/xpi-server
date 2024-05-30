package com.xpi.xpiserver.service.dataValidation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.xpi.xpiserver.model.dataValidation.BankDetails;
import com.xpi.xpiserver.model.dataValidation.IfscCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@Service
public class IFSCService {

    private final RestClient restClient;

    private final ObjectReader reader =
        new ObjectMapper().readerFor(new TypeReference<List<String>>() {
        });

    private IFSCService() {
        restClient = RestClient
            .builder()
            .baseUrl("https://ifsc.razorpay.com/")
            .build();
    }

    public Boolean validateIFSC(final String ifscCode) {
        return Pattern.matches("^[A-Z]{4}0[A-Z0-9]{6}$", ifscCode);
    }

    public IfscCode getBankDetailsByIFSC(final String ifscCode) {
        IfscCode ifsc = new IfscCode();
        JsonNode jsonNode = restClient
            .get()
            .uri("{ifscCode}", ifscCode)
            .retrieve()
            .body(JsonNode.class);

        ifsc.setBranch(jsonNode
            .findValue("BRANCH") == null ? "" : jsonNode.get("BRANCH").asText());
        ifsc.setCentre(jsonNode
            .findValue("CENTRE") == null ? "" : jsonNode.get("CENTRE").asText());
        ifsc.setDistrict(jsonNode
            .findValue("DISTRICT") == null ? "" : jsonNode.get("DISTRICT").asText());
        ifsc.setState(jsonNode
            .findValue("STATE") == null ? "" : jsonNode.get("STATE").asText());
        ifsc.setAddress(jsonNode
            .findValue("ADDRESS") == null ? "" : jsonNode.get("ADDRESS").asText());
        ifsc.setContact(jsonNode
            .findValue("CONTACT") == null ? "" : jsonNode.get("CONTACT").asText());
        ifsc.setImps(Boolean.parseBoolean(jsonNode
            .findValue("IMPS") == null ? "" : jsonNode.get("IMPS").asText()));
        ifsc.setCity(jsonNode
            .findValue("CITY") == null ? "" : jsonNode.get("CITY").asText());
        ifsc.setUpi(Boolean.parseBoolean(jsonNode
            .findValue("UPI") == null ? "" : jsonNode.get("UPI").asText()));
        ifsc.setMicr(jsonNode
            .findValue("MICR") == null ? "" : jsonNode.get("MICR").asText());
        ifsc.setRtgs(Boolean.parseBoolean(jsonNode
            .findValue("RTGS") == null ? "" : jsonNode.get("RTGS").asText()));
        ifsc.setNeft(Boolean.parseBoolean(jsonNode
            .findValue("NEFT") == null ? "" : jsonNode.get("NEFT").asText()));
        ifsc.setSwift(jsonNode
            .findValue("SWIFT") == null ? "" : jsonNode.get("SWIFT").asText());
        ifsc.setIso3166(jsonNode
            .findValue("ISO3166") == null ? "" : jsonNode.get("ISO3166").asText());
        ifsc.setBank(jsonNode
            .findValue("BANK") == null ? "" : jsonNode.get("BANK").asText());
        ifsc.setBankCode(jsonNode
            .findValue("BANKCODE") == null ? "" : jsonNode.get("BANKCODE").asText());
        ifsc.setIfsc(jsonNode
            .findValue("IFSC") == null ? "" : jsonNode.get("IFSC").asText());
        return ifsc;
    }

    public BankDetails getBranchDetailsByBankCodeDistrictState(final String bankCode,
                                                               final String district,
                                                               final String state)
        throws JsonProcessingException {
        if (bankCode != null && state == null && district == null) {
            return getStatesDetails(bankCode);
        } else if (bankCode != null && state != null && district == null) {
            return getDistrictDetails(bankCode, state);
        } else if (bankCode != null && district != null && state != null) {
            return getBankDetails(bankCode, state, district);
        } else {
            return new BankDetails();
        }
    }

    private BankDetails getBankDetails(final String bankCode, final String state,
                                       final String district)
        throws JsonProcessingException {
        JsonNode jsonNode = restClient
            .get()
            .uri("places?state=" + state + "&bankcode=" + bankCode + "&district=" + district)
            .retrieve()
            .body(JsonNode.class);

        ArrayList<String> bankDetailsList =
            reader.readValue(String.valueOf(jsonNode.findValue("branches")));
        Collections.sort(bankDetailsList);
        return new BankDetails(new ArrayList<>(), bankDetailsList, new ArrayList<>());
    }

    private BankDetails getDistrictDetails(final String bankCode, final String state)
        throws JsonProcessingException {
        JsonNode jsonNode = restClient
            .get()
            .uri("/places?state=" + state + "&bankcode=" + bankCode)
            .retrieve()
            .body(JsonNode.class);

        ArrayList<String> bankDetailsList =
            reader.readValue(String.valueOf(jsonNode.findValue("districts")));
        Collections.sort(bankDetailsList);
        return new BankDetails(new ArrayList<>(), new ArrayList<>(), bankDetailsList);
    }

    private BankDetails getStatesDetails(final String bankCode) throws JsonProcessingException {
        JsonNode jsonNode = restClient
            .get()
            .uri("places?bankcode=" + bankCode)
            .retrieve()
            .body(JsonNode.class);
        ArrayList<String> bankDetailsList =
            reader.readValue(String.valueOf(jsonNode.findValue("states")));
        Collections.sort(bankDetailsList);
        return new BankDetails(bankDetailsList, new ArrayList<>(), new ArrayList<>());
    }
}
