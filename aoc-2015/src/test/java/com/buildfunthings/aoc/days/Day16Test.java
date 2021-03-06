package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day16Test {

    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(16);

    @Test
    public void testRealInput() {
        Day<Integer> day = new Day16();
        assertEquals(Integer.valueOf(373), day.part1(input.getLines()));
        assertEquals(Integer.valueOf(260), day.part2(input.getLines()));
    }
}
