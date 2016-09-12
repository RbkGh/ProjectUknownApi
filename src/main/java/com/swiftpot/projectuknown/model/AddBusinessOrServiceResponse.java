package com.swiftpot.projectuknown.model;

import com.swiftpot.projectuknown.db.model.BusinessOrServiceDocEntity;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         12-Sep-16 @ 9:27 AM
 */
public class AddBusinessOrServiceResponse extends BusinessOrServiceDocEntity {

    private String bizDistanceFromLocation;

    public AddBusinessOrServiceResponse() {
    }

    public AddBusinessOrServiceResponse(String bizDistanceFromLocation) {
        this.bizDistanceFromLocation = bizDistanceFromLocation;
    }

    public String getBizDistanceFromLocation() {
        return bizDistanceFromLocation;
    }

    public void setBizDistanceFromLocation(String bizDistanceFromLocation) {
        this.bizDistanceFromLocation = bizDistanceFromLocation;
    }
}
