package com.buildfunthings.aoc.days;

import java.util.List;

import com.buildfunthings.aoc.common.Day;

public class Day05 implements Day {

    boolean isNiceString(String entry) {
        int vowels = 0;
        int doubles = 0;
        boolean offensive = false;

        for (int i = 0; i < entry.length(); ++i) {
            switch (entry.charAt(i)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                vowels++;
            }

            if (i < entry.length() - 1 && entry.charAt(i) == entry.charAt(i + 1)) {
                doubles++;
            }

            for (String o : new String[] { "ab", "cd", "pq", "xy" }) {
                if (entry.contains(o)) {
                    offensive = true;
                }
            }
        }

        if (vowels >= 3 && doubles > 0 && !offensive) {
            return true;
        }

        return false;
    }

    boolean isNiceStringNotRidiculous(String entry) {
        int pair = 0;
        int repeat = 0;

        for (int i = 0; i < entry.length(); ++i) {
            if (i < entry.length() - 2) {
                String currentPair = entry.substring(i, i + 2);
                if (entry.indexOf(currentPair, i + 2) > i) {
                    ++pair;
                }
            }

            if (i < entry.length() - 2) {
                if (entry.charAt(i) == entry.charAt(i + 2)) {
                    ++repeat;
                }
            }
        }

        if (pair > 0 && repeat > 0) {
            return true;
        }

        return false;
    }

    @Override
    public String part1(List<String> input) {
        return String.valueOf(input.stream().filter(s -> isNiceString(s)).count());
    }

    @Override
    public String part2(List<String> input) {
        return String.valueOf(input.stream().filter(s -> isNiceStringNotRidiculous(s)).count());
    }

}
