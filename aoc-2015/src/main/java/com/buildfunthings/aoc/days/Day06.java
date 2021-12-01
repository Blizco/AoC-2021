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
            startX = Integer.parseInt(pos[0]);
            startY = Integer.parseInt(pos[1]);
        }

        void setEnd(String[] pos) {
            endX = Integer.parseInt(pos[0]);
            endY = Integer.parseInt(pos[1]);
        }
    }

    Instruction parseInstruction(String instruction) {
        Instruction step = new Instruction();
        String[] parts = instruction.split(" ");

        int pos = 0;
        if (parts[pos].equals("turn"))
            pos++;

        switch (parts[pos]) {
            case "on" -> step.op = OPERATION.TURN_ON;
            case "off" -> step.op = OPERATION.TURN_OFF;
            case "toggle" -> step.op = OPERATION.TOGGLE;
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
                    case TOGGLE -> grid[x][y] = (grid[x][y] == 1 ? 0 : 1);
                    case TURN_ON -> grid[x][y] = 1;
                    case TURN_OFF -> grid[x][y] = 0;
                }
            }
        }
    }

    void applyInstruction2(Instruction step, int[][] grid) {
        for (int x = step.startX; x <= step.endX; x++) {
            for (int y = step.startY; y <= step.endY; y++) {
                switch (step.op) {
                    case TOGGLE -> grid[x][y] += 2;
                    case TURN_ON -> grid[x][y]++;
                    case TURN_OFF -> {
                        grid[x][y]--;
                        if (grid[x][y] < 0)
                            grid[x][y] = 0;
                    }
                }
            }
        }
    }

    int sumLights(int[][] grid) {
        int on = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                on = on + anInt;
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
