package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day13Test {

    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(13);

    @Test
    public void testSampleInput1() {
        List<String> input = new ArrayList<>() {
            {
                add("Alice would gain 54 happiness units by sitting next to Bob.");
                add("Alice would lose 79 happiness units by sitting next to Carol.");
                add("Alice would lose 2 happiness units by sitting next to David.");
                add("Bob would gain 83 happiness units by sitting next to Alice.");
                add("Bob would lose 7 happiness units by sitting next to Carol.");
                add("Bob would lose 63 happiness units by sitting next to David.");
                add("Carol would lose 62 happiness units by sitting next to Alice.");
                add("Carol would gain 60 happiness units by sitting next to Bob.");
                add("Carol would gain 55 happiness units by sitting next to David.");
                add("David would gain 46 happiness units by sitting next to Alice.");
                add("David would lose 7 happiness units by sitting next to Bob.");
                add("David would gain 41 happiness units by sitting next to Carol.");
            }
        };
        Day day = new Day13();
        assertEquals("330", day.part1(input));
    }

    @Test
    public void testRealInput() {
        Day day = new Day13();
        assertEquals("709", day.part1(input.getLines()));
        assertEquals("668", day.part2(input.getLines()));
    }
}
