package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.buildfunthings.aoc.common.Day;
import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day18Test {

    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(18);

    @Test
    public void testSampleInput() {
        List<String> input = new ArrayList<>() {
            {
                add(".#.#.#");
                add("...##.");
                add("#....#");
                add("..#...");
                add("#.#..#");
                add("####..");
            }
        };

        Day18 d = new Day18();
        int[][] grid = d.createGrid(6);
        d.setGridState(grid, input);
        //d.printGrid(grid);
        for (int i = 0; i < 5; i++) {
            //System.out.println();
            int[][] ev1 = d.evolveGrid(grid, 1);
            //d.printGrid(ev1);
            grid = ev1;
        }
        assertEquals(4, d.countOn(grid));
    }

    @Test
    public void testSampleInput2() {
        List<String> input = new ArrayList<>() {
            {
                add("##.#.#");
                add("...##.");
                add("#....#");
                add("..#...");
                add("#.#..#");
                add("####.#");
            }
        };

        Day18 d = new Day18();
        int[][] grid = d.createGrid(6);
        d.setGridState(grid, input);
        //d.printGrid(grid);
        for (int i = 0; i < 5; i++) {
            //System.out.println();
            int[][] ev1 = d.evolveGrid(grid, 2);
            //d.printGrid(ev1);
            grid = ev1;
        }

        assertEquals(17, d.countOn(grid));
    }

    @Test
    public void testRealInput() {
        Day<Integer> day = new Day18();
        assertEquals(Integer.valueOf(768), day.part1(input.getLines()));
        assertEquals(Integer.valueOf(781), day.part2(input.getLines()));
    }
}
