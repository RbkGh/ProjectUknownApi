package com.swiftpot.projectuknown.businesslogic;

import com.swiftpot.projectuknown.db.model.GeneralUserDocEntity;
import com.swiftpot.projectuknown.model.AddBusinessOrServiceRequest;
import com.swiftpot.projectuknown.model.ErrorOutgoingPayload;
import com.swiftpot.projectuknown.model.OutgoingPayload;
import com.swiftpot.projectuknown.model.SuccessfulOutgoingPayload;
import com.swiftpot.projectuknown.repository.GeneralUserDocEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         07-Sep-16 @ 8:26 AM
 */
@SuppressWarnings("ALL")
@Service
public class BusinessOrServiceEntityLogic {

    Logger log = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    GeneralUserDocEntityRepository generalUserDocEntityRepository;

    @Autowired
    OutgoingPayload outgoingPayload;

    public OutgoingPayload addBusinessOrService(String id, AddBusinessOrServiceRequest addBusinessOrServiceRequest) {

        log.info("{}",id);

        if (isSpecifiedIdExistent(id) == true) {
            GeneralUserDocEntity generalUserDocEntity = addOrUpdateBusinessToUserAccount(findUserDocEntityById(id),addBusinessOrServiceRequest);
            outgoingPayload = new SuccessfulOutgoingPayload(generalUserDocEntity);
        } else {
            outgoingPayload = new ErrorOutgoingPayload(null,"Incorrect id provided,user Account does not exist");
        }


        return outgoingPayload;
    }

    private boolean isSpecifiedIdExistent(String id) {

        boolean isSpecifiedIdExistent = false;
        GeneralUserDocEntity generalUserDocEntityWithSpecifiedId = findUserDocEntityById(id);

        if (generalUserDocEntityWithSpecifiedId != null) {
            log.info("Specified Id Resultant Entity For GeneralUserDocEntity == {}", generalUserDocEntityWithSpecifiedId);
            isSpecifiedIdExistent = true;

        }else {
            //null,no need to re-initialize to false
        }

        return isSpecifiedIdExistent;

    }

    private GeneralUserDocEntity findUserDocEntityById(String id){
        return generalUserDocEntityRepository.findById(id);
    }

    private GeneralUserDocEntity addOrUpdateBusinessToUserAccount(GeneralUserDocEntity generalUserDocEntity,
                                                                  AddBusinessOrServiceRequest addBusinessOrServiceRequest){
        GeneralUserDocEntity generalUserDocEntityfinalResponseFromMethod = new GeneralUserDocEntity();

        ArrayList<AddBusinessOrServiceRequest> addBusinessOrServiceRequestArrayList = null;
        addBusinessOrServiceRequestArrayList = generalUserDocEntity.getBusinessList();

        if(addBusinessOrServiceRequestArrayList == null || addBusinessOrServiceRequestArrayList.isEmpty()){
            //initialise array since it's null or empty
            addBusinessOrServiceRequestArrayList = new ArrayList<>();

            addBusinessOrServiceRequestArrayList.add(addBusinessOrServiceRequest);
            //set addBusinessOrServiceRequestArrayList to GeneralUserDocEntity and save
            generalUserDocEntity.setBusinessList(addBusinessOrServiceRequestArrayList);
            generalUserDocEntityfinalResponseFromMethod = generalUserDocEntityRepository.save(generalUserDocEntity);
    }else{
            //add to list straight since its not empty or null and insert to Db
            addBusinessOrServiceRequestArrayList.add(addBusinessOrServiceRequest);
            //set addBusinessOrServiceRequestArrayList to GeneralUserDocEntity and save
            generalUserDocEntity.setBusinessList(addBusinessOrServiceRequestArrayList);
            generalUserDocEntityfinalResponseFromMethod = generalUserDocEntityRepository.save(generalUserDocEntity);
        }
        return generalUserDocEntityfinalResponseFromMethod;
    }
}
