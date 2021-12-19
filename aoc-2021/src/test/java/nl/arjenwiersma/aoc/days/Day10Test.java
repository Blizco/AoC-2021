package nl.arjenwiersma.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import nl.arjenwiersma.aoc.common.Day;
import nl.arjenwiersma.aoc.common.DayInputExternalResource;

public class Day10Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(10);

    Day<Long> day;

    @Before
    public void before() {
        day = new Day10();
    }

    @Test
    public void testSample() {
        List<String> input = new ArrayList<>() {{
            add("[({(<(())[]>[[{[]{<()<>>");
            add("[(()[<>])]({[<{<<[]>>(");
            add("{([(<{}[<>[]}>{[]{[(<()>");
            add("(((({<>}<{<{<>}{[]{[]{}");
            add("[[<[([]))<([[{}[[()]]]");
            add("[{[{({}]{}}([{[{{{}}([]");
            add("{<[[]]>}<{[{[{[]{()[[[]");
            add("[<(<(<(<{}))><([]([]()");
            add("<{([([[(<>()){}]>(<<{{");
            add("<{([{{}}[<[[[<>{}]]]>[]]");
        }};

        assertEquals(26397, (long) day.part1(input));
        assertEquals(288957, (long) day.part2(input));
    }

    @Test
    public void part1() {
        assertEquals(390993, (long) day.part1(input.getLines()));
    }

    @Test
    public void part2() {
        assertEquals(2391385187L, (long) day.part2(input.getLines()));
    }
}
