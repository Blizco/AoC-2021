package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day05Test {

    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(05);

    @Test
    public void testSampleInput1() {
        Map<String, String> tests = new HashMap<>() {{
                put("ugknbfddgicrmopn", "1");
                put("aaa", "1");
                put("jchzalrnumimnmhp", "0");
                put("haegwjzuvuyypxyu", "0");
                put("dvszwmarrgswjxmb", "0");
            }
            };

        for (String k : tests.keySet()) {
            Day day = new Day05();
            assertEquals(tests.get(k), day.part1(new ArrayList<String>() {{ add(k); }}));
        }
    }

    @Test
    public void testSampleInput2() {
        Map<String, String> tests = new HashMap<>() {{
                put("qjhvhtzxzqqjkmpb", "1");
                put("xxyxx", "1");
                put("uurcxstgmygtbstg", "0");
                put("ieodomkazucvgmuy", "0");
            }
            };

        for (String k : tests.keySet()) {
            Day day = new Day05();
            assertEquals(tests.get(k), day.part2(new ArrayList<String>() {{ add(k); }}));
        }
    }

    @Test
    public void testRealInput() {
        Day day = new Day05();
        assertEquals("255", day.part1(input.getLines()));
        assertEquals("55", day.part2(input.getLines()));
    }
}
