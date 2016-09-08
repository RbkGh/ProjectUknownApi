package com.swiftpot.projectuknown;

import java.util.Random;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at [rodney@swiftpot.com,rbk.unlimited@gmail.com]> on
 *         08-Sep-16 @ 12:18 PM
 */
public class GeneralTests {

    public static void main(String[] args) {




        System.out.println("Final 4digit generated number == "+generateFourDigitPassCode());
    }

    private static String generateFourDigitPassCode(){
        String raw = "";
        for (int i = 0 ;i< 4;i++) {
            Random rand = new Random();
            int curr = rand.nextInt(10);
            System.out.println("generated number = "+curr);
            raw = raw + String.valueOf(curr);
        }
        return raw;
    }
}
