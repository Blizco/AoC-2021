package nl.arjenwiersma.aoc.days;

import java.util.List;
import java.util.stream.Collectors;

import nl.arjenwiersma.aoc.common.Day;
import nl.arjenwiersma.aoc.utils.SlidingWindowSpliterator;

import static nl.arjenwiersma.aoc.utils.SlidingWindowSpliterator.windowed;

public class Day01 implements Day<Integer> {
    @Override
    public Integer part1(List<String> input) {
        int[] n = input.stream().mapToInt(Integer::parseInt).toArray();
        return getCountIncreased(n, 1);
    }

    @Override
    public Integer part2(List<String> input) {
        int[] n = input.stream().mapToInt(Integer::parseInt).toArray();
        return getCountIncreased(n, 3);
    }

    int getCountIncreased(int[] n, int step) {
        int howmany = 0;
        for (int i = step; i < n.length; ++i) {
            int sum1 = 0;
            int sum2 = 0;

            for (int x = -1 * step; x < 0; x++) {
                sum1 += n[i + x];
                sum2 += n[i + (x+1)];
            }

            if (sum1 < sum2) {
                howmany++;
            }
        }
        return howmany;
    }
    
}
