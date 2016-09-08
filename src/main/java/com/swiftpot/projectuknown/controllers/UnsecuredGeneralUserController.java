package com.swiftpot.projectuknown.controllers;

import com.swiftpot.projectuknown.businesslogic.LoginGeneralUserLogic;
import com.swiftpot.projectuknown.businesslogic.SignUpGeneralUserLogic;
import com.swiftpot.projectuknown.businesslogic.SignupGeneralUnactivatedUserLogic;
import com.swiftpot.projectuknown.model.GeneralUserSignUpRequest;
import com.swiftpot.projectuknown.model.OutgoingPayload;
import com.swiftpot.projectuknown.model.PassCodeRequest;
import com.swiftpot.projectuknown.model.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at rbk.unlimited@gmail.com> on
 *         02-Sep-16
 */

@SuppressWarnings("SpringJavaAutowiringInspection")
@RestController
@RequestMapping("")
public class UnsecuredGeneralUserController {

    @Autowired
    SignUpGeneralUserLogic signUpGeneralUserLogic;

    @Autowired
    LoginGeneralUserLogic loginGeneralUserLogic;

    @Autowired
    SignupGeneralUnactivatedUserLogic signupGeneralUnactivatedUserLogic;

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OutgoingPayload loginRequest(@RequestBody UserLoginRequest userLoginRequest)throws ServletException {
        return loginGeneralUserLogic.loginGeneralUser(userLoginRequest);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OutgoingPayload signUpGeneralUser(@PathVariable String id,GeneralUserSignUpRequest signUpRequest) {
        return signUpGeneralUserLogic.updateGeneralUser(id,signUpRequest);
    }

    @RequestMapping(value = "/user/signup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OutgoingPayload signupGeneralUnactivatedUser(@RequestBody GeneralUserSignUpRequest signUpRequest) {
        return signupGeneralUnactivatedUserLogic.signupGeneralUnactivatedUser(signUpRequest);
    }

    @RequestMapping(value = "/user/requestpasscode/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OutgoingPayload requestPassCode(@PathVariable String id) {
        return signupGeneralUnactivatedUserLogic.requestPassCode(id);
    }

    @RequestMapping(value = "/user/activate/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OutgoingPayload activateUser(@PathVariable String id,@RequestBody PassCodeRequest passCodeRequest) {
        return signupGeneralUnactivatedUserLogic.activateUser(id, passCodeRequest.getPassCode());
    }

}
