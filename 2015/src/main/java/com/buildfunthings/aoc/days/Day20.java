package com.buildfunthings.aoc.days;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.buildfunthings.aoc.common.Day;

public class Day20 implements Day<Integer> {
    private static final int SIZE = 1000000;
    private static final int ELVES = 100000;

    /*
      Alt
      IntStream.range(0, 100).filter(x -> x % 3 == 0); //107,566 ns/op [Average]

      generate houses per elf (max target/10)

      update house list 
      
     */
    
    @Override
    public Integer part1(List<String> input) {
        final int target = Integer.valueOf(input.get(0));
        Map<Integer, Integer> houses = new HashMap<>();

        for (int elf = 1; elf < target / 10 / 4; elf++){
            for (int house = 1; house < target / 10 / 4; house++) {
                if (house % elf == 0) {
                    Integer i = houses.getOrDefault(house, 0);

                    houses.put(Integer.valueOf(house), i + (elf * 10));
                }
            }
        }

        Map<Integer, Integer> bigger = houses.entrySet().stream().filter(x -> x.getValue() >= target).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        return bigger.keySet().stream().min(Integer::compare).get();
    }

    public Integer naivepart1(List<String> input) {
        int target = Integer.valueOf(input.get(0));
        int presents[] = new int[SIZE];
        System.out.println("Searching for: " + target);
        for (int house = 1; house < SIZE; house++) {
            // get every nth from the list and add 10
            for (int elf = 1; elf < (target / 10); elf++) {
                if ( house % elf == 0) {
                    presents[house] += elf * 10;
                }
            }
        }

        for (int house = 1; house < SIZE; house++) {
            if (presents[house] >= target) {
                return house;
            }
        }
        return 0;
    }

    @Override
    public Integer part2(List<String> input) {
        return null;
    }

    
}
