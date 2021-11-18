package com.buildfunthings.aoc.days;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import com.buildfunthings.aoc.common.Day;

public class Day05 implements Day<String> {

    @Override
    public String part1(List<String> input) {
        StringBuilder sb = new StringBuilder();
        String start = input.get(0);
        int counter = 0;
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            for (int i = 0; i < 8; i++) {
                while (true) {
                    String a = start + counter++;
                    md.update(a.getBytes());
                    byte[] digest = md.digest();
                    String myHash = DatatypeConverter.printHexBinary(digest).toLowerCase();

                    if (myHash.startsWith("00000")) {
                        sb.append(myHash.charAt(5));
                        break; // go back to for loop
                    }
                }
            }
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        return sb.toString();
    }

    @Override
    public String part2(List<String> input) {
        String start = input.get(0);
        char[] password = new char[8];
        int counter = 0;
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            for (int i = 0; i < 8; i++) {
                while (true) {
                    String a = start + counter++;
                    md.update(a.getBytes());
                    byte[] digest = md.digest();
                    String myHash = DatatypeConverter.printHexBinary(digest).toLowerCase();

                    if (myHash.startsWith("00000")) {
                        Character pos = myHash.charAt(5);
                        int c = pos - '0';
                        if (c >= 0 && c <= 7 ) {
                            if (password[c] == Character.MIN_VALUE) {
                                password[c] = myHash.charAt(6);
                                break; // go back to for loop
                            }
                        } // else it is invalid
                    }
                }
            }
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
         
        return new String(password);
    }
    
}
