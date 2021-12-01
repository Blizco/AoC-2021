package com.buildfunthings.aoc.days;

import java.util.List;

import com.buildfunthings.aoc.common.Day;

public class Day05 implements Day<Long> {

    boolean isNiceString(String entry) {
        int vowels = 0;
        int doubles = 0;
        boolean offensive = false;

        for (int i = 0; i < entry.length(); ++i) {
            switch (entry.charAt(i)) {
                case 'a', 'e', 'i', 'o', 'u' -> vowels++;
            }

            if (i < entry.length() - 1 && entry.charAt(i) == entry.charAt(i + 1)) {
                doubles++;
            }

            for (String o : new String[] { "ab", "cd", "pq", "xy" }) {
                if (entry.contains(o)) {
                    offensive = true;
                    break;
                }
            }
        }

        return vowels >= 3 && doubles > 0 && !offensive;
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

        return pair > 0 && repeat > 0;
    }

    @Override
    public Long part1(List<String> input) {
        return input.stream().filter(this::isNiceString).count();
    }

    @Override
    public Long part2(List<String> input) {
        return input.stream().filter(this::isNiceStringNotRidiculous).count();
    }

}
