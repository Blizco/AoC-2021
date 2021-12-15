package nl.arjenwiersma.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import nl.arjenwiersma.aoc.common.Day;
import nl.arjenwiersma.aoc.common.DayInputExternalResource;

public class Day09Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(9);

    Day<Integer> day;

    @Before
    public void before() {
        day = new Day09();
    }

    @Test
    public void testSample() {
        List<String> input = new ArrayList<>() {{
            add("2199943210");
            add("3987894921");
            add("9856789892");
            add("8767896789");
            add("9899965678");
        }};

        assertEquals(15, (int)day.part1(input));
        assertEquals(1134, (int)day.part2(input));
    }

    @Test
    public void testNeighbors() {
        Day09 d9 = (Day09) day;
        assertEquals(List.of(0,2,11), Arrays.stream(d9.neighborIndexes(10, 5, 1)).boxed().toList());
        assertEquals(List.of(21,12,23,32), Arrays.stream(d9.neighborIndexes(10, 5, 22)).boxed().toList());
    }

    @Test
    public void part1() {
        assertEquals(548, (int)day.part1(input.getLines()));
    }

    @Test
    public void part2() {
        assertEquals(786048, (int)day.part2(input.getLines()));
    }
}
