package org.example.user;

import java.util.regex.Pattern;

public class PhoneNumberValidator {
    private static final Pattern phoneNumberPattern=Pattern.compile("^9989[0123456789][0-9]{7}$");

    public static boolean validate(String phoneNumber){
        return phoneNumberPattern.matcher(phoneNumber).matches();
    }
}
