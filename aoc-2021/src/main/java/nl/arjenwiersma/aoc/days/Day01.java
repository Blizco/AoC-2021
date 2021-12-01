package nl.arjenwiersma.aoc.days;

import java.util.List;

import nl.arjenwiersma.aoc.common.Day;

public class Day01 implements Day<Integer> {

    @Override
    public Integer part1(List<String> input) {
        int larger = 0;
        Integer last = null;

        int[] nums = input.stream().mapToInt(x -> Integer.parseInt(x)).toArray();

        for (int s : nums) {

            if (last != null && s > last) {
                larger++;
            }

            last = s;
        }
        return larger;
    }

    @Override
    public Integer part2(List<String> input) {
        int larger = 0;

        int[] nums = input.stream().mapToInt(x -> Integer.parseInt(x)).toArray();

        Integer last = null;
        for (int i = 0; i < nums.length - 2; i++) {
            int sum = nums[i] + nums[i + 1] + nums[i + 2];

            if (last != null && sum > last) {
                larger++;
            }

            last = sum;
        }
        
        return larger;
    }
    
}
