package nl.arjenwiersma.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import nl.arjenwiersma.aoc.common.Day;
import nl.arjenwiersma.aoc.common.DayInputExternalResource;

public class Day01Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(01);

    Day<Integer> day;
    
    @Before
    public void before() {
        day = new Day01();
    }

    @Test
    public void testSample() {
        List<String> input = new ArrayList<>() {{
                add("199");
                add("200");
                add("208");
                add("210");
                add("200");
                add("207");
                add("240");
                add("269");
                add("260");
                add("263");
            }
            };

        assertEquals(Integer.valueOf(7), day.part1(input));
        assertEquals(Integer.valueOf(5), day.part2(input));
    }

    @Test
    public void part1() {
        assertEquals(Integer.valueOf(1759), day.part1(input.getLines()));
    }
    
    @Test
    public void part2() {
        assertEquals(Integer.valueOf(1805), day.part2(input.getLines()));
    }
}
