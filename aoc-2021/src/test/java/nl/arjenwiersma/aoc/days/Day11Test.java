package nl.arjenwiersma.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import nl.arjenwiersma.aoc.common.Day;
import nl.arjenwiersma.aoc.common.DayInputExternalResource;

public class Day11Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(11);

    Day<Long> day;

    @Before
    public void before() {
        day = new Day11();
    }

    @Test
    public void testSample() {
        List<String> input = new ArrayList<>() {{
            add("11111");
            add("19991");
            add("19191");
            add("19991");
            add("11111");
        }
        };

        assertEquals(9L, (long)((Day11)day).playGame(input, 2, false));

        input = new ArrayList<>() {
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
        assertEquals(1656L, (long)((Day11)day).playGame(input, 100, false));
        assertEquals(195L, (long)((Day11)day).playGame(input, 200, true));
    }

    @Test
    public void part1() {
        assertEquals(1585L, (long)day.part1(input.getLines()));
    }

    @Test
    public void part2() {
        assertEquals(382L, (long)day.part2(input.getLines()));
    }
}
