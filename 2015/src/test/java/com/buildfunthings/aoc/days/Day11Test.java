package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day11Test {

    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(11);

    @Test
    public void testCharToInt() {
        assertEquals(97, (int) 'a');
        assertEquals(122, (int) 'z');

        // Convert a String to integers
        String test = "abc";
        int[] converted = test.chars().toArray();
        assertArrayEquals(new int[] {97,98,99}, converted);
    }

    @Test
    public void testConditionals() {
        Day11 d = new Day11();

        assertTrue(d.containsStraight("abc"));
        assertTrue(d.containsStraight("gfdhabc"));
        assertFalse(d.containsStraight("dfsdgad"));

        assertTrue(d.noForbiddenChars("abc"));
        assertFalse(d.noForbiddenChars("abci"));
        assertFalse(d.noForbiddenChars("abco"));
        assertFalse(d.noForbiddenChars("abcl"));

        assertFalse(d.containsTwoPairs("abcl"));
        // only 1 pair
        assertFalse(d.containsTwoPairs("aacl"));
        assertFalse(d.containsTwoPairs("aaal"));
        // two the same pairs
        assertTrue(d.containsTwoPairs("aabb"));


        String step = "abcdefgh";
        String step2 = "abcdefgi";

        assertEquals(step2, Long.toString(Long.parseLong(step, 36) + 1, 36).replace('0', 'a'));


    }
    
    @Test
    public void testSampleInput1() {
        Map<String, String> tests = new HashMap<>() {{
                put("abcdefgh", "abcdffaa");
            }
            };

        for (String k : tests.keySet()) {
            Day day = new Day11();
            assertEquals(tests.get(k), day.part1(new ArrayList<String>() {{ add(k); }}));
        }
    }

    @Test
    public void testSampleInput2() {
    }

    @Test
    public void testRealInput() {
        Day day = new Day11();
        assertEquals("vzbxxyzz", day.part1(input.getLines()));
        assertEquals("vzcaabcc", day.part2(input.getLines()));
    }
}
