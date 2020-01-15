package com.buildfunthings.aoc.days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.buildfunthings.aoc.common.Day;

public class Day13 implements Day {
    private <T> void swap(T[] input, int a, int b) {
        T tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    public <T> List<T[]> permuteAllIterative(int n, T[] elements) {
        List<T[]> permutations = new ArrayList<>();
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = 0;
        }

        permutations.add(elements.clone());

        int i = 0;
        while (i < n) {
            if (indexes[i] < i) {
                swap(elements, i % 2 == 0 ? 0 : indexes[i], i);
                permutations.add(elements.clone());
                indexes[i]++;
                i = 0;
            } else {
                indexes[i] = 0;
                i++;
            }
        }

        return permutations;
    }

    // Map of who loves/hates whom
    Map<String, Map<String, Integer>> loveHate = new HashMap<>();
    // Maintain a list of guests
    List<String> guests = new ArrayList<>();
    
    public void processLoveHate(List<String> input) {
        /*
          0     1     2    3  4         5     6  7       8    9  10        
          Alice would gain 54 happiness units by sitting next to Bob.
          Alice would lose 81 happiness units by sitting next to Carol.
        */

        // Parse the instructios into our map
        for (String instruction : input) {
            // get rid of the . at the end
            String[] parts = instruction.substring(0, instruction.length() - 1).split(" ");
            Map<String, Integer> currentLoveHate = loveHate.getOrDefault(parts[0], new HashMap<>());
            Integer value = Integer.parseInt(parts[3]);
            currentLoveHate.put(parts[10], parts[2].equals("gain") ? value : -value);

            if (!guests.contains(parts[0]))
                guests.add(parts[0]);

            loveHate.put(parts[0], currentLoveHate);
        }

    }

    public Integer getChange(String ben, String jerry) {
        Integer change = 0;
        change += loveHate.getOrDefault(ben, new HashMap<>()).getOrDefault(jerry, 0);
        change += loveHate.getOrDefault(jerry, new HashMap<>()).getOrDefault(ben, 0);
        return change;
    }

	@Override
	public String part1(List<String> input) {
        processLoveHate(input);
        List<String[]> perms = permuteAllIterative(guests.size(), guests.toArray(new String[0]));

        int mostHappy = 0;
        for (String[] p : perms) {
            int happy = 0;
            for (int i = 0; i < p.length - 1; i++) {
                happy += loveHate.get(p[i]).get(p[i + 1]);
                happy += loveHate.get(p[i+1]).get(p[i]);
            }
            happy += loveHate.get(p[0]).get(p[p.length-1]);
            happy += loveHate.get(p[p.length - 1]).get(p[0]);
            
            if (happy > mostHappy)
                mostHappy = happy;
        }
    
		return String.valueOf(mostHappy);
	}

	@Override
	public String part2(List<String> input) {
        processLoveHate(input);
        guests.add("Arjen");
        List<String[]> perms = permuteAllIterative(guests.size(), guests.toArray(new String[0]));

        int mostHappy = 0;
        for (String[] p : perms) {
            int happy = 0;
            for (int i = 0; i < p.length - 1; i++) {
                happy += getChange(p[i], p[i+1]);
            }
            happy += getChange(p[0], p[p.length-1]);
            
            if (happy > mostHappy)
                mostHappy = happy;
        }
    
		return String.valueOf(mostHappy);
	}
    
}
