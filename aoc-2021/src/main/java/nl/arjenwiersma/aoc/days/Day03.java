package nl.arjenwiersma.aoc.days;

import nl.arjenwiersma.aoc.common.Day;

import java.util.ArrayList;
import java.util.List;

public class Day03 implements Day<Long> {
    @Override
    public Long part1(List<String> input) {
        StringBuilder gamma = new StringBuilder();

        int[] pos = new int[input.get(0).length()];
        for (String in : input) {
            for (int i = 0; i < in.length(); i++) {
                pos[i] += (in.charAt(i) - 48);
            }
        }

        for (int p : pos) {
            int half = input.size() / 2;
            gamma.append(p > half ? "1" : "0");
        }

        final long gammaNum = Long.valueOf(gamma.toString(), 2);
        return gammaNum * (gammaNum ^ (long) (Math.pow(2, input.get(0).length()) - 1));
    }

    public List<String> findSubset(List<String> set, int index, boolean dominant) {
        List<String> zeros = new ArrayList<>();
        List<String> ones = new ArrayList<>();

        for (String in : set) {
            if (in.charAt(index) == '1') {
                ones.add(in);
            } else {
                zeros.add(in);
            }
        }

        if (dominant && ones.size() >= (set.size() - ones.size())) {
            return ones;
        } else if (!dominant && ones.size() < (set.size() - ones.size())) {
            return ones;
        } else {
            return zeros;
        }
    }

    private int findNumber(List<String> input, boolean dominant) {
        List<String> current = input;
        for (int i = 0; i < input.get(0).length(); i++) {
            current = findSubset(current, i, dominant);
            //System.out.println(current);
            if (current.size() == 1)
                break;
        }
        return Integer.valueOf(current.get(0), 2);
    }

    @Override
    public Long part2(List<String> input) {
        int oxygen = findNumber(input, true);
        int co2 = findNumber(input, false);

        return (long) oxygen * co2;
    }

}
