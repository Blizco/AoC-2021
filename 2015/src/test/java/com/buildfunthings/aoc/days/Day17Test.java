package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day17Test {

    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(17);

    @Test
    public void testSampleInput1() {
        int[] input = new int[] { 20, 15, 10, 5, 5 };

        // 25 can be done in 4 ways
        Day17 d = new Day17();
        int[][] c = d.combinations(input);

        assertEquals(4, d.countOfCombinedValue(c, 20));
    }

    @Test
    public void testSampleInput2() {
        int[] input = new int[] { 20, 15, 10, 5, 5 };

        Day17 d = new Day17();
        int[][] c = d.combinations(input);

        assertEquals(3, d.countOfContainersToSpare(c, 25));
    }

    @Test
    public void testRealInput() {
        Day day = new Day17();
        assertEquals("4372", day.part1(input.getLines()));
        assertEquals("4", day.part2(input.getLines()));
    }
}
