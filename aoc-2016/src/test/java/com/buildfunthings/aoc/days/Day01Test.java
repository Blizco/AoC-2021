package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day01Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(01);

    
    @Test
    public void testPart1() {
        Day01 day = new Day01();
        assertEquals(Integer.valueOf(298), day.part1(input.getLines()));
    }
    @Test
    public void testPart2() {
        Day01 day = new Day01();
        assertEquals(Integer.valueOf(158), day.part2(input.getLines()));
    }

}
