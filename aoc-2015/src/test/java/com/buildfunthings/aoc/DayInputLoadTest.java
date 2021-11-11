package com.buildfunthings.aoc;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class DayInputLoadTest {

    /**
     * Rule to load the test input for day 99
     */
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(99);

    /**
     * Ensure we get all the lines in the input file from the Rule.
     */
    @Test
    public void testDAyInputLoad() {
        final List<String> lines = input.getLines();

        assertEquals("this-is-test-99", lines.get(0));
    }
}
