package com.xpi.xpiserver.model.dataValidation;

/*
 * User: Avinash Vijayvargiya
 * Date: 10/05/24
 * Time: 7:44pm
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PinCode {
    @JsonProperty("Name")
    public String name;

    @JsonProperty("Description")
    public Object description;

    @JsonProperty("BranchType")
    public String branchType;

    @JsonProperty("DeliveryStatus")
    public String deliveryStatus;

    @JsonProperty("Circle")
    public String circle;

    @JsonProperty("District")
    public String district;

    @JsonProperty("Division")
    public String division;

    @JsonProperty("Region")
    public String region;

    @JsonProperty("Block")
    public String block;

    @JsonProperty("State")
    public String state;

    @JsonProperty("Country")
    public String country;

    @JsonProperty("Pincode")
    public String pincode;
}
