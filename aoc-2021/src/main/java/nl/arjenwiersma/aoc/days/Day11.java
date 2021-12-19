package nl.arjenwiersma.aoc.days;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import nl.arjenwiersma.aoc.common.Day;
import nl.arjenwiersma.aoc.utils.Coord;

public class Day11 implements Day<Long> {
    private Coord[] getNeighbors(Coord c, int width, int height) {
        // row / col
        int[][] delta = new int[][] {
                {-1,-1}, {-1,0},{-1,1},
                {0,-1},         {0,1},
                {1,-1},  {1,0} ,{1,1}
        };

        List<Coord> lc = new ArrayList<>();

        for (int[] d : delta) {
            Coord n = new Coord(c.x() + d[1], c.y() + d[0]);

            if (n.x() >= 0 && n.x() < width && n.y() >= 0 && n.y() < height) {
                lc.add(n);
            }
        }

        return lc.toArray(new Coord[0]);
    }

    public long playGame(List<String> input,  int iters, boolean returnFirstAllFlash) {
        int height = input.size();
        int width = input.get(0).length();
        int[][] field = new int[height][width];
        long result = 0L;

        int row = 0;
        for (String in : input) {
            field[row++] = Arrays.stream(in.split("")).mapToInt(Integer::parseInt).toArray();
        }

        for (int iter = 1; iter <= iters; iter++) {
            // System.out.println("Iteration " + iter);
            // printGrid(field);
            // System.out.println();

            // increment field
            for (int y = 0; y < field.length; y++) {
                for (int x = 0; x < field[y].length; x++) {
                    field[y][x]++;
                }
            }

            List<Coord> seen = new ArrayList<>();
            Deque<Coord> flashed = new ArrayDeque<>();

            for (int y = 0; y < field.length; y++) {
                for (int x = 0; x < field[y].length; x++) {
                    if (field[y][x] > 9) {
                        flashed.add(new Coord(x, y));
                    }
                }
            }
            // Q contains all flashed points
            // System.out.println("Coords to flash");
            // flashed.stream().forEach(System.out::print);
            // System.out.println("\nCurrent field");
            // printGrid(field);

            // while new flashed coords exist
            while (!flashed.isEmpty()) {
                Coord f = flashed.pop();
                if (seen.contains(f))
                    continue; // do not flash it if it was already flashed.
                seen.add(f);
                field[f.y()][f.x()] = 0;

                // System.out.println("Going to flash this one and increase all neighbors: " + f);

                Coord[] n = getNeighbors(f, width, height);
                // System.out.println("Increasing: " + Arrays.toString(n));

                for (Coord cn : n) {
                    if (!seen.contains(cn)) {
                        field[cn.y()][cn.x()]++;
                        if (field[cn.y()][cn.x()] > 9)
                            flashed.add(cn);
                    }
                }
                // System.out.println("After increasing all neighbords");
                // printGrid(field);
            }
            // System.out.println("Finished with all flashes");
            // printGrid(field);
            // System.out.println("Flashed in this sequence: " + seen.size());
            result += seen.size();

            if (returnFirstAllFlash) {
                long notFlashed = Arrays.stream(field).flatMapToInt(Arrays::stream).filter(x -> x != 0).count();
                if (notFlashed == 0)
                    return iter;
            }
        }
        //GridUtils.printGrid(field);
        return result;
    }

    @Override
    public Long part1(List<String> input) {
        return playGame(input, 100, false);
    }



    @Override
    public Long part2(List<String> input) {
        return playGame(input, Integer.MAX_VALUE, true);
    }

}
