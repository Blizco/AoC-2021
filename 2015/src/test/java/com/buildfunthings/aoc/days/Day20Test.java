package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day20Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(20);

    @Test
    public void testSampleInput() {
        List<String> input = new ArrayList<String>() {
            {
                add("150");
            }
        };

        Day20 day = new Day20();
        //assertEquals(Integer.valueOf(8), day.part1(input));
    }

    @Test
    public void testRealInput() {
        Day20 day = new Day20();
        //        assertEquals(Integer.valueOf(0), day.part1(input.getLines()));
        //        assertEquals(Integer.valueOf(0), day.part2(input.getLines()));
    }

}
