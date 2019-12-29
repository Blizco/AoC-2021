package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day03Test {

    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(03);

    @Test
    public void testSampleInput1() {
        Map<String, String> tests = new HashMap<>() {{
                put(">", "2");
                put("^>v<", "4");
                put("^v^v^v^v^v", "2");
            }
            };

        for (String k : tests.keySet()) {
            Day day = new Day03();
            assertEquals(tests.get(k), day.part1(new ArrayList<String>() {{ add(k); }}));
        }
    }

    @Test
    public void testSampleInput2() {

        Map<String, String> tests = new HashMap<>() {{
                put("^v", "3");
                put("^>v<", "3");
                put("^v^v^v^v^v", "11");
            }
            };

        for (String k : tests.keySet()) {
            Day day = new Day03();
            assertEquals(tests.get(k), day.part2(new ArrayList<String>() {{ add(k); }}));
        }
    }

    @Test
    public void testRealInput() {
        Day day = new Day03();
        assertEquals("2572", day.part1(input.getLines()));
        assertEquals("2631", day.part2(input.getLines()));
    }
}
