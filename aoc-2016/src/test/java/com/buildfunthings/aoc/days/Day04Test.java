package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day04Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(04);

    @Test
    public void testSamples() {
        List<String> input = new ArrayList<>() {{
                add("aaaaa-bbb-z-y-x-123[abxyz]");
                add("a-b-c-d-e-f-g-h-987[abcde]");
                add("not-a-real-room-404[oarel]");
                add("totally-real-room-200[decoy]");
            }
        };
        Day<Integer> day = new Day04();
        assertEquals(Integer.valueOf(1514), day.part1(input));
    }
    
    @Test
    public void part1() {
        Day<Integer> day = new Day04();
        assertEquals(Integer.valueOf(245102), day.part1(input.getLines()));
    }
    
    @Test
    public void part2() {
        Day<Integer> day = new Day04();
        assertEquals(Integer.valueOf(324), day.part2(input.getLines()));
    }
}
