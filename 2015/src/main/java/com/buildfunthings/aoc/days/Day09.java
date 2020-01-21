package com.buildfunthings.aoc.days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import com.buildfunthings.aoc.common.Day;

public class Day09 implements Day {
    private void swap(String[] input, int a, int b) {
        String tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private List<String[]> permuteIterative(int n, String[] elements) {
        List<String[]> permutations = new ArrayList<>();
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = 0;
        }

        permutations.add(elements.clone());

        int i = 0;
        while (i < n) {
            if (indexes[i] < i) {
                swap(elements, i % 2 == 0 ? 0 : indexes[i], i);
                permutations.add(elements.clone());
                indexes[i]++;
                i = 0;
            } else {
                indexes[i] = 0;
                i++;
            }
        }

        return permutations;
    }

    Map<String, Map<String, Integer>> _paths = new HashMap<>();
    List<String> _cities = new ArrayList<>();

    void storeCities(String from, String to) {
        if (!_cities.contains(from))
            _cities.add(from);
        if (!_cities.contains(to))
            _cities.add(to);
    }

    void addConnection(String from, String to, int distance) {
        Map<String, Integer> fromConn = _paths.getOrDefault(from, new HashMap<String, Integer>());
        Map<String, Integer> toConn = _paths.getOrDefault(to, new HashMap<String, Integer>());

        fromConn.put(to, distance);
        toConn.put(from, distance);

        _paths.put(from, fromConn);
        _paths.put(to, toConn);
    }
    
    public List<String[]> getPermutations(List<String> input) {
        for (String s : input) {
            String[] parts = s.split(" ");
            // Faerun to Tristram = 65
            storeCities(parts[0], parts[2]);

            addConnection(parts[0], parts[2], Integer.parseInt(parts[4]));
        }

        return permuteIterative(_cities.size(), _cities.toArray(new String[0]));
    }
    
    
	@Override
	public String part1(List<String> input) {
        _cities.clear();
        _paths.clear();

        List<String[]> permutations = getPermutations(input);

        int shortest = Integer.MAX_VALUE;
        
        for (String[] permutation : permutations) {
            int current = 0;
            for (int i = 0; i < permutation.length-1; i++) {
                String from = permutation[i];
                String to = permutation[i + 1];

                int distance = _paths.get(from).get(to);
                current += distance;
            }

            shortest = Math.min(current, shortest);
        }
        
		return String.valueOf(shortest);
	}

	@Override
	public String part2(List<String> input) {
        _cities.clear();
        _paths.clear();

        List<String[]> permutations = getPermutations(input);

        int shortest = Integer.MAX_VALUE;

        return String.valueOf(
        permutations.stream()
            .mapToInt(p -> IntStream.range(0, p.length-1)
                      .mapToObj(idxFrom -> _paths.get(p[idxFrom]).get(p[idxFrom + 1]))
                      .mapToInt(Integer::intValue)
                        .sum())
                .max().getAsInt()
                              );
	}

    public static void main(String[] args) {
        Day09 d = new Day09();
        String[] input = new String[] { "A", "B", "C", "D" };
        List<String[]> perms = d.permuteIterative(input.length, input);

        for (String[] p : perms) {
            System.out.println(p[0] + p[1] + p[2] + p[3]);
        }
    }
    
}
