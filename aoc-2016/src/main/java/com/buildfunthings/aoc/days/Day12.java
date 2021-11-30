package com.buildfunthings.aoc.days;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.buildfunthings.aoc.common.Day;

public class Day12 implements Day<Integer> {

    Map<String, Integer> registers = new HashMap<>();
    

    private void runProgram(List<String> input) {
        for (int i = 0; i < input.size(); ) {
            String[] parts = input.get(i).split(" ");
            switch (parts[0]) {
            case "cpy" -> {
                try {
                    Integer value = Integer.parseInt(parts[1]);
                    registers.put(parts[2], value);
                } catch (Exception ex) {
                    Integer value = registers.get(parts[1]);
                    registers.put(parts[2], value);
                }
                i++;
            }
            case "inc" -> {
                Integer x = registers.get(parts[1]);
                registers.put(parts[1], ++x);
                i++;
            }
            case "dec" -> {
                Integer x = registers.get(parts[1]);
                registers.put(parts[1], --x);
                i++;
            }
            case "jnz" -> {
                try {
                    Integer value = Integer.parseInt(parts[1]);
                    if (value != 0) {
                        i += Integer.parseInt(parts[2]);
                    } else {
                        i++;
                    }
                } catch (Exception ex) {
                    Integer x = registers.get(parts[1]);
                    if (x != null && x != 0) {
                        i += Integer.parseInt(parts[2]);
                    } else {
                        i++;
                    }
                }
            }
            }
        }
    }

    @Override
    public Integer part1(List<String> input) {

        runProgram(input);
        
        return registers.get("a");
    }

    @Override
    public Integer part2(List<String> input) {
        registers.put("c", 1);
        runProgram(input);
        
        return registers.get("a");
    }
    
}
