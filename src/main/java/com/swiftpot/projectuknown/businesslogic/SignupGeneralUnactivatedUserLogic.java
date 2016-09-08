package com.swiftpot.projectuknown.businesslogic;

import com.swiftpot.projectuknown.db.model.GeneralUnactivatedUserDocEntity;
import com.swiftpot.projectuknown.db.model.GeneralUserDocEntity;
import com.swiftpot.projectuknown.impl.SMSSenderSwiftAlertImpl;
import com.swiftpot.projectuknown.model.*;
import com.swiftpot.projectuknown.repository.GeneralUnactivatedUserDocEntityRepository;
import com.swiftpot.projectuknown.repository.GeneralUserDocEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         08-Sep-16 @ 10:24 AM
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service
public class SignupGeneralUnactivatedUserLogic {

    Logger log = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    GeneralUnactivatedUserDocEntityRepository generalUnactivatedUserDocEntityRepository;

    @Autowired
    GeneralUserDocEntityRepository generalUserDocEntityRepository;

    @Autowired
    SMSSenderSwiftAlertImpl smsSenderSwiftAlert;

    public OutgoingPayload signupGeneralUnactivatedUser(GeneralUserSignUpRequest signUpRequest) {
        OutgoingPayload outgoingPayload;

        try {
            GeneralUnactivatedUserDocEntity generalUnactivatedUserDocEntityForStorageToDB = new GeneralUnactivatedUserDocEntity();
            generalUnactivatedUserDocEntityForStorageToDB.setFirstName(signUpRequest.getFirstName());
            generalUnactivatedUserDocEntityForStorageToDB.setLastName(signUpRequest.getLastName());
            generalUnactivatedUserDocEntityForStorageToDB.setPhoneNumber(signUpRequest.getPhoneNumber());
            generalUnactivatedUserDocEntityForStorageToDB.setPassWord(signUpRequest.getPassWord());

            GeneralUnactivatedUserDocEntity generalUnactivatedUserDocEntityResponseFromDb =
                    generalUnactivatedUserDocEntityRepository.save(generalUnactivatedUserDocEntityForStorageToDB);

            //return only Id as returning full object will return password too,and that's undesirable
            outgoingPayload = new SuccessfulOutgoingPayload(new CreatedIdForOutgoingPayload(generalUnactivatedUserDocEntityResponseFromDb.getId()));
        } catch (Exception e) {
            outgoingPayload = new ErrorOutgoingPayload(null, "Error Signing Up User,Something went wrong");
        }

        return outgoingPayload;
    }

    public OutgoingPayload requestPassCode(String id) {
        log.info("Incoming id ="+id);
        OutgoingPayload outgoingPayload;

        if (isUserIdExistentInGeneralUnactivatedDoc(id) == true) {
            GeneralUnactivatedUserDocEntity generalUnactivatedUserDocEntity = generalUnactivatedUserDocEntityRepository.findOne(id);
            //send sms passcode to phoneNumber
            String generatedPassCode = generateFourDigitPassCode();
            String recipientPhoneNumber = generalUnactivatedUserDocEntity.getPhoneNumber();
            SMSSenderRequest smsSenderRequest = new SMSSenderRequest(recipientPhoneNumber,
                    "Passcode = " + generatedPassCode+" Test,Ignore----Sent with SwiftAlertApi(www.swiftpot.com/swiftalert)");
            if (smsSenderSwiftAlert.isMessageSendingSuccessful(smsSenderRequest) == true) {
                //update field passCode  with passCode sent to user's phone,user will be activated based on generatedPasscode he prevents
                generalUnactivatedUserDocEntity.setPassCode(generatedPassCode);
                GeneralUnactivatedUserDocEntity generalUnactivatedUserDocEntityResponseFromDB = generalUnactivatedUserDocEntityRepository.save(generalUnactivatedUserDocEntity);


                outgoingPayload = new SuccessfulOutgoingPayload(
                        new CreatedIdForOutgoingPayload(generalUnactivatedUserDocEntityResponseFromDB.getId()));
            } else {
                outgoingPayload = new ErrorOutgoingPayload(null, "Could not send message to " + recipientPhoneNumber + ", ensure number is correct");
            }


        } else {
            outgoingPayload = new ErrorOutgoingPayload(null, "User Id does not exist");
        }

        return outgoingPayload;
    }

    public OutgoingPayload activateUser(String id, String passCode) {
        OutgoingPayload outgoingPayload = new OutgoingPayload();
        if (isUserIdExistentInGeneralUnactivatedDoc(id) == true) {
            GeneralUnactivatedUserDocEntity generalUnactivatedUserDocEntity = generalUnactivatedUserDocEntityRepository.findOne(id);


            //check if passcode tallies with db version
            String passCodeDBVersion = generalUnactivatedUserDocEntity.getPassCode();
            log.info("PassCode From user = {},PassCode From DB = {}",passCode,passCodeDBVersion);
            if (passCode.equalsIgnoreCase(passCodeDBVersion)) {


                String phoneNumberOfUserRequestingToBeActivated = generalUnactivatedUserDocEntity.getPhoneNumber();
                String idOOfUserRequestingToBeActivated = generalUnactivatedUserDocEntity.getId();
                String firstNameOfUserRequestingToBeActivated = generalUnactivatedUserDocEntity.getFirstName();
                String lastNameOfUserRequestingToBeActivated = generalUnactivatedUserDocEntity.getLastName();
                String passWordOfUserRequestingToBeActivated = generalUnactivatedUserDocEntity.getPassWord();


                //now insert user data into original document,but wait,maybe user is already activated in original doc,let's check that first
                GeneralUserDocEntity generalUserDocEntityExistence = generalUserDocEntityRepository.findByPhoneNumber(phoneNumberOfUserRequestingToBeActivated);
                log.info("GeneralUserDocEntity = {}",generalUserDocEntityExistence);
                if (generalUserDocEntityExistence == null) {
                    //does not exist,we can now safely save to original document
                    GeneralUserDocEntity generalUserDocEntityValidatedPhoneNumber = new GeneralUserDocEntity();
                    generalUserDocEntityValidatedPhoneNumber.setId(idOOfUserRequestingToBeActivated);
                    generalUserDocEntityValidatedPhoneNumber.setFirstName(firstNameOfUserRequestingToBeActivated);
                    generalUserDocEntityValidatedPhoneNumber.setLastName(lastNameOfUserRequestingToBeActivated);
                    generalUserDocEntityValidatedPhoneNumber.setPassWord(passWordOfUserRequestingToBeActivated);
                    generalUserDocEntityValidatedPhoneNumber.setPhoneNumber(phoneNumberOfUserRequestingToBeActivated);

                    GeneralUserDocEntity generalUserDocEntityResponseFromDB = generalUserDocEntityRepository.save(generalUserDocEntityValidatedPhoneNumber);
                    String idToReturnToUser = generalUserDocEntityResponseFromDB.getId();
                    CreatedIdForOutgoingPayload createdIdForOutgoingPayload = new CreatedIdForOutgoingPayload(idToReturnToUser);
                    outgoingPayload = new SuccessfulOutgoingPayload("Activated User Successfully", createdIdForOutgoingPayload);
                }else{
                    //User Exists in Main Original GeneralUserDocEntity already
                    outgoingPayload = new ErrorOutgoingPayload(null,"User Exists Already Or Activated already");
                }


            } else {
                outgoingPayload = new ErrorOutgoingPayload(null, "passCode is Incorrect");
            }

        } else {
            outgoingPayload = new ErrorOutgoingPayload(null, "User Id does not exist");
        }
        return outgoingPayload;
    }


    public boolean isUserIdExistentInGeneralUnactivatedDoc(String id) {
        boolean isUserIdExistent = false;

        //log.info("Long version of id = {}",longId);
        GeneralUnactivatedUserDocEntity generalUnactivatedUserDocEntity = generalUnactivatedUserDocEntityRepository.findOne(id);
        if (generalUnactivatedUserDocEntity != null) {
            //userId exists,hence return true
            isUserIdExistent = true;

        } else {
            //do nothing since its null and false is set already during initialization

        }

        return isUserIdExistent;
    }


    private static String generateFourDigitPassCode() {
        String raw = "";
        for (int i = 0; i < 4; i++) {
            Random rand = new Random();
            int curr = rand.nextInt(10); //choose from a range of 0-9

            raw = raw + String.valueOf(curr);
        }
        return raw;
    }

}
