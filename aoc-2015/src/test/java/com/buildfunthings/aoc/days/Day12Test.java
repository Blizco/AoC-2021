package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day12Test {

    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(12);

    @Test
    public void testSampleInput1() {
        Map<String, Integer> tests = new HashMap<>() {{
                put("[1,2,3]", 6);
                put("{\"a\":2,\"b\":4}", 6);
                put("{\"a\":2,\"b\":4}", 6);
                put("{\"a\":[-1,1]}", 0);
            }
            };

        for (String k : tests.keySet()) {
            Day<Integer> day = new Day12();
            assertEquals(tests.get(k), day.part1(new ArrayList<String>() {{ add(k); }}));
        }
    }

    @Test
    public void testSampleInput2() {
        Map<String, Integer> tests = new HashMap<>() {{
                put("[1,2,3]", 6);
                put("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}", 0);
                put("[1,\"red\",5]", 6);
            }
            };

        for (String k : tests.keySet()) {
            Day<Integer> day = new Day12();
            assertEquals(tests.get(k), day.part2(new ArrayList<String>() {{ add(k); }}));
        }
    }

    @Test
    public void testRealInput() {
        Day<Integer> day = new Day12();
        assertEquals(Integer.valueOf(119433), day.part1(input.getLines()));
        assertEquals(Integer.valueOf(68466), day.part2(input.getLines()));
    }
}
