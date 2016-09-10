package com.swiftpot.projectuknown.model;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         08-Sep-16 @ 11:47 PM
 */
public class GeneralUserSearchRequest {

    private double[] userLocation;

    private String searchQuery;

    private double maxDistance;

    public GeneralUserSearchRequest() {
    }

    public double[] getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(double[] userLocation) {
        this.userLocation = userLocation;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(double maxDistance) {
        this.maxDistance = maxDistance;
    }
}
