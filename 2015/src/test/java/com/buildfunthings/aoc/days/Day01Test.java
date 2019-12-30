package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day01Test {

    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(01);

    @Test
    public void testSampleInput1() {
        Map<String, String> tests = new HashMap<>() {{
                put("(())", "0");
                put("()()", "0");
                put("(((", "3");
                put("(()(()(", "3");
                put("))(((((", "3");
                put("())", "-1");
                put("))(", "-1");

            }
            };

        for (String k : tests.keySet()) {
            Day day = new Day01();
            assertEquals(tests.get(k), day.part1(new ArrayList<String>() {{ add(k); }}));
        }
    }

    @Test
    public void testSampleInput2() {
        Map<String, String> tests = new HashMap<>() {{
                put(")", "1");
                put("()())", "5");
            }
            };

        for (String k : tests.keySet()) {
            Day day = new Day01();
            assertEquals(tests.get(k), day.part2(new ArrayList<String>() {{ add(k); }}));
        }
    }

    @Test
    public void testRealInput() {
        Day day = new Day01();
        assertEquals("74", day.part1(input.getLines()));
        assertEquals("1795", day.part2(input.getLines()));
    }
}
