package com.demo.microservi.config.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashCreator {

    public static String createMD5Hash(final String input) {
        try{
            String hashtext = null;
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            // Compute message digest of the input
            byte[] messageDigest = md.digest(input.getBytes());
            hashtext = convertToHex(messageDigest);
            return hashtext;
        }catch (NoSuchAlgorithmException e){

        }
        return  input;
    }

    private static String convertToHex(final byte[] messageDigest) {
        BigInteger bigint = new BigInteger(1, messageDigest);
        String hexText = bigint.toString(16);
        while (hexText.length() < 32) {
            hexText = "0".concat(hexText);
        }
        return hexText;
    }
}
