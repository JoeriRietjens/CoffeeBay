package com.joeri.coffeebay.util;

import java.security.NoSuchAlgorithmException;

public class PasswordValidator {

    public static boolean validatePassword(String password, String storedPassword) throws NoSuchAlgorithmException {

        password = PasswordHasher.HashPassword(password);

        if (password == storedPassword) {
            return true;
        } 
        return false;
    }
}
