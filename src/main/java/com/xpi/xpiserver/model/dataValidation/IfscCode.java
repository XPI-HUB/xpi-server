package com.xpi.xpiserver.model.dataValidation;

/*
 * User: Avinash Vijayvargiya
 * Date: 30/05/24
 * Time: 2:04 pm
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IfscCode {

    @JsonProperty("BRANCH")
    private String branch;

    @JsonProperty("CENTRE")
    private String centre;

    @JsonProperty("DISTRICT")
    private String district;

    @JsonProperty("STATE")
    private String state;

    @JsonProperty("ADDRESS")
    private String address;

    @JsonProperty("CONTACT")
    private String contact;

    @JsonProperty("IMPS")
    private boolean imps;

    @JsonProperty("CITY")
    private String city;

    @JsonProperty("UPI")
    private boolean upi;

    @JsonProperty("MICR")
    private String micr;

    @JsonProperty("RTGS")
    private boolean rtgs;

    @JsonProperty("NEFT")
    private boolean neft;

    @JsonProperty("SWIFT")
    private String swift;

    @JsonProperty("ISO3166")
    private String iso3166;

    @JsonProperty("BANK")
    private String bank;

    @JsonProperty("bankCode")
    private String bankCode;

    @JsonProperty("IFSC")
    private String ifsc;
}
