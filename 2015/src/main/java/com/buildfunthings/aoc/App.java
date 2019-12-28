package com.buildfunthings.aoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.days.Day01;


public class App {
    private static final Map<Integer, Day> DAYS;

    static {
        DAYS = new HashMap<>();
        DAYS.put(1, new Day01());
    }

    static List<String> loadInput(int day) {
        String filename = String.format("input-%02d.txt", day);

        try (BufferedReader r = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(filename)))) {
            return r.lines().collect(Collectors.toList());
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    public static void main(String[] args) {
        for (int day = 1; day <= 25; day++) {
            List<String> input = loadInput(day);
            for (int part = 1; part <= 2; part++) {
                String result;
                if (part == 1) {
                    result = DAYS.get(part).part1(input);
                } else {
                    result = DAYS.get(part).part2(input);
                }
                System.out.println("Day: " + day + " Part: " + part + ": " + result);
            }
        }

    }
}
