package com.buildfunthings.aoc.days;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.buildfunthings.aoc.common.Day;

public class Day17 implements Day {

    int[][] combinations(int[] input) {
        int len = input.length;

        // As we use a 32 value to store, can not be longer
        // then 31
        if (len > 31)
            throw new IllegalArgumentException();

        int numCombos = (1 << len) - 1;
        int[][] combos = new int[numCombos][];

        // i will hold the number of combinations
        // starting at 0 would include an empty set
        for (int i = 1; i <= numCombos; i++) {
            // Count the number of bits in i that are set
            int[] combo = new int[Integer.bitCount(i)];

            // loop over the input array to create combos
            for (int j = 0, x = 0; j < len; j++) {
                // if the bit is set, add the input value to
                // the combination
                if ((i & (1 << j)) > 0)
                    combo[x++] = input[j];
            }

            // Add the combination to the output array
            // Remember we started at 1, so subtract it
            combos[i - 1] = combo;
        }

        return combos;
    }

    long countOfCombinedValue(int[][] combos, int targetValue) {
        return Arrays.stream(combos).mapToInt(a -> Arrays.stream(a).sum()).filter(s -> s == targetValue).count();
    }

    long countOfContainersToSpare(int[][] combos, int targetValue) {
        // Grab the combinations that add up to a value
        Object[] intsOfValue =  Arrays.stream(combos).filter(a -> Arrays.stream(a).sum() == targetValue).toArray();
        // Get the minimum length of the arrays
        int minSize = Arrays.stream(intsOfValue).mapToInt(a -> ((int[]) a).length).min().getAsInt();
        // count the number of combinations of that size
        return Arrays.stream(intsOfValue).filter(a -> ((int[]) a).length == minSize).count();

    }
    
	@Override
	public String part1(List<String> input) {
        int[] in = input.stream().mapToInt(s -> Integer.parseInt(s)).toArray();
        int[][] combos = combinations(in);
        
		return String.valueOf(countOfCombinedValue(combos, 150));
	}

	@Override
	public String part2(List<String> input) {
        int[] in = input.stream().mapToInt(s -> Integer.parseInt(s)).toArray();
        int[][] combos = combinations(in);

		return String.valueOf(countOfContainersToSpare(combos, 150));
	}
    
}
