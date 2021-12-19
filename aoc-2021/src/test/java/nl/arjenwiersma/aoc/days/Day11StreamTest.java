package nl.arjenwiersma.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import nl.arjenwiersma.aoc.common.Day;
import nl.arjenwiersma.aoc.common.DayInputExternalResource;

public class Day11StreamTest {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(11);

    Day<Integer> day;

    @Before
    public void before() {
        day = new Day11Stream();
    }

    @Test
    public void testSample() {
        List<String> input = new ArrayList<>() {
            {
                add("5483143223");
                add("2745854711");
                add("5264556173");
                add("6141336146");
                add("6357385478");
                add("4167524645");
                add("2176841721");
                add("6882881134");
                add("4846848554");
                add("5283751526");
            }
        };
        assertEquals(1656, (int) day.part1(input));
        assertEquals(195, (int) day.part2(input));
    }

    @Test
    public void part1() {
        assertEquals(1585, (int) day.part1(input.getLines()));
    }

    @Test
    public void part2() {
        assertEquals(382, (int) day.part2(input.getLines()));
    }
}
