package com.buildfunthings.aoc.days;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.buildfunthings.aoc.common.Day;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

public class Day01 implements Day<Integer> {
    enum Direction {
        NORTH,EAST,SOUTH,WEST;
    }
    @Override
    public Integer part1(List<String> input) {
        int x = 0;
        int y = 0;
        Direction d = Direction.NORTH;
        
        String instructions = input.get(0);
        for (String s : instructions.split(", ")) {
            String dir = s.substring(0,1);
            int blocks = Integer.parseInt(s.substring(1));

            boolean left = "L".equals(dir);
            switch (d) {
            case NORTH:
                if (left) {
                    d = Direction.WEST;
                    x -= blocks;
                } else {
                    d = Direction.EAST;
                    x += blocks;
                }
                break;
            case EAST:
                if (left) {
                    d = Direction.NORTH;
                    y += blocks;
                } else {
                    d = Direction.SOUTH;
                    y -= blocks;
                }
                break;
            case SOUTH:
                if (left) {
                    d = Direction.EAST;
                    x += blocks;
                } else {
                    d = Direction.WEST;
                    x -= blocks;
                }
                break;
            case WEST:
                if (left) {
                    d = Direction.SOUTH;
                    y -= blocks;
                } else {
                    d = Direction.NORTH;
                    y += blocks;
                }
                break;
            }
            
        }

        return (Math.abs(x) + Math.abs(y));
    }

    @AllArgsConstructor
    @EqualsAndHashCode
    @ToString
    class Coord {
        int x;
        int y;

        List<Coord> coordsBetween(Coord target) {
            List<Coord> cl = new ArrayList<>();

            if (x == target.x) {
                // only do y
                int fromY = Math.min(y, target.y);
                int toY = Math.max(y, target.y);

                for (int i = fromY; i <= toY; i++) {
                    cl.add(new Coord(x, i));
                }
            } else if (y == target.y) {
                // only do x
                int fromX = Math.min(x, target.x);
                int toX = Math.max(x, target.x);

                for (int i = fromX; i <= toX; i++) {
                    cl.add(new Coord(i, y));
                }
            }

            if (x > target.x || y > target.y) {
                cl.remove(cl.size() - 1);
            } else {
                cl.remove(0);
            }
            return cl;
        }
    }
    
    @Override
    public Integer part2(List<String> input) {
        int x = 0;
        int y = 0;

        Coord place = new Coord(x, y);
        
        Direction d = Direction.NORTH;

        List<Coord> seen = new ArrayList<>();
        String instructions = input.get(0);
        for (String s : instructions.split(", ")) {
            String dir = s.substring(0,1);
            int blocks = Integer.parseInt(s.substring(1));

            boolean left = "L".equals(dir); // either L or R
            switch (d) {
            case NORTH:
                if (left) {
                    d = Direction.WEST;
                    x -= blocks;
                } else {
                    d = Direction.EAST;
                    x += blocks;
                }
                break;
            case EAST:
                if (left) {
                    d = Direction.NORTH;
                    y += blocks;
                } else {
                    d = Direction.SOUTH;
                    y -= blocks;
                }
                break;
            case SOUTH:
                if (left) {
                    d = Direction.EAST;
                    x += blocks;
                } else {
                    d = Direction.WEST;
                    x -= blocks;
                }
                break;
            case WEST:
                if (left) {
                    d = Direction.SOUTH;
                    y -= blocks;
                } else {
                    d = Direction.NORTH;
                    y += blocks;
                }
                break;
            }

            Coord dest = new Coord(x, y);
            List<Coord> steps = place.coordsBetween(dest);
            for (Coord step : steps) {
                if (seen.contains(step)) {
                    return (Math.abs(step.x) + Math.abs(step.y));
                } 
                seen.add(step);
            }

            place = dest;
        }

        return 0;
    }
    
}
