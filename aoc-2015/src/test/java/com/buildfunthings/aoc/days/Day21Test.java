package com.buildfunthings.aoc.days;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.buildfunthings.aoc.common.DayInputExternalResource;

import org.junit.Rule;
import org.junit.Test;

public class Day21Test {
    @Rule
    public DayInputExternalResource input = new DayInputExternalResource(21);

    /*
      For example, suppose you have 8 hit points, 5 damage, and 5 armor, and that the boss has 12 hit points, 7 damage, and 2 armor:

      The player deals 5-2 = 3 damage; the boss goes down to 9 hit points.
      The boss deals 7-5 = 2 damage; the player goes down to 6 hit points.
      The player deals 5-2 = 3 damage; the boss goes down to 6 hit points.
      The boss deals 7-5 = 2 damage; the player goes down to 4 hit points.
      The player deals 5-2 = 3 damage; the boss goes down to 3 hit points.
      The boss deals 7-5 = 2 damage; the player goes down to 2 hit points.
      The player deals 5-2 = 3 damage; the boss goes down to 0 hit points.

     */
    @Test
    public void testSampleInput() {
        Day21 d = new Day21();
        Day21.Game g = d.newGame(12,7,2,8,5,5);

        assertTrue(g.play());

        g = d.newGame(103,9,2,100,8,0);
        
        assertTrue(!g.play());
    }

    @Test
    public void testRealInput() {
        Day21 day = new Day21();
        assertEquals(Integer.valueOf(121), day.part1(input.getLines()));
        assertEquals(Integer.valueOf(201), day.part2(input.getLines()));
    }

}
