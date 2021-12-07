package nl.arjenwiersma.aoc.days;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import nl.arjenwiersma.aoc.common.Day;

public class Day07 implements Day<Integer> {
	private int calculateFuel(int[] crabs, Function<Integer, Integer> f) {
		int maxCrab = Arrays.stream(crabs).max().getAsInt();
        int minFuel = Integer.MAX_VALUE;

        for (int i = 0; i < maxCrab; i++) {
            int fuel = 0;
            for (int c : crabs) {
                int maxC = Math.max(c,i);
                int minC = Math.min(c,i);

                int diff = maxC - minC;
                fuel +=  f.apply(diff);
            }
            minFuel = Math.min(minFuel, fuel);
        }
		return minFuel;
	}

    @Override
    public Integer part1(List<String> input) {
        int[] crabs = Arrays.stream(input.get(0).split(",")).mapToInt(Integer::parseInt).toArray();

        return calculateFuel(crabs, (a -> a));        
    }

    @Override
    public Integer part2(List<String> input) {
        int[] crabs = Arrays.stream(input.get(0).split(",")).mapToInt(Integer::parseInt).toArray();

        return calculateFuel(crabs, (a -> ((a * (a + 1)) / 2)));
    }
}
