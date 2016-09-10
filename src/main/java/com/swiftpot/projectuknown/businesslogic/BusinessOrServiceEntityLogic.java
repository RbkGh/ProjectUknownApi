package com.swiftpot.projectuknown.businesslogic;

import com.google.gson.Gson;
import com.swiftpot.projectuknown.db.model.BusinessOrServiceDocEntity;
import com.swiftpot.projectuknown.db.model.GeneralUserDocEntity;
import com.swiftpot.projectuknown.model.*;
import com.swiftpot.projectuknown.repository.BusinessOrServiceDocEntityRepository;
import com.swiftpot.projectuknown.repository.GeneralUserDocEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         07-Sep-16 @ 8:26 AM
 */

@Service
public class BusinessOrServiceEntityLogic {

    Logger log = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    GeneralUserDocEntityRepository generalUserDocEntityRepository;
    @Autowired
    BusinessOrServiceDocEntityRepository businessOrServiceDocEntityRepository;


    public OutgoingPayload addBusinessOrService(String id, AddBusinessOrServiceRequest addBusinessOrServiceRequest) {
        OutgoingPayload outgoingPayload;
        log.info("{}",id);

        if (isSpecifiedIdExistent(id) == true) {
            BusinessOrServiceDocEntity businessOrServiceDocEntity = addOrUpdateBusinessToUserAccount(id,addBusinessOrServiceRequest);
            outgoingPayload = new SuccessfulOutgoingPayload(businessOrServiceDocEntity);
        } else {
            outgoingPayload = new ErrorOutgoingPayload(null,"Incorrect id provided,user Account does not exist");
        }


        return outgoingPayload;
    }

    private boolean isSpecifiedIdExistent(String id) {

        boolean isSpecifiedIdExistent = false;
        GeneralUserDocEntity generalUserDocEntityWithSpecifiedId = findUserDocEntityById(id);

        if (generalUserDocEntityWithSpecifiedId != null) {
            log.info("Specified Id Resultant Entity For GeneralUserDocEntity == {}", new Gson().toJson(generalUserDocEntityWithSpecifiedId));
            isSpecifiedIdExistent = true;

        }else {
            //null,no need to re-initialize to false
        }

        return isSpecifiedIdExistent;

    }

    private GeneralUserDocEntity findUserDocEntityById(String id){
        return generalUserDocEntityRepository.findById(id);
    }

    /**
     *
     * @param id use same id of generalUser to save the business,for business to registered to that user
     * @param addBusinessOrServiceRequest
     * @return
     */
    private BusinessOrServiceDocEntity addOrUpdateBusinessToUserAccount(String id,AddBusinessOrServiceRequest addBusinessOrServiceRequest){
        BusinessOrServiceDocEntity businessOrServiceDocEntity = new BusinessOrServiceDocEntity();

        String bizName                                              = addBusinessOrServiceRequest.getBizName();
        String bizPhoneNumPrimary                                   = addBusinessOrServiceRequest.getBizPhoneNumPrimary();
        String[] bizPhoneNumOthers                                  = addBusinessOrServiceRequest.getBizPhoneNumOthers();
        String bizEmailPrimary                                      = addBusinessOrServiceRequest.getBizEmailPrimary();
        String bizEmailOthers                                       = addBusinessOrServiceRequest.getBizEmailOthers();
        String bizWebsite                                           = addBusinessOrServiceRequest.getBizWebsite();
        String bizAddress                                           = addBusinessOrServiceRequest.getBizAddress();
        String bizDescription                                       = addBusinessOrServiceRequest.getBizDescription();
        String bizLogoUrl                                           = addBusinessOrServiceRequest.getBizLogoUrl();
        String[] bizDescriptionPhotos                               = addBusinessOrServiceRequest.getBizDescriptionPhotos();
        String[] bizTagPrimary                                      = addBusinessOrServiceRequest.getBizTagPrimary();
        List<BusinessTagsOthers> bizTagsOthers                      = addBusinessOrServiceRequest.getBizTagsOthers();
        BusinessFineLocation bizFineLocation                        = addBusinessOrServiceRequest.getBizFineLocation();
        String bizCoarseLocation                                    = addBusinessOrServiceRequest.getBizCoarseLocation();
        int bizNumOfEmployees                                       = addBusinessOrServiceRequest.getBizNumOfEmployees();
        BusinessCurrentNumOfEmployeesType bizNumOfEmployeesType     = addBusinessOrServiceRequest.getBizNumOfEmployeesType();



        //save with same id as registered user,very important,for business to be on user's account
        //if the same id is set to the _id section,anytime another business is registered in addition,it will replace the existing business,since same id
        businessOrServiceDocEntity.setUserId(id);

        businessOrServiceDocEntity.setBizName(bizName);
        businessOrServiceDocEntity.setBizPhoneNumPrimary(bizPhoneNumPrimary);
        businessOrServiceDocEntity.setBizPhoneNumOthers(bizPhoneNumOthers);
        businessOrServiceDocEntity.setBizEmailPrimary(bizEmailPrimary);
        businessOrServiceDocEntity.setBizEmailOthers(bizEmailOthers);
        businessOrServiceDocEntity.setBizWebsite(bizWebsite);
        businessOrServiceDocEntity.setBizAddress(bizAddress);
        businessOrServiceDocEntity.setBizDescription(bizDescription);
        businessOrServiceDocEntity.setBizLogoUrl(bizLogoUrl);
        businessOrServiceDocEntity.setBizDescriptionPhotos(bizDescriptionPhotos);
        businessOrServiceDocEntity.setBizTagPrimary(bizTagPrimary);
        businessOrServiceDocEntity.setBizTagsOthers(bizTagsOthers);
        businessOrServiceDocEntity.setBizFineLocation(bizFineLocation);
        businessOrServiceDocEntity.setBizCoarseLocation(bizCoarseLocation);
        businessOrServiceDocEntity.setBizNumOfEmployees(bizNumOfEmployees);
        businessOrServiceDocEntity.setBizNumOfEmployeesType(bizNumOfEmployeesType);

        BusinessOrServiceDocEntity returnedEntityFromDB = businessOrServiceDocEntityRepository.save(businessOrServiceDocEntity);

        return returnedEntityFromDB;
    }
}
