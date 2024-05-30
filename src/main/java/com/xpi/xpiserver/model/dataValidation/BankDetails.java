package com.xpi.xpiserver.model.dataValidation;

/*
 * User: Avinash Vijayvargiya
 * Date: 30/05/24
 * Time: 2:48 pm
 */

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankDetails {
    private List<String> states;

    private List<String> districts;

    private List<String> branches;
}
