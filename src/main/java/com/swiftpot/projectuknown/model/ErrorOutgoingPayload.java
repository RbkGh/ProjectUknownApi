package com.swiftpot.projectuknown.model;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         08-Sep-16 @ 1:50 AM
 */
public class ErrorOutgoingPayload extends OutgoingPayload{
    public ErrorOutgoingPayload(Object responseObject) {
        this.status = "11";
        this.message = "Error";
        this.responseObject = responseObject;
    }

    public ErrorOutgoingPayload(Object responseObject,String message) {
        this.status = "11";
        this.message = message;
        this.responseObject = responseObject;
    }
}
