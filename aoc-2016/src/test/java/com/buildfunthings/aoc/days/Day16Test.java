package com.buildfunthings.aoc.days;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day16Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(16);

    Day<String> day;

    @Before
    public void before() {
        day = new Day16();
    }

    @Test
    public void testCurve() {
        assertEquals("100", ((Day16) day).curve("1"));
        assertEquals("001", ((Day16) day).curve("0"));
        assertEquals("11111000000", ((Day16) day).curve("11111"));
        assertEquals("1111000010100101011110000", ((Day16) day).curve("111100001010"));
    }

    @Test
    public void testSample() {
        List<String> input = Arrays.stream("""
10000
""".split("\n")).toList();

        assertEquals("01100", ((Day16) day).checksum(input.get(0), 20));
        //assertEquals(Integer.valueOf(0), day.part2(input));

    }

    @Test
    public void testPart1() {
        assertEquals("10010010110011010", day.part1(input.getLines()));
    }
    @Test
    public void testPart2() {
        assertEquals("01010100101011100", day.part2(input.getLines()));
    }

}