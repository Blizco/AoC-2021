package nl.arjenwiersma.aoc.days;

import nl.arjenwiersma.aoc.common.Day;
import nl.arjenwiersma.aoc.common.DayInputExternalResource;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class Day04Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(4);

    Day<Integer> day;

    @Before
    public void before() {
        day = new Day04();
    }

    @Test
    public void testSample() {
        List<String> input = Arrays.stream("""
7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1

22 13 17 11  0
 8  2 23  4 24
21  9 14 16  7
 6 10  3 18  5
 1 12 20 15 19

 3 15  0  2 22
 9 18 13 17  5
19  8  7 25 23
20 11 10 24  4
14 21 16 12  6

14 21 17 24  4
10 16 15  9 19
18  8 23 26 20
22 11 13  6  5
 2  0 12  3  7
""".split("\n")).toList();

        assertEquals(Integer.valueOf(4512), day.part1(input));
        assertEquals(Integer.valueOf(1924), day.part2(input));

    }

    @Test
    public void testPart1() {
        assertEquals(Integer.valueOf(32844), day.part1(input.getLines()));
    }
    @Test
    public void testPart2() {
        assertEquals(Integer.valueOf(4920), day.part2(input.getLines()));
    }

}