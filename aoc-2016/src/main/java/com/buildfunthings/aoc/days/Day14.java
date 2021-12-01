package com.buildfunthings.aoc.days;

import com.buildfunthings.aoc.common.Day;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day14 implements Day<Integer> {

    public String produceMD5(String prefix, int postfix) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            String a = prefix + postfix;
            md.update(a.getBytes());
            byte[] digest = md.digest();

            return DatatypeConverter.printHexBinary(digest).toLowerCase();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String stretchMD5(String md5) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            String stretch = md5;
            for (int i = 0; i < 2016; i++) {

                md.update(stretch.getBytes());
                byte[] digest = md.digest();

                stretch = DatatypeConverter.printHexBinary(digest).toLowerCase();
            }
            return stretch;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Optional<Character> contains3chars(String str) {
        Pattern p = Pattern.compile("([a-zA-Z0-9])\\1\\1");
        Matcher m = p.matcher(str);

        if (m.find()) {
            String s = m.group(1);
            return Optional.of(s.charAt(0));
        }

        return Optional.empty();
    }

    public boolean containsFive(String s, char r) {
        return s.contains(String.valueOf(r).repeat(5));
    }

    @Override
    public Integer part1(List<String> input) {
        String salt = input.get(0);
        return generateKeySets(salt, false);
    }

    @Override
    public Integer part2(List<String> input) {
        String salt = input.get(0);
        return generateKeySets(salt, true);
    }

    private int generateKeySets(String salt, boolean stretch) {
        int counter = 0;
        int found = 0;

        // caches
        Map<Integer, Character> triplets = new HashMap<>();
        Map<Integer, Character> quintuplets = new HashMap<>();

        // build caches for the first 50000 cases
        while (counter < 50000) {
            String md5 = produceMD5(salt, counter);
            //System.out.println(counter + " " + md5);
            if (stretch)
                md5 = stretchMD5(md5);
            //System.out.println(counter + " " + md5);
            Optional<Character> c = contains3chars(md5);
            if (c.isEmpty()) {
                counter++;
                continue;
            }

            triplets.put(counter, c.get());

            if (containsFive(md5, c.get())) {
                quintuplets.put(counter, c.get());
            }

            counter++;
        }

        // filter out the triplets that do not have a quintuplet within 1000
        for (Integer index : triplets.keySet().stream().sorted().collect(Collectors.toList())) {
            for (int i : IntStream.range(index + 1, index + 1000).toArray()) {
                if (quintuplets.containsKey(i) && quintuplets.get(i) == triplets.get(index)) {
                    found++;
                    if (found == 64) {
                        return index;
                    }
                    break;
                }
            }
        }

        return 0;
    }

}