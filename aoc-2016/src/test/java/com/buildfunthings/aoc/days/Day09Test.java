package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day09Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(9);

    @Test
    public void testSamples() {
        Day09 d = new Day09();

        assertEquals(Long.valueOf("ADVENT".length()), d.decompress("ADVENT",false));
        assertEquals(Long.valueOf("ABBBBBC".length()), d.decompress("A(1x5)BC",false));
        assertEquals(Long.valueOf("XYZXYZXYZ".length()), d.decompress("(3x3)XYZ",false));
        assertEquals(Long.valueOf("ABCBCDEFEFG".length()), d.decompress("A(2x2)BCD(2x2)EFG",false));
        assertEquals(Long.valueOf("(1x3)A".length()), d.decompress("(6x1)(1x3)A",false));
        assertEquals(Long.valueOf("X(3x3)ABC(3x3)ABCY".length()), d.decompress("X(8x2)(3x3)ABCY",false));
    }

    @Test
    public void testPart1() {
        Day<Long> d = new Day09();
        assertEquals(Long.valueOf(107035), d.part1(input.getLines()));
    }

    @Test
    public void testSamples2() {
        Day09 d = new Day09();

        assertEquals(Long.valueOf("XYZXYZXYZ".length()) , d.decompress("(3x3)XYZ", true));
        assertEquals(Long.valueOf("XABCABCABCABCABCABCY".length()), d.decompress( "X(8x2)(3x3)ABCY", true));
        assertEquals(Long.valueOf(241920), d.decompress("(27x12)(20x12)(13x14)(7x10)(1x12)A", true));
    }

    @Test
    public void testPart2() {
        Day<Long> d = new Day09();
        assertEquals(Long.valueOf(11451628995L), d.part2(input.getLines()));
    }
}
