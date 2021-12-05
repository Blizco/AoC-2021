package com.buildfunthings.aoc.days;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class Day15Test {

    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(15);
    private Day<Integer> day;

    @Before
    public void before() {
        day = new Day15();
    }

    @Test
    public void testSample() {
        List<String> input = Arrays.stream("""
Disc #1 has 5 positions; at time=0, it is at position 4.
Disc #2 has 2 positions; at time=0, it is at position 1.
""".split("\n")).toList();

        assertEquals(5, (int) day.part1(input));
    }

    @Test
    public void testPart1() {
        assertEquals(203660, (int) day.part1(input.getLines()));
    }
    @Test
    public void testPart2() {
        assertEquals(2408135, (int) day.part2(input.getLines()));
    }
}