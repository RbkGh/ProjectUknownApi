package com.swiftpot.projectuknown.impl;

import com.google.gson.Gson;
import com.smsgh.*;
import com.swiftpot.projectuknown.ifaces.SMSSender;
import com.swiftpot.projectuknown.model.SMSSenderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         08-Sep-16 @ 11:22 AM
 */
@PropertySource("classpath:application.properties")
@Component
public class SMSSenderSwiftAlertImpl implements SMSSender {
    private final Logger log = LoggerFactory.getLogger(getClass());

    Environment env;
    private static final String AUTH_CLIENTID = "auth.clientId";
    private static final String AUTH_CLIENT_SECRET = "auth.clientSecret";


    public SMSSenderSwiftAlertImpl(){}

    @Autowired
    public SMSSenderSwiftAlertImpl(Environment env) {
        this.env = env;
    }

    @Override
    public boolean isMessageSendingSuccessful(SMSSenderRequest smsSenderRequest) {
        boolean isMessageSendingSuccessful = false;
        String clientId = env.getProperty(AUTH_CLIENTID);
        String clientSecret = env.getProperty(AUTH_CLIENT_SECRET);

        BasicAuth auth = new BasicAuth(clientId, clientSecret);
        ApiHost host = new ApiHost(auth);
        // Instance of the Messaging API
        MessagingApi messagingApi = new MessagingApi(host);
        try {
            MessageResponse response = messagingApi.sendQuickMessage("Wonsano",
                    smsSenderRequest.getRecipientPhoneNum(), smsSenderRequest.getMessage(), null);
            log.info("{}", new Gson().toJson(response));
            System.out.println("Server Response Status " + response.getStatus());
            if (response.getStatus() == 0) {
                isMessageSendingSuccessful = true;
            } else {

            }
        } catch (HttpRequestException ex) {
            System.out.println("Exception Server Response Status " + ex.getHttpResponse().getStatus());
            System.out.println("Exception Server Response Body " + ex.getHttpResponse().getBodyAsString());


        } catch (Exception e) {
            log.info("Exception Caught::\n\n\n\t{}", e.getMessage());

        }

        return isMessageSendingSuccessful;
    }
}
