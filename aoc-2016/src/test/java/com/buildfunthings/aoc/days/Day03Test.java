package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day03Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(03);

    @Test
    public void testPart1() {
        Day03 d = new Day03();
        assertEquals(Integer.valueOf(869), d.part1(input.getLines()));
    }

    @Test
    public void testPart2() {
        Day03 d = new Day03();
        assertEquals(Integer.valueOf(1544), d.part2(input.getLines()));
    }
}
