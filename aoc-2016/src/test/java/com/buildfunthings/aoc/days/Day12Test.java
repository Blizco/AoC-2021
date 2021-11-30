package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class Day12Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(12);

    Day<Integer> day;

    @Before
    public void before() {
        day = new Day12();
    }
    
    @Test
    public void testSample() {
        List<String> input = new ArrayList<>() {{
                add("cpy 41 a");
                add("inc a");
                add("inc a");
                add("dec a");
                add("jnz a 2");
                add("dec a");
            }
        };

        assertEquals(Integer.valueOf(42), day.part1(input));
    }
    
    @Test
    public void part1() {
        assertEquals(Integer.valueOf(317993), day.part1(input.getLines()));
    }
    
    @Test
    public void part2() {
        assertEquals(Integer.valueOf(9227647), day.part2(input.getLines()));
    }
}
