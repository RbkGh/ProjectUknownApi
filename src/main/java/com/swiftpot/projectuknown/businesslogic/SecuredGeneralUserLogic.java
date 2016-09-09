package com.swiftpot.projectuknown.businesslogic;

import com.swiftpot.projectuknown.model.GeneralUserSearchRequest;
import com.swiftpot.projectuknown.model.OutgoingPayload;
import org.springframework.stereotype.Service;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         08-Sep-16 @ 11:52 PM
 */
@Service
public class SecuredGeneralUserLogic {

    public OutgoingPayload generalUserSearchRequestHandler(GeneralUserSearchRequest generalUserSearchRequest){
        OutgoingPayload outgoingPayload = new OutgoingPayload();
        outgoingPayload.setMessage("search started");
        outgoingPayload.setStatus("00");
        outgoingPayload.setResponseObject(generalUserSearchRequest);
        return new OutgoingPayload();
    }
}
