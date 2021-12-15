package nl.arjenwiersma.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import nl.arjenwiersma.aoc.common.Day;
import nl.arjenwiersma.aoc.common.DayInputExternalResource;

public class Day07Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(07);

    Day<Integer> day;
    
    @Before
    public void before() {
        day = new Day07();
    }

    @Test
    public void testSample() {
        List<String> input = new ArrayList<>() {{
                add("16,1,2,0,4,2,7,1,2,14");
            }};
                                           
        assertEquals(Integer.valueOf(37), day.part1(input));
        assertEquals(Integer.valueOf(168), day.part2(input));
    }

    @Test
    public void part1() {
        assertEquals(Integer.valueOf(344535), day.part1(input.getLines()));
    }
    
    @Test
    public void part2() {
        assertEquals(Integer.valueOf(95581659), day.part2(input.getLines()));
    }
}
