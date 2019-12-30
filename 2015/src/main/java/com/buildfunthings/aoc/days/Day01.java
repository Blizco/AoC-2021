package com.buildfunthings.aoc.days;

import java.util.List;

import com.buildfunthings.aoc.common.Day;

public class Day01 implements Day {

    private int countFloors(String input) {
        int floor = 0;
        char[] chars = input.toCharArray();

        for (Character next : chars) {
            if (next.equals('(')) {
                ++floor;
            } else if (next.equals(')')) {
                --floor;
            }
        }
        return floor;
    }

    private int hitBasement(String input) {
        int floor = 0;
        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == '(') {
                ++floor;
            } else if (chars[i] == ')') {
                --floor;
            }

            if (floor == -1)
                return i + 1;
        }
        return floor;
    }

	@Override
	public String part1(List<String> input) {
		return String.valueOf(countFloors(input.get(0)));
	}

	@Override
	public String part2(List<String> input) {
		return String.valueOf(hitBasement(input.get(0)));
	}

}
