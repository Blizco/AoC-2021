package com.buildfunthings.aoc.days;

import java.util.Arrays;
import java.util.List;

import com.buildfunthings.aoc.common.Day;

public class Day02 implements Day<Integer> {

    private int calculateWrapping(String[] parts) {
        int[] p = Arrays.stream(parts).mapToInt(Integer::valueOf).toArray();

        int[] dim = new int[3];
        // 2*l*w + 2*w*h + 2*h*l
        dim[0] = p[0] * p[1];
        dim[1] = p[1] * p[2];
        dim[2] = p[2] * p[0];

        Arrays.sort(dim);

        return Arrays.stream(dim).map(entry -> 2 * entry).sum() + dim[0];
    }

    private int calculateRibbon(String[] parts) {
        int[] p = Arrays.stream(parts).mapToInt(Integer::valueOf).toArray();

        Arrays.sort(p);

        return 2 * p[0] + 2 * p[1] + p[0] * p[1] * p[2];
    }

    private int processEntry(List<String> input, int part) {
        int order = 0;

        for (String present : input) {
            String[] parts = present.split("x");
            if (part == 1)
                order += calculateWrapping(parts);
            else if (part == 2)
                order += calculateRibbon(parts);
        }

        return order;
    }

    @Override
    public Integer part1(List<String> input) {
        return processEntry(input, 1);
    }

    @Override
    public Integer part2(List<String> input) {

        return processEntry(input, 2);
    }

}
