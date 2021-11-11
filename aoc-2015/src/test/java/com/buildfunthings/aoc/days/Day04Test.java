package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day04Test {

    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(04);

    @Test
    public void testSampleInput1() {
        Map<String, Integer> tests = new HashMap<>() {{
                put("abcdef", 609043);
                put("pqrstuv", 1048970);
            }
            };

        for (String k : tests.keySet()) {
            Day<Integer> day = new Day04();
            assertEquals(tests.get(k), day.part1(new ArrayList<String>() {{ add(k); }}));
        }
    }

    @Test
    public void testSampleInput2() {
    }

    @Test
    public void testRealInput() {
        Day<Integer> day = new Day04();
        assertEquals(Integer.valueOf(282749), day.part1(input.getLines()));
        assertEquals(Integer.valueOf(9962624), day.part2(input.getLines()));
    }
}
