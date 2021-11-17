package com.buildfunthings.aoc.days;

import java.math.BigInteger;
import java.util.List;

import com.buildfunthings.aoc.common.Day;

public class Day25 implements Day<Long> {

    @Override
    public Long part1(List<String> input) {
        //  Enter the code at row 3010, column 3019.
        long lastNum = 20151125L;

        //  1 x 1
        //  2 x 1
        //  1 x 2
        Integer steps = 0;
        for (int depth = 1; depth <= Integer.MAX_VALUE; depth++) {
            //System.out.println("--- depth " + depth + " ----");
            for (int row = depth, col = 1;
                 row > 0 && col <= depth;
                 row--, col++) {
                if (col == 1 && row == 1) {
                    lastNum = 20151125L;
                } else {
                    lastNum = (lastNum * 252533) % 33554393;
                }
                steps++;
                if (row == 3010 && col == 3019) {
                    System.out.println("Current depth: " + depth + " steps " + steps);
                    System.out.println( "" + row + " x " + col + "= " + lastNum);
                    return lastNum;
                }
            }
            
        }
        System.out.println("Steps: " + steps);
    }

    @Override
    public Long part2(List<String> input) {
        return 0L;
    }
    
}
