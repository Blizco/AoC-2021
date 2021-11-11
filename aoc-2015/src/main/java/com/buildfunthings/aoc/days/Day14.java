package com.buildfunthings.aoc.days;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.buildfunthings.aoc.common.Day;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Day14 implements Day<Integer> {

    @AllArgsConstructor
    class Reindeer {
        String name;
        int km;
        int sec;
        int rest;
        @Getter
        int bonus;
        // Vixen can fly 19 km/s for 7 seconds, but then must rest for 124 seconds.

        int distanceAfterSeconds(int seconds) {
            int leftOver = seconds % (sec + rest);
            int moveable = seconds - leftOver;
            int cycles = (moveable / (sec + rest)) + 1;
            return cycles * sec * km;
        }

        int distanceAtSeconds(int seconds) {
            int leftOver = seconds % (sec + rest);
            int moveable = (seconds <= sec ? seconds : seconds - leftOver);
            int cycles = (moveable / (sec + rest));
            
            return (cycles * sec * km) + ((leftOver > sec ? sec : leftOver) * km);
        }
        
        void addBonus() {
            bonus++;
        }
    }

    Reindeer fromString(String description) {
        String[] parts = description.split(" ");
        return new Reindeer(parts[0], Integer.parseInt(parts[3]), Integer.parseInt(parts[6]),
                            Integer.parseInt(parts[13]), 0);
    }

    @Override
    public Integer part1(List<String> input) {
        int max = input.stream().map(this::fromString).mapToInt(r -> r.distanceAfterSeconds(2503)).max().getAsInt();
        return max;
    }

    @Override
    public Integer part2(List<String> input) {
        List<Reindeer> race = input.stream().map(this::fromString).collect(Collectors.toList());
        
        // The seconds of the race
        for (int s = 1; s <= 2503; s++) {
            int maxDist = 0;
            List<Reindeer> leaders = new ArrayList<>();
            for (Reindeer r : race) {
                int dist = r.distanceAtSeconds(s);
                if (dist == maxDist) {
                    leaders.add(r);
                } else if (dist > maxDist) {
                    leaders.clear();
                    leaders.add(r);
                    maxDist = dist;
                }
            }

            for (Reindeer leader : leaders) {
                leader.addBonus();
                //System.out.println(s + ": " + leader);
            }
            leaders.clear();
        }

        Reindeer mostPoints = null;
        for (Reindeer r : race) {
            if (mostPoints == null)
                mostPoints = r;
            else if (r.getBonus() > mostPoints.getBonus())
                mostPoints = r;
        }

        //System.out.println("Winner: " + mostPoints);
        
        return mostPoints.getBonus();
    }

}
