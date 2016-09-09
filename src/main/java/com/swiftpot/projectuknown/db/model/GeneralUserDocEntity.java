package com.swiftpot.projectuknown.db.model;

import com.swiftpot.projectuknown.model.AddBusinessOrServiceRequest;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         03-Sep-16 @ 7:06 PM
 */
@Document(collection = "GeneralUserDoc")
public class GeneralUserDocEntity {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String passWord;

    private ArrayList<AddBusinessOrServiceRequest> businessList;

    public GeneralUserDocEntity() {
    }

    public GeneralUserDocEntity(String firstName, String lastName, String phoneNumber, String passWord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.passWord = passWord;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    public ArrayList<AddBusinessOrServiceRequest> getBusinessList() {
        return businessList;
    }

    public void setBusinessList(ArrayList<AddBusinessOrServiceRequest> businessList) {
        this.businessList = businessList;
    }
}
