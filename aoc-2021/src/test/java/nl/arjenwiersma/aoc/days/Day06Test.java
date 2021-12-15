package nl.arjenwiersma.aoc.days;

import nl.arjenwiersma.aoc.common.Day;
import nl.arjenwiersma.aoc.common.DayInputExternalResource;
import nl.arjenwiersma.aoc.days.Day06;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day06Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(06);

    Day<Long> day;

    @Before
    public void before() {
        day = new Day06();
    }

    @Test
    public void testSample() {
        List<String> input = Arrays.stream("""
3,4,3,1,2
""".split("\n")).toList();

        assertEquals(5934, (long)day.part1(input));
        assertEquals(26984457539L, (long)day.part2(input));

    }

    @Test
    public void testPart1() {
        assertEquals(362346, (long)day.part1(input.getLines()));
    }
    @Test
    public void testPart2() {
        assertEquals(1639643057051L, (long)day.part2(input.getLines()));
    }

}