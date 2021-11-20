package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day08Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(8);

    @Test
    public void testSample() {
        Day<Integer> d = new Day08(7, 3);

        List<String> input = new ArrayList<String>() {
            {
                add("rect 3x2");
                add("rotate column x=1 by 1");
                add("rotate row y=0 by 4");
                add("rotate column x=1 by 1");
            }
        };

        assertEquals(Integer.valueOf(6), d.part1(input));
    }

    @Test
    public void testPart1() {
        Day<Integer> d = new Day08(50, 6);

        assertEquals(Integer.valueOf(106), d.part1(input.getLines()));
    }

    @Test
    public void testPart2() {
        Day08 d = new Day08(50,6);

        // READ THE OUTPUT OF THE GRID :D
        assertEquals(Integer.valueOf(106), d.part1(input.getLines()));
        d.printGrid();
    }

}
