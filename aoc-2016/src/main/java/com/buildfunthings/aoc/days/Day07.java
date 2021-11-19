package com.buildfunthings.aoc.days;

import java.util.ArrayList;
import java.util.List;

import com.buildfunthings.aoc.common.Day;

public class Day07 implements Day<Integer> {

    @Override
    public Integer part1(List<String> input) {
        int count = 0;
        for (String ip : input) {            
            boolean hyper = false;
            boolean hyperabba = false;
            boolean abba = false;
            for (int i = 0; i < ip.length()-3; i++) {
                if (ip.charAt(i) == '[') {
                    hyper = true;
                }
                else if (ip.charAt(i) == ']') {
                    hyper = false;
                }
                
                if (ip.charAt(i) == ip.charAt(i+3)
                    && ip.charAt(i+1) == ip.charAt(i+2)
                    && ip.charAt(i) != ip.charAt(i+1)) {
                    if (hyper) {
                        hyperabba = true;
                    } else {
                        abba = true;
                    }
                }
            }

            //System.out.println(ip + " " + abba);
            if (abba && !hyperabba) {
                
                count++;
            }
        }
        return count;
    }

    @Override
    public Integer part2(List<String> input) {
        int count = 0;
        for (String ip : input) {            
            boolean hyper = false;
            boolean hyperbab = false;
            boolean aba = false;
            List<char[]> abs = new ArrayList<>();

            // find aba
            for (int i = 0; i < ip.length()-2; i++) {
                if (ip.charAt(i) == '[') {
                    hyper = true;
                }
                else if (ip.charAt(i) == ']') {
                    hyper = false;
                }
                
                if (ip.charAt(i) == ip.charAt(i+2)
                    && ip.charAt(i) != ip.charAt(i+1)
                    && !hyper) {
                    abs.add(new char[] { ip.charAt(i), ip.charAt(i + 1) });
                    aba = true; // at least 1 aba
                } 
            }

            // find bab in hyper
            for (int i = 0; i < ip.length()-2; i++) {
                if (ip.charAt(i) == '[') {
                    hyper = true;
                }
                else if (ip.charAt(i) == ']') {
                    hyper = false;
                }
                for (char[] pair : abs) {
                    if (ip.charAt(i) == ip.charAt(i + 2) && ip.charAt(i) != ip.charAt(i + 1) && ip.charAt(i) == pair[1]
                            && ip.charAt(i + 1) == pair[0] && hyper) {
                        hyperbab = true;
                    }
                }
            }
            
            //System.out.println(ip + " " + aba + " " + hyperbab);
            if (aba && hyperbab) {
                count++;
            }
        }
        return count;
    }
    
}
