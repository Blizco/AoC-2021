package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day09Test {

    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(9);

    @Test
    public void testSampleInput1() {
        List<String> input = new ArrayList<>() {{
                add("London to Dublin = 464");
                add("London to Belfast = 518");
                add("Dublin to Belfast = 141");
            }};

        Day<Integer> sut = new Day09();
        assertEquals(Integer.valueOf(605), sut.part1(input));
    }

    @Test
    public void testSampleInput2() {
        List<String> input = new ArrayList<>() {{
                add("London to Dublin = 464");
                add("London to Belfast = 518");
                add("Dublin to Belfast = 141");
            }};

        Day<Integer> sut = new Day09();
        assertEquals(Integer.valueOf(982), sut.part2(input));
    }

    @Test
    public void testRealInput() {
        Day<Integer> day = new Day09();
        assertEquals(Integer.valueOf(117), day.part1(input.getLines()));
        assertEquals(Integer.valueOf(909), day.part2(input.getLines()));
    }
}
