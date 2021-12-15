package nl.arjenwiersma.aoc.days;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;

import nl.arjenwiersma.aoc.common.Day;

public class Day08 implements Day<Integer> {

    @Override
    public Integer part1(List<String> input) {
        Map<Integer, Integer> freqs = new HashMap<>();

        for (String in : input) {
            String[] parts = in.split("\\|");
            String[] digits = parts[1].trim().split(" ");

            for (String d : digits) {
                freqs.merge(d.length(), 1, Integer::sum);
            }
        }


        return freqs.getOrDefault(2, 0) +
                freqs.getOrDefault(4, 0) +
                freqs.getOrDefault(3,0) +
                freqs.getOrDefault(7, 0);
    }


    public boolean containsSequence(String unknown, String known) {
        Set<Character> testfor = unknown.chars()
                .mapToObj(ch -> (char)ch)
                .collect(Collectors.toSet());

        return known.chars()
                .allMatch(ch -> testfor.contains((char) ch));

    }

    @Override
    public Integer part2(List<String> input) {
        int value = 0;
        for (String in : input) {
            String[] parts = in.split("\\|");
            String[] digits = parts[1].trim().split(" ");

            Map<Set<Character>, Integer> knownStr = new HashMap<>();
            Map<Integer, Set<Character>> knownLenghts = new HashMap<>();

            List<Set<Character>> allParts = Arrays.stream(parts[0].trim().split(" "))
                    .map(x -> x.chars()
                            .mapToObj(ch -> (char)ch)
                            .collect(Collectors.toSet())).collect(Collectors.toList());

            // NOTE: Map the known cases
            for (Set<Character> partSet : allParts) {
                int i = -1;
                switch (partSet.size()) {
                    case 2 -> i = 1;
                    case 3 -> i = 7;
                    case 4 -> i = 4;
                    case 7 -> i = 8;
                }
                if (i != -1) {
                    knownLenghts.put(i, partSet);
                    knownStr.put(partSet, i);
                }
            }

            // NOTE: combine 4 and 7 to get mask for 2 and 5
            Set<Character> fs = Sets.union(knownLenghts.get(4), knownLenghts.get(7));

            // NOTE: Map the unknown sequences
            for (Set<Character> partSet : allParts) {
                switch (partSet.size()) {
                    case 5 -> {
                        if (Sets.difference(knownLenghts.get(1),partSet).isEmpty()) {
                            knownStr.put(partSet, 3);
                        } else  {

                            int noMatch = Sets.difference(fs,partSet).size();
                            if (noMatch == 2) { // 2 en 5 gaat fout
                                knownStr.put(partSet, 2);
                            } else {
                                knownStr.put(partSet, 5);
                            }
                        }
                    }
                    case 6 -> {
                        if (Sets.difference(knownLenghts.get(4), partSet).isEmpty()) {
                            knownStr.put(partSet, 9);
                        } else if (Sets.difference(knownLenghts.get(1), partSet).isEmpty()) {
                            knownStr.put(partSet, 0);
                        } else {
                            knownStr.put(partSet, 6);
                        }
                    }

                    default -> {}
                }
            }

            // NOTE: Build the number
            StringBuilder sb = new StringBuilder();
            for (String d : digits) {
                Set<Character> partSet = d.chars()
                        .mapToObj(ch -> (char)ch)
                        .collect(Collectors.toSet());
                sb.append(knownStr.get(partSet));
            }
            value += Integer.parseInt(sb.toString());
        }

        return value;
    }

}
