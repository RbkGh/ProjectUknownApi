package com.swiftpot.projectuknown.controllers;

import com.swiftpot.projectuknown.businesslogic.SecuredGeneralUserLogic;
import com.swiftpot.projectuknown.model.GeneralUserSearchRequest;
import com.swiftpot.projectuknown.model.OutgoingPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at rbk.unlimited@gmail.com> on
 *         03-Sep-16
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@RestController
@RequestMapping("api/v1")
public class SecuredGeneralUserController {

    @Autowired
    SecuredGeneralUserLogic securedGeneralUserLogic;

    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OutgoingPayload generalUserSearchRequestHandler(@RequestBody GeneralUserSearchRequest generalUserSearchRequest) {

        return securedGeneralUserLogic.generalUserSearchRequestHandler(generalUserSearchRequest);
    }


}
