package com.swiftpot.projectuknown.db.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         08-Sep-16 @ 10:25 AM
 */
@Document(collection = "GeneralUnactivatedUserDoc")
public class GeneralUnactivatedUserDocEntity {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String passWord;

    /**
     * send sms passcode for user to reinput to activate account after registration
     */
    private String passCode;

    public GeneralUnactivatedUserDocEntity() {
    }

    public GeneralUnactivatedUserDocEntity(String firstName, String lastName, String phoneNumber, String passWord) {
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

    public String getPassCode() {
        return passCode;
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }
}
