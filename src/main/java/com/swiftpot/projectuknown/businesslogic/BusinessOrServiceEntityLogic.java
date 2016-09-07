package com.swiftpot.projectuknown.businesslogic;

import com.swiftpot.projectuknown.model.AddBusinessOrServiceRequest;
import com.swiftpot.projectuknown.model.OutgoingPayload;
import org.springframework.stereotype.Service;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         07-Sep-16 @ 8:26 AM
 */
@Service
public class BusinessOrServiceEntityLogic {

    public OutgoingPayload addBusinessOrService(String userName,AddBusinessOrServiceRequest addBusinessOrServiceRequest){
        OutgoingPayload outgoingPayload = new OutgoingPayload();

        return outgoingPayload;
    }
}
