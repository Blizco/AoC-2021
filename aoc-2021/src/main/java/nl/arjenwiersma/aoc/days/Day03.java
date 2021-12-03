package nl.arjenwiersma.aoc.days;

import nl.arjenwiersma.aoc.common.Day;

import java.util.ArrayList;
import java.util.List;

public class Day03 implements Day<Long> {
    @Override
    public Long part1(List<String> input) {
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();

        int[] pos = new int[input.get(0).length()];
        for (String in : input) {
            for (int i = 0; i < in.length(); i++) {
                pos[i] += (in.charAt(i) - 48);
            }
        }

        for (int p : pos) {
            int half = input.size() / 2;
            if (p > half) {
                gamma.append("1");
                epsilon.append("0");
            } else {
                gamma.append("0");
                epsilon.append("1");
            }
        }
//        System.out.println(gamma);
//        System.out.println(epsilon);
        // loop over pos, maak gamma / epsilon strings

        return Long.valueOf(gamma.toString(), 2) * Long.valueOf(epsilon.toString(), 2);
    }

    public List<String> findSubset(List<String> set, int index, boolean dominant) {
        List<String> zeros = new ArrayList<>();
        List<String> ones = new ArrayList<>();

        int count = 0;

        for (String in : set) {
            //count += in.charAt(index) == '1' ? 1 : 0;
            int x = (in.charAt(index) - 48);
            count += x;
            if (x == 1) {
                ones.add(in);
            } else {
                zeros.add(in);
            }
        }

        if (dominant && count >= (set.size() - count)) {
            return ones;
        } else if (!dominant && count < (set.size() - count)) {
            return ones;
        } else {
            return zeros;
        }
    }

    @Override
    public Long part2(List<String> input) {
        int oxygen = 0, co2 = 0;

        List<String> current = input;
        for (int i = 0; i < input.get(0).length(); i++) {
            current = findSubset(current, i, true);
            //System.out.println(current);
            if (current.size() == 1)
                break;
        }

        oxygen = Integer.valueOf(current.get(0), 2);

        current = input;
        for (int i = 0; i < input.get(0).length(); i++) {
            current = findSubset(current, i, false);
            //System.out.println(current);
            if (current.size() == 1)
                break;
        }
        co2 = Integer.valueOf(current.get(0), 2);

        return (long) oxygen * co2;
    }
}
