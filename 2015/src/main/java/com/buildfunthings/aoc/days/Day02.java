package com.buildfunthings.aoc.days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.buildfunthings.aoc.common.Day;

public class Day02 implements Day {

    class Result {
        long paperNeeded;
        long ribbonLength;
    }

    Result calculateWrapping(String[] parts) {
        int[] p = Arrays.stream(parts).mapToInt(e -> Integer.valueOf(e)).toArray();

        // Calculate the dimensions
        int[] dim = new int[3];
        dim[0] = p[0] * p[1];
        dim[1] = p[1] * p[2];
        dim[2] = p[2] * p[0];

        // Setup a return structure
        Result res = new Result();

        // Part 1: wrapping needed dimensions*2 + smallest side
        Arrays.sort(dim);
        res.paperNeeded = Arrays.stream(dim).mapToLong(entry -> entry*2).sum() + dim[0];

        Arrays.sort(p);
        res.ribbonLength = 2 * p[0] + 2 * p[1] + p[0] * p[1] * p[2];

        return res;
    }

    List<Result> processList(List<String> input) {
        List<Result> res = new ArrayList<>();

        for (String present : input) {
            String[] parts = present.split("x");

            res.add(calculateWrapping(parts));
        }

        return res;
    }

    @Override
    public String part1(List<String> input) {
        List<Result> res = processList(input);
        long order = res.stream().mapToLong(entry -> entry.paperNeeded).sum();
        return String.valueOf(order);
    }

    @Override
    public String part2(List<String> input) {
        List<Result> res = processList(input);
        long order = res.stream().mapToLong(entry -> entry.ribbonLength).sum();
        return String.valueOf(order);
    }

}
