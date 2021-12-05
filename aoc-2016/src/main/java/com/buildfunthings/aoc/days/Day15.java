package com.buildfunthings.aoc.days;

import com.buildfunthings.aoc.common.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day15 implements Day<Integer> {
    record Disc(int id, int positions, int startpos) {
        boolean hasGap(int dropTime) {
            return (dropTime + id + startpos) % positions == 0;
        }
    }




    private List<Disc> getDiscs(List<String> input) {
        Pattern p = Pattern.compile("#(\\d+) has (\\d+) positions; at time=(\\d+), it is at position (\\d+).");

        List<Disc> discs = new ArrayList<>();

        for (String in : input) {
            Matcher m = p.matcher(in);
            if (m.find()) {
                discs.add(new Disc(
                        Integer.parseInt(m.group(1)),
                        Integer.parseInt(m.group(2)),
                        Integer.parseInt(m.group(4))));
            }
        }
        return discs;
    }

    private int getGapTime(List<Disc> discs) {
        int dropTime = 0;
        while (true) {
            int d = dropTime;
            if (discs.stream().allMatch(x -> x.hasGap(d))) {
                return d;
            }
            dropTime++;
        }
    }
    @Override
    public Integer part1(List<String> input) {
        List<Disc> discs = getDiscs(input);

        return getGapTime(discs);
    }

    @Override
    public Integer part2(List<String> input) {
        List<Disc> discs = getDiscs(input);

        discs.add(new Disc(discs.size() + 1,11,0));

        return getGapTime(discs);
    }
}