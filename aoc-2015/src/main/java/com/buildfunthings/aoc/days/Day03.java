package com.buildfunthings.aoc.days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.buildfunthings.aoc.common.Day;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

public class Day03 implements Day<Integer> {
	@AllArgsConstructor
	@ToString
	@EqualsAndHashCode
	class Position {
		int x, y;
	}

	private Map<Position, Integer> performSteps(List<String> steps) {
		Map<Position, Integer> locations = new HashMap<>();

		int x = 0, y = 0;

		for (String step : steps) {
			switch (step) {
				case "<" -> --x;
				case ">" -> ++x;
				case "^" -> ++y;
				case "v" -> --y;
			}

			Position p = new Position(x, y);
			Integer currentValue = locations.get(p);
			locations.put(p, (currentValue == null ? 1 : currentValue++));
		}

		return locations;
	}

	@Override
	public Integer part1(List<String> input) {
		List<String> tokens = new ArrayList<>(Arrays.asList(input.get(0).split("")));

		Map<Position, Integer> locations = new HashMap<>();
		locations.put(new Position(0, 0), 1);

		locations.putAll(performSteps(tokens));

		return locations.size();
	}

	@Override
	public Integer part2(List<String> input) {
		List<String> tokens = new ArrayList<>(Arrays.asList(input.get(0).split("")));

		Map<Position, Integer> locations = new HashMap<>();
		locations.put(new Position(0, 0), 1);

		List<String> santaInstructions = IntStream.range(0, tokens.size()).filter(n -> n % 2 == 0).mapToObj(tokens::get)
				.collect(Collectors.toList());

		List<String> roboInstructions = IntStream.range(0, tokens.size()).filter(n -> n % 2 != 0).mapToObj(tokens::get)
				.collect(Collectors.toList());

		locations.putAll(performSteps(santaInstructions));
		locations.putAll(performSteps(roboInstructions));

		return locations.size();
	}

}
