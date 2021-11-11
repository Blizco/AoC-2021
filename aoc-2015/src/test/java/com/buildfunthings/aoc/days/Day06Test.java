package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day06Test {

    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(06);

    @Test
    public void testSampleInput1() {
        Map<String, Integer> tests = new HashMap<>() {{
                put("turn on 0,0 through 999,999", 1000000);
                put("toggle 0,0 through 999,0", 1000);
                put("turn on 499,499 through 500,500", 4);
            }
            };

        for (String k : tests.keySet()) {
            Day<Integer> day = new Day06();
            assertEquals(tests.get(k), day.part1(new ArrayList<String>() {{ add(k); }}));
        }
    }

    @Test
    public void testSampleInput2() {
        Map<String, Integer> tests = new HashMap<>() {{
                put("turn on 0,0 through 999,999", 1000000);
                put("toggle 0,0 through 999,0", 2000);
            }
            };

        for (String k : tests.keySet()) {
            Day<Integer> day = new Day06();
            assertEquals(tests.get(k), day.part2(new ArrayList<String>() {{ add(k); }}));
        }
    }

    @Test
    public void testRealInput() {
        Day<Integer> day = new Day06();
        assertEquals(Integer.valueOf(377891), day.part1(input.getLines()));
        assertEquals(Integer.valueOf(14110788), day.part2(input.getLines()));
    }
}
