package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day25Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(25);

    @Test
    public void part1() {
        Day<Long> day = new Day25();
        assertEquals(Long.valueOf(8997277L), day.part1(input.getLines()));
    }
    
    @Test
    public void part2() {
        Day<Long> day = new Day25();
        assertEquals(Long.valueOf(0L), day.part2(input.getLines()));
    }
}
