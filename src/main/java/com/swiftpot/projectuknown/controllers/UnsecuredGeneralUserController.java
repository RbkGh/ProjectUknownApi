package com.swiftpot.projectuknown.controllers;

import com.swiftpot.projectuknown.businesslogic.LoginGeneralUserLogic;
import com.swiftpot.projectuknown.businesslogic.SignUpGeneralUserLogic;
import com.swiftpot.projectuknown.model.GeneralUserSignUpRequest;
import com.swiftpot.projectuknown.model.OutgoingPayload;
import com.swiftpot.projectuknown.model.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at rbk.unlimited@gmail.com> on
 *         02-Sep-16
 */
@RestController
public class UnsecuredGeneralUserController {

    @Autowired
    SignUpGeneralUserLogic signUpGeneralUserLogic;

    @Autowired
    LoginGeneralUserLogic loginGeneralUserLogic;

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OutgoingPayload loginRequest(@RequestBody UserLoginRequest userLoginRequest)throws ServletException {
        return loginGeneralUserLogic.loginGeneralUser(userLoginRequest);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OutgoingPayload signUpGeneralUser(@RequestBody GeneralUserSignUpRequest signUpRequest) {
        return signUpGeneralUserLogic.signUpGeneralUser(signUpRequest);
    }

}
