package com.buildfunthings.aoc.days;

import java.util.Arrays;
import java.util.List;

import com.buildfunthings.aoc.common.Day;

public class Day18 implements Day {

    int[][] createGrid(int size) {
        int[][] grid = new int[size][size];
        for (int row = 0; row < size; row++) {
            Arrays.fill(grid[row], 0);
        }
        return grid;
    }

    void setGridState(int[][] grid, List<String> state) {
        for (int i = 0; i < state.size(); i++) {
            int[] chars = state.get(i).chars().toArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '#') {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = 0;
                }
            }
        }
    }

    void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                switch (grid[i][j]) {
                case 1:
                    System.out.print("#");
                    break;
                default:
                    System.out.print(".");
                }
            }
            System.out.print("\n");
        }

    }

    int[][] evolveGrid(int[][] grid, int part) {
        int[][] evolved = new int[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int on = 0;
                // cycle neighbors
                for (int row = Math.max(0, i - 1); row <= Math.min(grid.length - 1, i + 1); row++) {
                    for (int col = Math.max(0, j - 1); col <= Math.min(grid.length - 1, j + 1); col++) {
                        if (row != i || col != j) {

                            switch (grid[row][col]) {
                            case 1:
                                ++on;
                                break;
                            }
                        }
                    }
                }

                if (grid[i][j] == 1 && (on == 2 || on == 3)) {
                    evolved[i][j] = 1;
                } else if (grid[i][j] == 0 && on == 3) {
                    evolved[i][j] = 1;
                } else {
                    evolved[i][j] = 0;
                }

                if (part == 2) {
                    evolved[0][0] = 1;
                    evolved[0][evolved.length-1] = 1;
                    evolved[evolved.length-1][0] = 1;
                    evolved[evolved.length-1][evolved.length-1] = 1;                    
                }
            }
        }
        return evolved;
    }

    int countOn(int[][] grid) {
        int on = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1)
                    ++on;
            }
        }
        return on;
    }

    @Override
    public String part1(List<String> input) {
        int[][] grid = createGrid(100);
        setGridState(grid, input);
        // printGrid(grid);
        for (int i = 0; i < 100; i++) {
            // System.out.println();
            int[][] ev1 = evolveGrid(grid,1);
            // printGrid(ev1);
            grid = ev1;
        }

        return String.valueOf(countOn(grid));
    }

    @Override
    public String part2(List<String> input) {
        int[][] grid = createGrid(100);
        setGridState(grid, input);
        // printGrid(grid);
        for (int i = 0; i < 100; i++) {
            // System.out.println();
            int[][] ev1 = evolveGrid(grid,2);
            // printGrid(ev1);
            grid = ev1;
        }

        return String.valueOf(countOn(grid));
    }

}
