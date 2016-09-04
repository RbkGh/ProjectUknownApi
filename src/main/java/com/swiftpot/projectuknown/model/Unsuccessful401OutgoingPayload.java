package com.swiftpot.projectuknown.model;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         04-Sep-16 @ 5:28 PM
 */
public class Unsuccessful401OutgoingPayload extends OutgoingPayload{
    public Unsuccessful401OutgoingPayload(Object responseObject) {
        this.status = "11";
        this.message = "401 : Missing or invalid Authorization header.";
        this.responseObject = responseObject;
    }
}
