package nl.arjenwiersma.aoc.days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import nl.arjenwiersma.aoc.common.Day;

public class Day09 implements Day<Integer> {

    public int[] neighborIndexes(int width, int height, int pos) {
        // determine position in the grid
        // for each NESW determine position in array
        // if outside of array, do not add it to the list
        // return the list
        int space = pos % width;
        List<Integer> neighbors = new ArrayList<>();

        if (space - 1 >= 0) {
            neighbors.add(pos - 1);
        }
        if (pos - (width) >= 0) {
            neighbors.add(pos-width);
        }
        if (space + 1 < width) {
            neighbors.add(pos + 1);
        }
        if ((pos + width ) < (width*height)) {
            neighbors.add(pos+width);
        }

        return neighbors.stream().mapToInt(Integer::valueOf).toArray();
    }

    private List<Integer> getLowPoints(List<String> input, int width, int height, int[] grid) {
        int pos = 0;
        for (String in : input) {
            for (int n : Arrays.stream(in.split("")).mapToInt(Integer::parseInt).toArray()) {
                grid[pos++] = n;
            }
        }

        List<Integer> lows = new ArrayList<>();
        for (int n = 0; n < (width * height); n++) {
            int[] ns = neighborIndexes(width, height, n);

            //Arrays.stream(ns).forEach(System.out::println);
            boolean lower = true;
            for (int o = 0; o < ns.length; o++) {
                //System.out.println("Cell " + n + " value " + grid[n] + " vs " + grid[ns[o]]);
                if (grid[n] >= grid[ns[o]]) {
                    lower = false;
                }
                //System.out.println("Lower: " + lower);
            }
            if (lower) {
                //System.out.println("Entry: " + n + " value " + grid[n] + " is lower then all neighbors");
                lows.add(n);
            }
        }

        return lows;
    }

    @Override
    public Integer part1(List<String> input) {
        int width = input.get(0).length();
        int height = input.size();

        int[] grid = new int[width * height];

        List<Integer> lowPoints = getLowPoints(input, width, height, grid);

        return lowPoints.stream().mapToInt(x->grid[x]+1).sum();
    }


    @Override
    public Integer part2(List<String> input) {
        int width = input.get(0).length();
        int height = input.size();

        int[] grid = new int[width * height];

        List<Integer> lowPoints = getLowPoints(input, width, height, grid);


        List<Integer> largest = new ArrayList<>();
        for (Integer lp : lowPoints) {
            List<Integer> bassin = new ArrayList<>(); // list of seen
            Queue<Integer> todo = new PriorityQueue<>();// todo list
            todo.add(lp);

            while (!todo.isEmpty()) {
                int n = todo.poll();
                if (!bassin.contains(n))
                    bassin.add(n);
                // given a low point, find its neighbors
                int[] neighbors = neighborIndexes(width, height, n);
                for (int i : neighbors) {
                    // for each neighbor, check to see if the value is 9, drop the neighbor, otherwise add to list of bassin slots
                    if (!bassin.contains(i) && grid[i] != 9) {
                        todo.add(i);
                    }
                }
            }

            largest.add(bassin.size());
        }

        List<Integer> items = largest.stream().sorted(Comparator.reverseOrder()).toList();
        return items.get(0) * items.get(1) * items.get(2);
    }

}
