package com.xpi.xpiserver.model.standardData;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * User: Avinash Vijayvargiya
 * Date: 04/05/24
 * Time: 3:25am
 */
@AllArgsConstructor
@Data
public class Countries {

    private String name;
    private String dialCode;
    private String isoCode;
    private String flag;
}
