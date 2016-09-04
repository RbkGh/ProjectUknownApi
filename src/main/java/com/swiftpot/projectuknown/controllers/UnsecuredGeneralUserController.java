package com.swiftpot.projectuknown.controllers;

import com.swiftpot.projectuknown.businesslogic.SignUpGeneralUserLogic;
import com.swiftpot.projectuknown.model.GeneralUserSignUpRequest;
import com.swiftpot.projectuknown.model.OutgoingPayload;
import com.swiftpot.projectuknown.model.UserLoginRequest;
import com.swiftpot.projectuknown.support.BaseUrlHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at rbk.unlimited@gmail.com> on
 *         02-Sep-16
 */
@RestController
public class UnsecuredGeneralUserController {

    @Autowired
    SignUpGeneralUserLogic signUpGeneralUserLogic;

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OutgoingPayload loginRequest( @RequestBody UserLoginRequest userLoginRequest){

        OutgoingPayload outgoingPayload = new OutgoingPayload();

//        if (login.name == null || !userDb.containsKey(login.name)) {
//            throw new ServletException("Invalid login");
//        }
//        return new LoginResponse(Jwts.builder().setSubject(login.name)
//                .claim("roles", userDb.get(login.name)).setIssuedAt(new Date())
//                .signWith(SignatureAlgorithm.HS256, "secretkey").compact());

        return outgoingPayload;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OutgoingPayload signUpGeneralUser(@RequestBody GeneralUserSignUpRequest signUpRequest){
        return signUpGeneralUserLogic.signUpGeneralUser(signUpRequest);
    }

}
