package com.swiftpot.projectuknown.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         07-Sep-16 @ 7:56 AM
 */
@XmlRootElement
public class BusinessFineLocation {

    public double[] coordinates ;

    public String type;

    public BusinessFineLocation() {
    }

    public BusinessFineLocation(double[] coordinates, String type) {
        this.coordinates = coordinates;
        this.type = type;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
