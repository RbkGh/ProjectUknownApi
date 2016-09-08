package com.swiftpot.projectuknown.ifaces;

import com.swiftpot.projectuknown.model.SMSSenderRequest;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         08-Sep-16 @ 11:17 AM
 */
public interface SMSSender {
     boolean isMessageSendingSuccessful(SMSSenderRequest smsSenderRequest);
}
