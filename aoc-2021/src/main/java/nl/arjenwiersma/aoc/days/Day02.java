package nl.arjenwiersma.aoc.days;

import nl.arjenwiersma.aoc.common.Day;

import java.util.List;

public class Day02 implements Day<Long> {

    @Override
    public Long part1(List<String> input) {
        int x = 0, y = 0;

        for (String in : input) {
            String[] parts = in.split(" ");
            final int value = Integer.parseInt(parts[1]);
            switch(parts[0]) {
                case "forward" -> x += value;
                case "up" -> y -= value;
                case "down" -> y += value;
            }
        }

        return (long) x * y;
    }

    @Override
    public Long part2(List<String> input) {
        int x = 0, depth = 0, aim=0;

        for (String in : input) {
            String[] parts = in.split(" ");
            final int value = Integer.parseInt(parts[1]);
            switch(parts[0]) {
                case "forward" -> {
                    x += value;
                    depth += (aim * value);
                }
                case "up" -> {
                    aim -= value;
                }
                case "down" -> {
                    aim += value;
                }
            }
        }

        return (long) x * depth;
    }
}