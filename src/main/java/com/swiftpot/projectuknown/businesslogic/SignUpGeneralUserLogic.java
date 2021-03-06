package com.swiftpot.projectuknown.businesslogic;

import com.swiftpot.projectuknown.db.model.GeneralUserDocEntity;
import com.swiftpot.projectuknown.model.CreatedIdForOutgoingPayload;
import com.swiftpot.projectuknown.model.GeneralUserSignUpRequest;
import com.swiftpot.projectuknown.model.OutgoingPayload;
import com.swiftpot.projectuknown.model.SuccessfulOutgoingPayload;
import com.swiftpot.projectuknown.repository.GeneralUserDocEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         03-Sep-16 @ 8:39 PM
 */
@Service
public class SignUpGeneralUserLogic {

    @Autowired
    GeneralUserDocEntityRepository generalUserDocEntityRepository;



    public OutgoingPayload updateGeneralUser(String id,GeneralUserSignUpRequest signUpRequest){
        System.out.println("Request came name= " + signUpRequest.getFirstName());
        GeneralUserDocEntity generalUserDocEntity = new GeneralUserDocEntity(signUpRequest.getFirstName(),
                                                                             signUpRequest.getLastName(),
                                                                             signUpRequest.getPhoneNumber(),
                                                                             signUpRequest.getPassWord());
        generalUserDocEntity.setId(id);

        GeneralUserDocEntity savedGeneralUserDocEntity = generalUserDocEntityRepository.save(generalUserDocEntity);

        SuccessfulOutgoingPayload successfulOutgoingPayload = new SuccessfulOutgoingPayload(new CreatedIdForOutgoingPayload(savedGeneralUserDocEntity.getId()));

        return successfulOutgoingPayload;
    }
}
