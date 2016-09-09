package com.swiftpot.projectuknown.model;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         08-Sep-16 @ 11:47 PM
 */
public class GeneralUserSearchRequest {

    private String[] userLocation;

    private String searchQuery;

    public GeneralUserSearchRequest() {
    }

    public String[] getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String[] userLocation) {
        this.userLocation = userLocation;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }
}
