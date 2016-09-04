package com.swiftpot.projectuknown.model;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         03-Sep-16 @ 9:08 PM
 */
public class SuccessfulOutgoingPayload extends OutgoingPayload{

    public SuccessfulOutgoingPayload(Object responseObject) {
        this.status = "00";
        this.message = "Success";
        this.responseObject = responseObject;
    }
}
