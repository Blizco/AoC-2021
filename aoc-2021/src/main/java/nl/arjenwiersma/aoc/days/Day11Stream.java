package nl.arjenwiersma.aoc.days;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nl.arjenwiersma.aoc.common.Day;
import nl.arjenwiersma.aoc.utils.Coord;

public class Day11Stream implements Day<Integer> {

    private Integer simulateCave(Map<Coord, Integer> cave, boolean part1) {
        Deque<Coord> q = new ArrayDeque<>();
        Integer flashes = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            Map<Coord, Boolean> seen = new HashMap<>();

            // increment all
            for (Coord o : cave.keySet()) {
                cave.merge(o, 1, Integer::sum);
                if (cave.get(o) > 9)
                    q.add(o);
            }

            while (!q.isEmpty()) {
                Coord c = q.pop();
                cave.put(c, 0);
                seen.put(c, true);
                flashes += 1;

                for (Coord n : c.getNeighbors()) {
                    // foute coordinaten moeten we niet
                    if (!cave.containsKey(n) || seen.containsKey(n)) {
                        continue;
                    }

                    cave.merge(n, 1, Integer::sum);
                    if (!q.contains(n) && cave.get(n) > 9)
                        q.add(n);
                }

            }

            if (part1 && i == 99)
                return flashes;

            if (!part1 && cave.keySet().stream().allMatch(x -> cave.get(x) == 0)) {
                return i + 1;
            }

        }
        return 0;
    }

    @Override
    public Integer part1(List<String> input) {
        // Coord -> int
        Map<Coord, Integer> cave = new HashMap<>();
        // List<int[]> cave = new ArrayList<>();

        int sizeY = input.size();
        int sizeX = input.get(0).length();

        for (int y = 0; y < sizeY; y++) {
            String row = input.get(y);
            for (int x = 0; x < sizeX; x++) {
                // int[] { y, x, lading}
                cave.put(new Coord(x, y), Integer.parseInt(row.substring(x, x + 1)));
            }
        }

        return simulateCave(cave, true);
    }

    @Override
    public Integer part2(List<String> input) {
        // Coord -> int
        Map<Coord, Integer> cave = new HashMap<>();
        // List<int[]> cave = new ArrayList<>();

        int sizeY = input.size();
        int sizeX = input.get(0).length();

        for (int y = 0; y < sizeY; y++) {
            String row = input.get(y);
            for (int x = 0; x < sizeX; x++) {
                // int[] { y, x, lading}
                cave.put(new Coord(x, y), Integer.parseInt(row.substring(x, x + 1)));
            }
        }

        return simulateCave(cave, false);
    }

}
