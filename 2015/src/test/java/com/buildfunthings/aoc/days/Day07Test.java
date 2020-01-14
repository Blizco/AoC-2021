package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day07Test {

    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(07);

    @Test
    public void testSampleInput1() {
        Map<String, String> tests = new HashMap<>() {
            {
                put("d", "72");
                put("e", "507");
                put("f", "492");
                put("g", "114");
                put("h", "65412");
                put("i", "65079");
                put("x", "123");
                put("y", "456");
            }
        };

        Day07 app = new Day07();

        List<String> input = new ArrayList<>() {
            {
                add("123 -> x");
                add("456 -> y");
                add("x AND y -> d");
                add("x OR y -> e");
                add("x LSHIFT 2 -> f");
                add("y RSHIFT 2 -> g");
                add("NOT x -> h");
                add("NOT y -> i");
            }
        };

        for (String key : tests.keySet()) {
            app.wires.clear();
            app.gates.clear();
            app.createCircuit(input);
            assertEquals(tests.get(key), String.valueOf(app.fireWire(key)));
        }
    }    

    @Test
    public void testRealInput() {
        Day day = new Day07();
        assertEquals("46065", day.part1(input.getLines()));
        assertEquals("14134", day.part2(input.getLines()));
    }
}
