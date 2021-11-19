package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day07Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(07);

    @Test
    public void testSamples() {
        List<String> input = new ArrayList<>() {{
                add("abba[mnop]qrst");
                add("abcd[bddb]xyyx");
                add("aaaa[qwer]tyui");
                add("ioxxoj[asdfgh]zxcvbn");
            }
        };

        Day<Integer> d = new Day07();
        assertEquals(Integer.valueOf(2), d.part1(input));
    }

    @Test
    public void testSamples2() {
        List<String> input = new ArrayList<>() {{
                add("aba[bab]xyz");
                add("xyx[xyx]xyx");
                add("aaa[kek]eke");
                add("zazbz[bzb]cdb");
            }
        };
        Day<Integer> d = new Day07();
        assertEquals(Integer.valueOf(3), d.part2(input));
    }
    
    @Test
    public void testPart1() {
        Day<Integer> d = new Day07();
        assertEquals(Integer.valueOf(115), d.part1(input.getLines()));
    }

    @Test
    public void testPart2() {
        Day<Integer> d = new Day07();
        assertEquals(Integer.valueOf(231), d.part2(input.getLines()));
    }
}
