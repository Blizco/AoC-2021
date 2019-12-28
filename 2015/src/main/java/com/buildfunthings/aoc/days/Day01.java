package com.buildfunthings.aoc.days;

import java.util.List;

import com.buildfunthings.aoc.common.Day;

public class Day01 implements Day {
	private int countFloors(String input) {
		int floor = 0;
		char[] tokens = input.toCharArray();
		for (Character next : tokens) {

			if (next.equals('(')) {
				++floor;
			} else if (next.equals(')')) {
				--floor;
			} else {
				System.out.println("Found an unexpected token: " + next);
			}
		}

		return floor;
	}

	private int hitBasement(String input) {
		int floor = 0;
		int pos = 1;

		char[] tokens = input.toCharArray();
		for (Character next : tokens) {
			if (next.equals('(')) {
				++floor;
			} else if (next.equals(')')) {
				--floor;
			} else {
				System.out.println("Found an unexpected token: " + next);
			}

			if (floor == -1)
				return pos;

			++pos;
		}

		return -1;
	}

	@Override
	public String part1(List<String> input) {
		// in this case there should be only 1 line

		return String.valueOf(countFloors(input.get(0)));
	}

	@Override
	public String part2(List<String> input) {
		return String.valueOf(hitBasement(input.get(0)));
	}
}
