package com.buildfunthings.aoc.days;

import java.util.List;

import com.buildfunthings.aoc.common.Day;

import lombok.ToString;

public class Day06 implements Day<Integer> {
    enum OPERATION {
        TOGGLE, TURN_ON, TURN_OFF
    }

    @ToString
    class Instruction {
        OPERATION op;
        int startX;
        int startY;
        int endX;
        int endY;

        void setStart(String[] pos) {
            startX = Integer.valueOf(pos[0]);
            startY = Integer.valueOf(pos[1]);
        }

        void setEnd(String[] pos) {
            endX = Integer.valueOf(pos[0]);
            endY = Integer.valueOf(pos[1]);
        }
    }

    Instruction parseInstruction(String instruction) {
        Instruction step = new Instruction();
        String[] parts = instruction.split(" ");

        int pos = 0;
        if (parts[pos].equals("turn"))
            pos++;

        switch (parts[pos]) {
        case "on":
            step.op = OPERATION.TURN_ON;
            break;
        case "off":
            step.op = OPERATION.TURN_OFF;
            break;
        case "toggle":
            step.op = OPERATION.TOGGLE;
            break;
        }

        pos++;

        step.setStart(parts[pos].split(","));
        pos += 2;
        step.setEnd(parts[pos].split(","));

        return step;
    }

    void applyInstruction(Instruction step, int[][] grid) {
        for (int x = step.startX; x <= step.endX; x++) {
            for (int y = step.startY; y <= step.endY; y++) {
                switch (step.op) {
                case TOGGLE:
                    grid[x][y] = (grid[x][y] == 1 ? 0 : 1);
                    break;
                case TURN_ON:
                    grid[x][y] = 1;
                    break;
                case TURN_OFF:
                    grid[x][y] = 0;
                    break;
                }
            }
        }
    }

    void applyInstruction2(Instruction step, int[][] grid) {
        for (int x = step.startX; x <= step.endX; x++) {
            for (int y = step.startY; y <= step.endY; y++) {
                switch (step.op) {
                case TOGGLE:
                    grid[x][y] += 2;
                    break;
                case TURN_ON:
                    grid[x][y]++;
                    break;
                case TURN_OFF:
                    grid[x][y]--;
                    if (grid[x][y] < 0)
                        grid[x][y] = 0;
                    break;
                }
            }
        }
    }

    int sumLights(int[][] grid) {
        int on = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                on += grid[x][y];
            }
        }
        return on;
    }
    
    @Override
    public Integer part1(List<String> input) {
        int[][] grid = new int[1000][1000];

        for (String in : input) {
            applyInstruction(parseInstruction(in), grid);
        }
        
        return sumLights(grid);
    }

    @Override
    public Integer part2(List<String> input) {
        int[][] grid = new int[1000][1000];

        for (String in : input) {
            applyInstruction2(parseInstruction(in), grid);
        }
        
        return sumLights(grid);
    }

}
