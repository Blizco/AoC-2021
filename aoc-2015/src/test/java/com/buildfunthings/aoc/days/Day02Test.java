package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day02Test {

    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(02);

    @Test
    public void testSampleInput1() {
        Map<String, Integer> tests = new HashMap<>() {
            {
                put("2x3x4", 58);
                put("1x1x10", 43);
            }
        };

        for (String k : tests.keySet()) {
            Day<Integer> day = new Day02();
            assertEquals(tests.get(k), day.part1(new ArrayList<String>() {
                {
                    add(k);
                }
            }));
        }
    }

    @Test
    public void testSampleInput2() {
        Map<String, Integer> tests = new HashMap<>() {
            {
                put("2x3x4", 34);
                put("1x1x10", 14);
            }
        };

        for (String k : tests.keySet()) {
            Day<Integer> day = new Day02();
            assertEquals(tests.get(k), day.part2(new ArrayList<String>() {
                {
                    add(k);
                }
            }));
        }
    }

    @Test
    public void testRealInput() {
        Day<Integer> day = new Day02();
        assertEquals(Integer.valueOf(1598415), day.part1(input.getLines()));
        assertEquals(Integer.valueOf(3812909), day.part2(input.getLines()));
    }
}
