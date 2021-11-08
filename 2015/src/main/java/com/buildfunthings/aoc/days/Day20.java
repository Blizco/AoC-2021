package com.buildfunthings.aoc.days;

import java.util.List;

import com.buildfunthings.aoc.common.Day;

public class Day20 implements Day<Integer> {
    private static final int SIZE = 1000000;
    
    @Override
    public Integer part1(List<String> input) {
        final int TARGET = Integer.valueOf(input.get(0));
        int[] houses = new int[SIZE];
        int answer = 0;

        for (int elf = 1; elf < SIZE; elf++) {
            for (int visited = elf; visited < SIZE; visited += elf) {
                houses[visited] += elf * 10;
            }
        }

        for (int i = 0; i < SIZE; i++) {
            if (houses[i] >= TARGET) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    @Override
    public Integer part2(List<String> input) {
        final int TARGET = Integer.valueOf(input.get(0));
        int[] houses = new int[SIZE];
        int answer = 0;

        for (int elf = 1; elf < SIZE; elf++) {
            for (int visited = elf; (visited <= elf*50 && visited < SIZE); visited += elf) {
                houses[visited] += elf * 11;
            }
        }

        for (int i = 0; i < SIZE; i++) {
            if (houses[i] >= TARGET) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    
}
