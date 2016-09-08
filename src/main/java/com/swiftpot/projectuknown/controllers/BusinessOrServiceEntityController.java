package com.swiftpot.projectuknown.controllers;

import com.swiftpot.projectuknown.businesslogic.BusinessOrServiceEntityLogic;
import com.swiftpot.projectuknown.model.AddBusinessOrServiceRequest;
import com.swiftpot.projectuknown.model.OutgoingPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         07-Sep-16 @ 7:26 AM
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@RestController
@RequestMapping("/api/v1/business")
public class BusinessOrServiceEntityController {

    @Autowired
    BusinessOrServiceEntityLogic businessOrServiceEntityLogic;

    @RequestMapping(path = "/{id}",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public OutgoingPayload addBusinessOrService
            (@PathVariable String id ,@RequestBody AddBusinessOrServiceRequest addBusinessOrServiceRequest)throws ServletException{

        return businessOrServiceEntityLogic.addBusinessOrService(id,addBusinessOrServiceRequest);
    }
}
