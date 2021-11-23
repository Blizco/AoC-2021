package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day10Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(10);

    @Test
    public void part1() {
        Day<Integer> day = new Day10();
        assertEquals(Integer.valueOf(181), day.part1(input.getLines()));
    }
    
    @Test
    public void part2() {
        Day<Integer> day = new Day10();
        assertEquals(Integer.valueOf(12567), day.part2(input.getLines()));
    }
}
