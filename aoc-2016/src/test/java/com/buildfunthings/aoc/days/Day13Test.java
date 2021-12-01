package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class Day13Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(13);

    Day<Integer> day;
    
    @Before
    public void before() {
        day = new Day13();
    }

    @Test
    public void testSample() {
        ((Day13)day).magic = 10;
        var valid = ((Day13)day).findPathsTo(7, 4);
        
        assertEquals(Integer.valueOf(11), Integer.valueOf(valid.stream().mapToInt(x -> x.size()).min().getAsInt() - 1));
    }

    @Test
    public void part1() {
        assertEquals(Integer.valueOf(92), day.part1(input.getLines()));
    }
    
    @Test
    public void part2() {
        assertEquals(Integer.valueOf(124), day.part2(input.getLines()));
    }
}
