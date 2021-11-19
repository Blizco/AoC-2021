package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day06Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(06);

    @Test
    public void testSamples() {
        List<String> input = new ArrayList<>() {{
                add("eedadn");
                add("drvtee");
                add("eandsr");
                add("raavrd");
                add("atevrs");
                add("tsrnev");
                add("sdttsa");
                add("rasrtv");
                add("nssdts");
                add("ntnada");
                add("svetve");
                add("tesnvt");
                add("vntsnd");
                add("vrdear");
                add("dvrsen");
                add("enarar");
            }
        };

        Day<String> day = new Day06();
        assertEquals("easter", day.part1(input));

    }
    
    @Test
    public void part1() {
        Day<String> day = new Day06();
        assertEquals("bjosfbce", day.part1(input.getLines()));
    }
    
    @Test
    public void part2() {
        Day<String> day = new Day06();
        assertEquals("veqfxzfx", day.part2(input.getLines()));
    }
}
