package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day22Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(22);

    @Test
    public void testRealInput() {
        Day22 day = new Day22();
        assertEquals(Integer.valueOf(1269), day.part1(input.getLines()));
        assertEquals(Integer.valueOf(1309), day.part2(input.getLines()));
    }

}
