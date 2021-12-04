package nl.arjenwiersma.aoc.days;

import lombok.ToString;
import nl.arjenwiersma.aoc.common.Day;

import java.util.*;

public class Day04 implements Day<Integer> {
    public int playGame(List<String> input, int index) {
        List<int[][]> boards = new ArrayList<>();

        int[] nums = Arrays.stream(input.get(0).split(",")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i < input.size(); i += 6) {
            int[][] b = new int[5][5];

            for (int x = 1; x <= 5; x++) {
                int col = 0;
                for (int v : Arrays.stream(input.get(i + x).trim().split("\\s+")).mapToInt(Integer::parseInt).toArray()) {
                    b[x-1][col++] = v;
                }
            }
            boards.add(b);
        }

        List<Integer> sols = new ArrayList<>();
        Map<Integer, Integer> vals = new HashMap<>();
        for (int n : nums) {
            for (int bn = 0; bn < boards.size(); bn++) {
                int[][] b = boards.get(bn);
                for (int x = 0; x < 5; x++) {
                    for (int y=0; y < 5; y++) {
                        if (!sols.contains(bn)) {
                            if (b[x][y] == n) b[x][y] = -1; // mark it as BINGO-ed

                            if (b[y][0] + b[y][1] + b[y][2] + b[y][3] + b[y][4] == -5 ||
                                    b[0][x] + b[1][x] + b[2][x] + b[3][x] + b[4][x] == -5) {
                                int s = Arrays.stream(b).flatMapToInt(Arrays::stream).filter(z -> z != -1).sum();
                                sols.add(bn); // Add the bingo card at the time it hash BINGO
                                vals.put(bn, s*n);
                            }
                        }
                    }
                }
            }
        }

        return vals.get(sols.get(index == -1 ? sols.size() - 1 : index));
    }


    @Override
    public Integer part1(List<String> input) {
        return playGame(input, 0);
    }

    @Override
    public Integer part2(List<String> input) {
        return playGame(input, -1);
    }
}

