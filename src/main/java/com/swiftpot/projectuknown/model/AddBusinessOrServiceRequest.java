package com.swiftpot.projectuknown.model;

import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

import java.util.List;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         07-Sep-16 @ 7:30 AM
 */
public class AddBusinessOrServiceRequest {

    private String bizName;

    private String bizPhoneNumPrimary;

    private String[] bizPhoneNumOthers;

    private String bizEmailPrimary;

    private String bizEmailOthers;

    private String bizWebsite;

    private String bizAddress;

    private String bizDescription;

    private String bizLogoUrl;

    private String[] bizDescriptionPhotos;

    private String[] bizTagPrimary;

    private List<BusinessTagsOthers> bizTagsOthers;

    /**
     * must be in order of longitude,latitude==a standardized convention,NOTE!!!
     */
    private BusinessFineLocation bizFineLocation;

    private String bizCoarseLocation;

    private int bizNumOfEmployees;

    private BusinessCurrentNumOfEmployeesType bizNumOfEmployeesType;

    public AddBusinessOrServiceRequest() {
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public String getBizPhoneNumPrimary() {
        return bizPhoneNumPrimary;
    }

    public void setBizPhoneNumPrimary(String bizPhoneNumPrimary) {
        this.bizPhoneNumPrimary = bizPhoneNumPrimary;
    }

    public String[] getBizPhoneNumOthers() {
        return bizPhoneNumOthers;
    }

    public void setBizPhoneNumOthers(String[] bizPhoneNumOthers) {
        this.bizPhoneNumOthers = bizPhoneNumOthers;
    }

    public String getBizEmailPrimary() {
        return bizEmailPrimary;
    }

    public void setBizEmailPrimary(String bizEmailPrimary) {
        this.bizEmailPrimary = bizEmailPrimary;
    }

    public String getBizEmailOthers() {
        return bizEmailOthers;
    }

    public void setBizEmailOthers(String bizEmailOthers) {
        this.bizEmailOthers = bizEmailOthers;
    }

    public String getBizWebsite() {
        return bizWebsite;
    }

    public void setBizWebsite(String bizWebsite) {
        this.bizWebsite = bizWebsite;
    }

    public String getBizAddress() {
        return bizAddress;
    }

    public void setBizAddress(String bizAddress) {
        this.bizAddress = bizAddress;
    }

    public String getBizDescription() {
        return bizDescription;
    }

    public void setBizDescription(String bizDescription) {
        this.bizDescription = bizDescription;
    }

    public String getBizLogoUrl() {
        return bizLogoUrl;
    }

    public void setBizLogoUrl(String bizLogoUrl) {
        this.bizLogoUrl = bizLogoUrl;
    }

    public String[] getBizDescriptionPhotos() {
        return bizDescriptionPhotos;
    }

    public void setBizDescriptionPhotos(String[] bizDescriptionPhotos) {
        this.bizDescriptionPhotos = bizDescriptionPhotos;
    }

    public String[] getBizTagPrimary() {
        return bizTagPrimary;
    }

    public void setBizTagPrimary(String[] bizTagPrimary) {
        this.bizTagPrimary = bizTagPrimary;
    }

    public List<BusinessTagsOthers> getBizTagsOthers() {
        return bizTagsOthers;
    }

    public void setBizTagsOthers(List<BusinessTagsOthers> bizTagsOthers) {
        this.bizTagsOthers = bizTagsOthers;
    }

    public BusinessFineLocation getBizFineLocation() {
        return bizFineLocation;
    }

    public void setBizFineLocation(BusinessFineLocation bizFineLocation) {
        this.bizFineLocation = bizFineLocation;
    }

    public String getBizCoarseLocation() {
        return bizCoarseLocation;
    }

    public void setBizCoarseLocation(String bizCoarseLocation) {
        this.bizCoarseLocation = bizCoarseLocation;
    }

    public int getBizNumOfEmployees() {
        return bizNumOfEmployees;
    }

    public void setBizNumOfEmployees(int bizNumOfEmployees) {
        this.bizNumOfEmployees = bizNumOfEmployees;
    }

    public BusinessCurrentNumOfEmployeesType getBizNumOfEmployeesType() {
        return bizNumOfEmployeesType;
    }

    public void setBizNumOfEmployeesType(BusinessCurrentNumOfEmployeesType bizNumOfEmployeesType) {
        this.bizNumOfEmployeesType = bizNumOfEmployeesType;
    }
}
