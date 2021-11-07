package com.buildfunthings.aoc.days;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.buildfunthings.aoc.common.Day;

public class Day04 implements Day<Integer> {

    @Override
    public Integer part1(List<String> input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            int i = 0;
            do {
                String text = input.get(0) + i;
                
                md.update(text.getBytes());
                byte[] digest = md.digest();
                
                if (digest[0] == 0 && digest[1] == 0 && (digest[2] & 0xFF) < 0x10) {
                    return i;
                }
                ++i;
            } while (true);

        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer part2(List<String> input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            int i = 0;
            do {
                String text = input.get(0) + i;
                
                md.update(text.getBytes());
                byte[] digest = md.digest();
                
                if (digest[0] == 0 && digest[1] == 0 && digest[2] == 0) {
                    return i;
                }
                ++i;
            } while (true);

        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
