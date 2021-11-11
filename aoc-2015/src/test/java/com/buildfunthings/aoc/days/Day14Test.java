package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day14Test {

    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(14);

    @Test
    public void testSampleInput1() {
        Map<String, Integer> tests = new HashMap<>() {{
                put("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.", 2660);
                put("Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.", 2640);
            }
            };

        for (String k : tests.keySet()) {
            Day<Integer> day = new Day14();
            assertEquals(tests.get(k), day.part1(new ArrayList<String>() {{ add(k); }}));
        }

        List<String> testcase = new ArrayList<>() {{
                add("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.");
                add("Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.");
            }
        };

        Day<Integer> day = new Day14();
        assertEquals(Integer.valueOf(2660), day.part1(testcase));
    }

    @Test
    public void testSampleInput2() {
        List<String> testcase = new ArrayList<>() {{
                add("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.");
                add("Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.");
            }
        };

        Day<Integer> day = new Day14();
        assertEquals(Integer.valueOf(1564), day.part2(testcase));
    }

    @Test
    public void testRealInput() {
        Day<Integer> day = new Day14();
        assertEquals(Integer.valueOf(2660), day.part1(input.getLines()));
        assertEquals(Integer.valueOf(1256), day.part2(input.getLines()));
    }
}
