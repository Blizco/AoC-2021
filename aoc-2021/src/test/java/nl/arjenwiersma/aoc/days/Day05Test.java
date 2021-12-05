package nl.arjenwiersma.aoc.days;

import nl.arjenwiersma.aoc.common.Day;
import nl.arjenwiersma.aoc.common.DayInputExternalResource;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class Day05Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(5);

    Day<Integer> day;

    @Before
    public void before() {
        day = new Day05();
    }

    @Test
    public void testSample() {
        List<String> input = Arrays.stream("""
0,9 -> 5,9
8,0 -> 0,8
9,4 -> 3,4
2,2 -> 2,1
7,0 -> 7,4
6,4 -> 2,0
0,9 -> 2,9
3,4 -> 1,4
0,0 -> 8,8
5,5 -> 8,2
""".split("\n")).toList();

        assertEquals(Integer.valueOf(5), day.part1(input));
        assertEquals(Integer.valueOf(12), day.part2(input));

    }

    @Test
    public void testPart1() {
        assertEquals(Integer.valueOf(5197), day.part1(input.getLines()));
    }
    @Test
    public void testPart2() {
        assertEquals(Integer.valueOf(18605), day.part2(input.getLines()));
    }

}