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
        Map<String, Long> tests = new HashMap<>() {
            {
                put("ugknbfddgicrmopn", 1L);
                put("aaa", 1L);
                put("jchzalrnumimnmhp", 0L);
                put("haegwjzuvuyypxyu", 0L);
                put("dvszwmarrgswjxmb", 0L);
            }
        };

        for (String k : tests.keySet()) {
            Day<Long> day = new Day05();
            assertEquals(tests.get(k), day.part1(new ArrayList<String>() {
                {
                    add(k);
                }
            }));
        }
    }

    @Test
    public void testSampleInput2() {
        Map<String, Long> tests = new HashMap<>() {
            {
                put("qjhvhtzxzqqjkmpb", 1L);
                put("xxyxx", 1L);
                put("uurcxstgmygtbstg", 0L);
                put("ieodomkazucvgmuy", 0L);
            }
        };

        for (String k : tests.keySet()) {
            Day<Long> day = new Day05();
            assertEquals(tests.get(k), day.part2(new ArrayList<String>() {
                {
                    add(k);
                }
            }));
        }
    }

    @Test
    public void testRealInput() {
        Day<Long> day = new Day05();
        assertEquals(Long.valueOf(236), day.part1(input.getLines()));
        assertEquals(Long.valueOf(51), day.part2(input.getLines()));
    }
}
