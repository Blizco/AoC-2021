package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day23Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(23);

    @Test
    public void sampleInput() {
        List<String> inp = new ArrayList<>(){{
                add("inc a");
                add("jio a, +2");
                add("tpl a");
                add("inc a");
                
            }};
        Day23 day = new Day23();
        assertEquals(Integer.valueOf(0), day.part1(inp));
    }
    
    @Test
    public void testPart1() {
        Day23 day = new Day23();
        assertEquals(Integer.valueOf(307), day.part1(input.getLines()));
    }

    @Test
    public void testPart2() {
        Day23 day = new Day23();
        assertEquals(Integer.valueOf(160), day.part2(input.getLines()));
    }
}
