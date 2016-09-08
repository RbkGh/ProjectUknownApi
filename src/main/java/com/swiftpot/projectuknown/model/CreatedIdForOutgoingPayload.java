package com.swiftpot.projectuknown.model;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         08-Sep-16 @ 2:50 AM
 */
@XmlRootElement
public class CreatedIdForOutgoingPayload {

    private String id;

    public CreatedIdForOutgoingPayload(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}