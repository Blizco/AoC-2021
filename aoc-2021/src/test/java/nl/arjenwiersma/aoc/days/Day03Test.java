package nl.arjenwiersma.aoc.days;

import nl.arjenwiersma.aoc.common.Day;
import nl.arjenwiersma.aoc.common.DayInputExternalResource;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertEquals;

public class Day03Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(3);

    Day<Long> day;

    @Before
    public void before() {
        day = new Day03();
    }

    @Test
    public void testSample() {
        List<String> input = new ArrayList<>() {{
            add("00100");
            add("11110");
            add("10110");
            add("10111");
            add("10101");
            add("01111");
            add("00111");
            add("11100");
            add("10000");
            add("11001");
            add("00010");
            add("01010");
        }};

        assertEquals(Long.valueOf(198), day.part1(input));
        assertEquals(Long.valueOf(230), day.part2(input));
    }

    //@Test
    public void testSorting() {
        List<String> input = new ArrayList<>() {{
            add("00100");
            add("11110");
            add("10110");
            add("10111");
            add("10101");
            add("01111");
            add("00111");
            add("11100");
            add("10000");
            add("11001");
            add("00010");
            add("01010");
        }};

        List<String> current = input;
        for (int index = 0; index < input.get(0).length(); index++) {
            final int x = index;
            var sorted =
                    current.stream().sorted((a, b) -> Integer.compare(b.charAt(x), a.charAt(x)))
                            .collect(Collectors.groupingBy(
                                    a -> a.charAt(x)
                            ))
                            .entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByValue((a,b) -> Integer.compare(b.size(), a.size())))
                            .limit(1)
                            .collect(Collectors.toList())
                    ;

            current = sorted.get(0).getValue();
            System.out.println(current);
        }
    }

    @Test
    public void testPart1() {
        assertEquals(Long.valueOf(2498354), day.part1(input.getLines()));
    }

    @Test
    public void testPart2() {
        assertEquals(Long.valueOf(3277956), day.part2(input.getLines()));
    }
}

