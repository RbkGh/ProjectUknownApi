package com.swiftpot.projectuknown.controllers;

import com.swiftpot.projectuknown.model.OutgoingPayload;
import com.swiftpot.projectuknown.model.UserLoginRequest;
import com.swiftpot.projectuknown.support.BaseUrlHolder;
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
@RestController
@RequestMapping("api/v1")
public class SecuredGeneralUserController {

    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OutgoingPayload loginRequest( @RequestBody UserLoginRequest userLoginRequest){

        OutgoingPayload outgoingPayload = new OutgoingPayload();
        outgoingPayload.setMessage("search started");
        outgoingPayload.setStatus("00");
        outgoingPayload.setResponseObject(userLoginRequest);

        return outgoingPayload;
    }


}
