package com.camping.dev.util;

import org.mindrot.jbcrypt.BCrypt;

public interface BCryptUtil {

    static String encrypt(String password) {

        return BCrypt.hashpw(password, BCrypt.gensalt());

    }

    static boolean isMatch(String password, String hashed) {

        return BCrypt.checkpw(password, hashed);

    }

}

