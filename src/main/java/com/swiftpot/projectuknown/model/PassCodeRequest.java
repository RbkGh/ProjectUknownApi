package com.swiftpot.projectuknown.model;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         08-Sep-16 @ 2:47 PM
 */
public class PassCodeRequest {
    private String passCode;

    public PassCodeRequest(){}

    public PassCodeRequest(String passCode) {
        this.passCode = passCode;
    }

    public String getPassCode() {
        return passCode;
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }
}
