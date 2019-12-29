package com.buildfunthings.aoc.days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.buildfunthings.aoc.common.Day;

public class Day03 implements Day {
    class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getEnclosingInstance().hashCode();
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Position other = (Position) obj;
            if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
                return false;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }

        private Day03 getEnclosingInstance() {
            return Day03.this;
        }
    }

    public Map<Position, Integer> performSteps(List<String> steps) {
        Map<Position, Integer> locations = new HashMap<>();

        int x = 0;
        int y = 0;

        for (int i = 0; i < steps.size(); i++) {
            char c = steps.get(i).charAt(0);
            switch (c) {
            case '<':
                --x;
                break;
            case '>':
                ++x;
                break;
            case '^':
                ++y;
                break;
            case 'v':
                --y;
                break;
            }

            Position p = new Position(x, y);
            Integer currentValue = locations.get(p);
            locations.put(p, (currentValue == null ? 1 : currentValue++));
        }

        return locations;
    }

    @Override
    public String part1(List<String> input) {
        // char[] tokens = input.get(0).toCharArray();
        List<String> tokens = new ArrayList<String>(Arrays.asList(input.get(0).split("")));
        // Infinite 2 dimensional array
        Map<Position, Integer> locations = new HashMap<>();
        locations.put(new Position(0, 0), 1);

        locations.putAll(performSteps(tokens));
        return String.valueOf(locations.size());
    }

    @Override
    public String part2(List<String> input) {
        List<String> tokens = new ArrayList<String>(Arrays.asList(input.get(0).split("")));

        // Infinite 2 dimensional array
        Map<Position, Integer> locations = new HashMap<>();
        locations.put(new Position(0, 0), 1);

        List<String> santaInstructions = IntStream.range(0, tokens.size()).filter(n -> n % 2 == 0).mapToObj(tokens::get)
                .collect(Collectors.toList());

        List<String> robotInstructions = IntStream.range(0, tokens.size()).filter(n -> n % 2 == 1).mapToObj(tokens::get)
                .collect(Collectors.toList());

        locations.putAll(performSteps(santaInstructions));
        locations.putAll(performSteps(robotInstructions));

        return String.valueOf(locations.size());
    }

}
