package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day11Test {

    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(11);

    @Test
    public void testCharToInt() {
        assertEquals(97, (int) 'a');
        assertEquals(122, (int) 'z');

        String test = "abc";
        int[] converted = test.chars().toArray();
        assertArrayEquals(new int[] {97,98,99}, converted);

        //System.out.println(IntStream.range(0, test.length()).mapToObj(test::charAt).collect(Collectors.toList()));
    }
    
    @Test
    public void testSampleInput1() {
        Map<String, String> tests = new HashMap<>() {{
                put("input", "expect");
            }
            };

        for (String k : tests.keySet()) {
            Day day = new Day11();
            assertEquals(tests.get(k), day.part1(new ArrayList<String>() {{ add(k); }}));
        }
    }

    @Test
    public void testSampleInput2() {
        Map<String, String> tests = new HashMap<>() {{
                put("input", "expect");
            }
            };

        for (String k : tests.keySet()) {
            Day day = new Day11();
            assertEquals(tests.get(k), day.part2(new ArrayList<String>() {{ add(k); }}));
        }
    }

    @Test
    public void testRealInput() {
        Day day = new Day11();
        assertEquals("", day.part1(input.getLines()));
        assertEquals("", day.part2(input.getLines()));
    }
}
