package nl.arjenwiersma.aoc.days;

import nl.arjenwiersma.aoc.common.Day;
import nl.arjenwiersma.aoc.common.DayInputExternalResource;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class Day02Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(2);

    Day<Long> day;

    @Before
    public void before() {
        day = new Day02();
    }
    @Test
    public void testSample() {
        List<String> input = new ArrayList<>( ) {{
            add("forward 5");
            add("down 5");
            add("forward 8");
            add("up 3");
            add("down 8");
            add("forward 2");
        }};

        assertEquals(Long.valueOf(150), day.part1(input));
        assertEquals(Long.valueOf(900), day.part2(input));
    }

    @Test
    public void testPart1() {
        assertEquals(Long.valueOf(2117664), day.part1(input.getLines()));
    }
    @Test
    public void testPart2() {
        assertEquals(Long.valueOf(2073416724), day.part2(input.getLines()));
    }
}