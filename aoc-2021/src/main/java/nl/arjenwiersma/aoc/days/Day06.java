package nl.arjenwiersma.aoc.days;

import nl.arjenwiersma.aoc.common.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Day06 implements Day<Long> {
    private long growSwarm(List<Integer> fish, int days) {
        long[] swarm = new long[9];
        for (Integer f : fish) {
            swarm[f]++;
        }

        for (int day = 1; day <= days; day++) {
            long births = swarm[0];
            System.arraycopy(swarm, 1, swarm, 0, 8);
            swarm[8] = births;
            swarm[6] += births;
        }

        return Arrays.stream(swarm).sum();
    }

    @Override
    public Long part1(List<String> input) {

        List<Integer> fish = Arrays.stream(input.get(0).split(",")).mapToInt(Integer::parseInt).boxed().toList();

        return growSwarm(fish,80);

    }

    @Override
    public Long part2(List<String> input) {
        List<Integer> fish = Arrays.stream(input.get(0).split(",")).mapToInt(Integer::parseInt).boxed().toList();

        return growSwarm(fish, 256);
    }
}