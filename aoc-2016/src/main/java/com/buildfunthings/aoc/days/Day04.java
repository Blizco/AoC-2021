package com.buildfunthings.aoc.days;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.buildfunthings.aoc.common.Day;

public class Day04 implements Day<Integer> {


    public Integer validRoom(String room) {
        //  Each room consists of an encrypted name (lowercase letters
        //  separated by dashes) followed by a dash, a sector ID, and
        //  a checksum in square brackets.

        //                aaaaa-bbb-z-y-x-123[abxyz]
        String pattern = "^(.+)-(\\d+)\\[(.+)\\]$";
        Pattern r = Pattern.compile(pattern);
        
        Matcher m = r.matcher(room);
        if (m.find()) {
            String name = m.group(1);
            name = name.replaceAll("-", "");
            Integer sectorId = Integer.parseInt(m.group(2));
            String checksum = m.group(3);
            
            //System.out.println(room + ": " + m.group(1) + " " + m.group(2) +" " +  m.group(3));
            Map<Character, Integer> freqs = new HashMap<>();
            for (char c : name.toCharArray()) {
                freqs.merge(c, // key = char
                            1, // value to merge
                            Integer::sum); // counting
            }
            Map <Character, Integer> sorted = freqs.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
            
            StringBuilder sb = new StringBuilder();
            int chks = 0;
            for (Character c : sorted.keySet()) {
                if (chks++ < 5) {
                    sb.append(c);
                } else {
                    break;
                }
            }
            // checksum is the five most common letters in the encrypted
            // name, in order, with ties broken by alphabetization
            if (sb.toString().equals(checksum)) {
                return sectorId;
            }
        }
        return 0;
    }
    public String rot(String s, int shift) {
        StringBuilder result = new StringBuilder();
        for (char character : s.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + shift) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        
        return result.toString();        
    }

    @Override
    public Integer part1(List<String> input) {
        String pattern = "^(.+)-(\\d+)\\[(.+)]$";
        Pattern r = Pattern.compile(pattern);
        Integer sectorSum = 0;
        
        for (String room : input ) {
            sectorSum += validRoom(room);
        }
        
        return sectorSum;
    }
    
    @Override
    public Integer part2(List<String> input) {
        String pattern = "^(.+)-(\\d+)\\[(.+)]$";
        Pattern r = Pattern.compile(pattern);
        
        for (String room : input ) {
            Integer si = validRoom(room);
            
            if (si > 0) {
                Matcher m = r.matcher(room);
                if (m.find()) {
                    String s = m.group(1).replaceAll("-", " ");
                    if ("northpole object storage".equals(rot(s, si))) {
                        return si;
                    }
                }
            }
        }
        
        return 0; 
    }
    
}
