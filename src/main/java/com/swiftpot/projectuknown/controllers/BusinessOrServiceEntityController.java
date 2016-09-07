package com.swiftpot.projectuknown.controllers;

import com.swiftpot.projectuknown.businesslogic.BusinessOrServiceEntityLogic;
import com.swiftpot.projectuknown.model.AddBusinessOrServiceRequest;
import com.swiftpot.projectuknown.model.OutgoingPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         07-Sep-16 @ 7:26 AM
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@RestController
@RequestMapping("/api/vi/business")
public class BusinessOrServiceEntityController {

    @Autowired
    BusinessOrServiceEntityLogic businessOrServiceEntityLogic;

    @RequestMapping(path = "/{userName}")
    public OutgoingPayload addBusinessOrService(@PathVariable String userName ,@RequestBody AddBusinessOrServiceRequest addBusinessOrServiceRequest){
        return businessOrServiceEntityLogic.addBusinessOrService(userName,addBusinessOrServiceRequest);
    }
}
