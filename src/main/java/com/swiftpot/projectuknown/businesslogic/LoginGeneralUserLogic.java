package com.swiftpot.projectuknown.businesslogic;

import com.swiftpot.projectuknown.db.model.GeneralUserDocEntity;
import com.swiftpot.projectuknown.model.OutgoingPayload;
import com.swiftpot.projectuknown.model.SuccessfulOutgoingPayload;
import com.swiftpot.projectuknown.model.UserLoginRequest;
import com.swiftpot.projectuknown.model.UserLoginResponse;
import com.swiftpot.projectuknown.repository.GeneralUserDocEntityRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import java.util.Date;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         04-Sep-16 @ 5:59 PM
 */
@Component
public class LoginGeneralUserLogic {

    @Autowired
    GeneralUserDocEntityRepository generalUserDocEntityRepository;

    public OutgoingPayload loginGeneralUser(UserLoginRequest userLoginRequest) throws ServletException {


        if (!isUserCredentialsOK(userLoginRequest)) {
            throw new ServletException("Invalid login");
        }

        UserLoginResponse userLoginResponse = new UserLoginResponse(Jwts.builder().setSubject(userLoginRequest.getUserName())
                /*.claim("roles", userDb.get(login.name))*/.setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact());
        SuccessfulOutgoingPayload successfulOutgoingPayload = new SuccessfulOutgoingPayload(userLoginResponse);
//        return new LoginResponse(Jwts.builder().setSubject(login.name)
//                .claim("roles", userDb.get(login.name)).setIssuedAt(new Date())
//                .signWith(SignatureAlgorithm.HS256, "secretkey").compact());

        return successfulOutgoingPayload;
    }


    private boolean isUserCredentialsOK(UserLoginRequest userLoginRequest) {
        boolean isUserCredentialsOk = true;

        if (generalUserDocEntityRepository.findByPhoneNumberAndPassWord(Integer.valueOf(userLoginRequest.getUserName()),
                userLoginRequest.getPassWord()).equals(null)) {
            isUserCredentialsOk = false;
        }

        return isUserCredentialsOk;
    }
}
