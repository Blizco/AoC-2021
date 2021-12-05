package nl.arjenwiersma.aoc.days;

import nl.arjenwiersma.aoc.common.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day05 implements Day<Integer> {
    private int countOverlap(List<String> input, boolean countDiagonal) {
        int[][] grid = new int[1000][1000];
        for (String s : input) {
            String[] pairs = s.trim().split("->");

            List<int[]> coords = new ArrayList<>();
            for (String p : pairs) {
                coords.add(Arrays.stream(p.trim().split(",")).mapToInt(Integer::parseInt).toArray());
            }

            int[] start = coords.get(0);
            int[] end = coords.get(1);

            if (
                    (countDiagonal &&
                            ( // Distance between x1/x2 and y1/y2 is the same
                                    Math.min(start[0], end[0]) - Math.max(start[0], end[0])
                                            ==
                                            Math.min(start[1], end[1]) - Math.max(start[1], end[1])
                            )
                    )
                            ||
                            // horizontal / vertical
                            (start[0] == end[0] || start[1] == end[1])
            ) {
                int stepX = Integer.compare(end[0], start[0]);
                int stepY = Integer.compare(end[1], start[1]);

                int x = start[0];
                int y = start[1];

                while ((x <= end[0] && stepX > 0)
                        ||
                        (x >= end[0] && stepX < 0)
                        ||
                        (y <= end[1] && stepY > 0)
                        ||
                        (y >= end[1] && stepY < 0)
                ) {
                    grid[y][x] += 1;
                    x += stepX;
                    y += stepY;
                }
            }
        }

        return (int) Arrays.stream(grid).flatMapToInt(Arrays::stream).filter(z -> z > 1).count();
    }


    @Override
    public Integer part1(List<String> input) {
        return countOverlap(input, false);
    }


    @Override
    public Integer part2(List<String> input) {
        return countOverlap(input, true);
    }


}