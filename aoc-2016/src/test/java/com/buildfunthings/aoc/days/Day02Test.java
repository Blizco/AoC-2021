package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day02Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(02);

    @Test
    public void testGetNumber() {
        Day02 d = new Day02();
        assertEquals(4, d.getNumber(5, "L"));
        assertEquals(4, d.getNumber(5, "LLLLL"));
        assertEquals(2, d.getNumber(5, "U"));
        assertEquals(2, d.getNumber(5, "UUUU"));
        assertEquals(8, d.getNumber(5, "D"));
        assertEquals(8, d.getNumber(5, "DDDD"));

        assertEquals(1, d.getNumber(5, "ULL"));

    }

    @Test
    public void testSampleInput() {
        Day02 d = new Day02();
        List<String> input = new ArrayList<>() {{
                add("ULL");
                add("RRDDD");
                add("LURDL");
                add("UUUUD");
            }
        };
        assertEquals("1985", d.part1(input));
    }

    @Test
    public void testSampleInput2() {
        Day02 d = new Day02();
        List<String> input = new ArrayList<>() {{
                add("ULL");
                add("RRDDD");
                add("LURDL");
                add("UUUUD");
            }
        };
        assertEquals("5DB3", d.part2(input));
    }
    
    @Test
    public void testPart1() {
        Day02 d = new Day02();
        assertEquals("73597", d.part1(input.getLines()));
    }

    @Test
    public void testPart2() {
        Day02 d = new Day02();
        assertEquals("A47DA", d.part2(input.getLines()));
    }
}
