package com.buildfunthings.aoc.days;

import java.util.List;

import com.buildfunthings.aoc.common.Day;

import lombok.AllArgsConstructor;

public class Day08 implements Day<Integer> {
    public int width, height;

    public int[][] grid;

    public Day08(int width, int height) {
        this.width = width;
        this.height = height;

        grid = new int[height][width];
    }

    public void printGrid() {
        for (int[] row : grid) {
            for (int col : row) {
                System.out.print(col == 0 ? "." : "#");
            }
            System.out.println();
        }
    }

    public void applyRect(int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int z = 0; z < y; z++) {
                grid[z][i] = 1;
            }
        }
    }

    public void applyRotateColumn(int x, int steps) {
        int[] current = new int[height];
        for (int i = 0; i < height; i++) {
            current[i] = grid[i][x];
        }
        for (int i = 0; i < height; i++) {
            int newRow = (i + steps) % height;
            grid[newRow][x] = current[i];
        }
    }

    public void applyRotateRow(int y, int steps) {
        int[] current = grid[y].clone();

        for (int i = 0; i < width; i++) {
            int newCol = (i + steps) % width;
            grid[y][newCol] = current[i];
        }
    }
    
    @Override
    public Integer part1(List<String> input) {
        for (String instr : input) {
            if (instr.startsWith("rect")) {
                String coord = instr.substring(5);
                String[] parts = coord.split("x");
                applyRect(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            } else if (instr.startsWith("rotate row")) {
                String coord = instr.substring(13);
                String[] parts = coord.split(" by ");
                applyRotateRow(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            } else if (instr.startsWith("rotate column")) {
                String coord = instr.substring(16);
                String[] parts = coord.split(" by ");
                applyRotateColumn(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            } else {
                System.out.println("UNHANDLED CASE");
            }

        }
        //System.out.println();
        //printGrid();
        return countLitCells();
    }

    private Integer countLitCells() {
        int count = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (grid[y][x] == 1)
                    count++;
            }
        }
        return count;
    }

    @Override
    public Integer part2(List<String> input) {
        return 0;
    }

    
}
