package com.buildfunthings.aoc.days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.buildfunthings.aoc.common.Day;

public class Day03 implements Day<Integer> {

    @Override
    public Integer part1(List<String> input) {
        int valid = 0;
        for (String sides : input) {
            Integer[] parts = Arrays.stream(sides.trim().split("\\s+")).map(String::trim).map(Integer::parseInt)
                    .toArray(Integer[]::new);

            if (parts[0] + parts[1] > parts[2] && parts[0] + parts[2] > parts[1] && parts[1] + parts[2] > parts[0]) {
                valid++;
            }
        }
        return valid;
    }

    @Override
    public Integer part2(List<String> input) {
        int valid = 0;
        List<Integer> c1 = new ArrayList<>();
        List<Integer> c2 = new ArrayList<>();
        List<Integer> c3 = new ArrayList<>();
        for (String sides : input) {
            Integer[] parts = Arrays.stream(sides.trim().split("\\s+")).map(String::trim).map(Integer::parseInt)
                    .toArray(Integer[]::new);

            c1.add(parts[0]);
            c2.add(parts[1]);
            c3.add(parts[2]);
        }

        List<Integer> all = new ArrayList<>();
        all.addAll(c1);
        all.addAll(c2);
        all.addAll(c3);

        for (int i = 0; i < all.size(); i += 3) {
            if (all.get(i) + all.get(i + 1) > all.get(i + 2) && all.get(i) + all.get(i + 2) > all.get(i + 1)
                    && all.get(i + 1) + all.get(i + 2) > all.get(i)) {
                valid++;
            }
        }

        return valid;
    }

}
