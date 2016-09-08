package com.swiftpot.projectuknown.model;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         08-Sep-16 @ 11:19 AM
 */
public class SMSSenderRequest {
    private String recipientPhoneNum;

    private String message;

    public SMSSenderRequest(){}

    public SMSSenderRequest(String recipientPhoneNum, String message) {
        this.recipientPhoneNum = recipientPhoneNum;
        this.message = message;
    }

    public String getRecipientPhoneNum() {
        return recipientPhoneNum;
    }

    public void setRecipientPhoneNum(String recipientPhoneNum) {
        this.recipientPhoneNum = recipientPhoneNum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
