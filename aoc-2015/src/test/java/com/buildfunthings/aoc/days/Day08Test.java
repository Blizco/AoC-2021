package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day08Test {

    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(8);

    @Test
    public void testSampleInput1() {
        Map<String, Integer> tests = new HashMap<>() {{
                put("\"\"", 2); // 2 chars - 0 actual
                put("\"abc\"", 2); // 5 chars - 3 actual
                put("\"aaa\\\"aaa\"", 3); // 10 chars - 7 actual
                put("\"\\x27\"", 5); // 6 chars - 1 actual
            }
            };

        for (String k : tests.keySet()) {
            Day<Integer> day = new Day08();
            assertEquals(tests.get(k), day.part1(new ArrayList<String>() {{ add(k); }}));
        }
    }

    @Test
    public void testSampleInput2() {
        Map<String, Integer> tests = new HashMap<>() {{
                put("\"abc\"", 4);
                put("\"aaa\\\"aaa\"", 6);
                put("\"\"", 4);
                put("\"\\x27\"", 5);
                put("\"\\\\\\\"", 7);
            }
            };

        for (String k : tests.keySet()) {
            Day<Integer> day = new Day08();
            assertEquals(tests.get(k), day.part2(new ArrayList<String>() {{ add(k); }}));
        }
    }

    @Test
    public void testRealInput() {
        Day<Integer> day = new Day08();
        assertEquals(Integer.valueOf(1333), day.part1(input.getLines()));
        assertEquals(Integer.valueOf(2046), day.part2(input.getLines()));
    }
}
