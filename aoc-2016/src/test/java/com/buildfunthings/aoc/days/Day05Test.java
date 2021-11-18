package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day05Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(05);

    @Test
    public void testSample() {
        Day<String> day = new Day05();
        assertEquals("18f47a30", day.part1(new ArrayList<String>() {
            {
                add("abc");
            }
        }));
        assertEquals("05ace8e3", day.part2(new ArrayList<String>() {
            {
                add("abc");
            }
        }));
    }

    @Test
    public void part1() {
        Day<String> day = new Day05();
        assertEquals("f77a0e6e", day.part1(input.getLines()));
    }

    @Test
    public void part2() {
        Day<String> day = new Day05();
        assertEquals("999828ec", day.part2(input.getLines()));
    }
}
