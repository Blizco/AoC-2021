package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day24Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(24);

    @Test
    public void sampleInput() {
        List<String> inp = new ArrayList<>(){{
                add("1");
                add("2");
                add("3");
                add("4");
                add("5");
                add("7");
                add("8");
                add("9");
                add("10");
                add("11");
            }};
        Day24 day = new Day24();
        assertEquals(Long.valueOf(99L), day.part1(inp));
    }

    @Test
    public void testPart1() {
        Day24 day = new Day24();
        assertEquals(Long.valueOf(11846773891L), day.part1(input.getLines()));
    }

    @Test
    public void testPart2() {
        Day24 day = new Day24();
        assertEquals(Long.valueOf(80393059L), day.part2(input.getLines()));
    }

}
