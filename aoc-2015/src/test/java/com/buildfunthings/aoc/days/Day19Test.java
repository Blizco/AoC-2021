package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;


public class Day19Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(19);

    @Test
    public void testSampleInput() {
        List<String> input = new ArrayList<>() {
                {
                    add("H => HO");
                    add("H => OH");
                    add("O => HH");
                    add("");
                    add("HOH");
                }      
        };

        Day19 day = new Day19();
        assertEquals(Integer.valueOf(4), day.part1(input));
    }

    @Test
    public void testSampleInput2() {
        List<String> input = new ArrayList<>() {
                {
                    add("e => H");
                    add("e => O");
                    add("H => HO");
                    add("H => OH");
                    add("O => HH");
                    add("");
                    add("HOH");
                }      
        };

        Day19 day = new Day19();
        assertEquals(Integer.valueOf(3), day.part2(input));
        input = new ArrayList<>() {
                {
                    add("e => H");
                    add("e => O");
                    add("H => HO");
                    add("H => OH");
                    add("O => HH");
                    add("");
                    add("HOHOHO");
                }      
        };
        assertEquals(Integer.valueOf(6), day.part2(input));
    }
    
    @Test
    public void testRealInput() {
        Day19 day = new Day19();
        assertEquals(Integer.valueOf(535), day.part1(input.getLines()));
        assertEquals(Integer.valueOf(212), day.part2(input.getLines()));
    }

}
