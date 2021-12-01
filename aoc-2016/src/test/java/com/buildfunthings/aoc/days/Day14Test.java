package com.buildfunthings.aoc.days;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class Day14Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(14);

    Day<Integer> day;

    @Before
    public void before() {
        day = new Day14();
    }

    @Test
    public void testSample() {

        //System.out.println(d.produceMD5("abc", 22728));

        assertEquals(Optional.of('x'),((Day14)day).contains3chars("sfsdfsxxxdsfdsf"));
        assertEquals(Optional.empty(),((Day14)day).contains3chars("sfsdfsxsxdsfdsf"));

        List<String> in = new ArrayList<>() {{
            add("abc");
        }};

        assertEquals(Integer.valueOf(22728),day.part1(in));
        assertEquals(Integer.valueOf(22551),day.part2(in));
    }

    @Test
    public void testPart1() {
        assertEquals(Integer.valueOf(18626), day.part1(input.getLines()));
    }
    @Test
    public void testPart2() {
        assertEquals(Integer.valueOf(20092), day.part2(input.getLines()));
    }

}