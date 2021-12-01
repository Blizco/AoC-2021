package com.buildfunthings.aoc.days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.buildfunthings.aoc.common.Day;

public class Day06 implements Day<String> {

    List<Map<Character,Integer>> getFrequencies(List<String> input) {
        int length = input.get(0).length();
        List<Map<Character, Integer>> freqs = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            freqs.add(new HashMap<>());            
        }
        
        for (String msg : input) {
            for (int i = 0; i < msg.length(); i++) {
                freqs.get(i).merge(msg.charAt(i), 1, Integer::sum);
            }
        }
        return freqs;
    }
    
    @Override
    public String part1(List<String> input) {
        List<Map<Character, Integer>> freqs = getFrequencies(input);
        
        StringBuilder sb = new StringBuilder();
        for (Map<Character,Integer> f : freqs) {
            int max = Collections.max(f.values());
            List<Character> maxKeys = f.entrySet().stream().filter(x -> x.getValue() == max).map(Map.Entry::getKey).collect(Collectors.toList());
            sb.append(maxKeys.get(0));
        }
        
        return sb.toString();
    }

    @Override
    public String part2(List<String> input) {
        List<Map<Character, Integer>> freqs = getFrequencies(input);
        
        StringBuilder sb = new StringBuilder();
        for (Map<Character,Integer> f : freqs) {
            int min = Collections.min(f.values());
            List<Character> minKeys = f.entrySet().stream().filter(x -> x.getValue() == min).map(Map.Entry::getKey).collect(Collectors.toList());
            sb.append(minKeys.get(0));
        }
        
        return sb.toString();
    }
    
}
