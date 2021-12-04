package nl.arjenwiersma.aoc.days;

import lombok.ToString;
import nl.arjenwiersma.aoc.common.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day04 implements Day<Integer> {
    @ToString
    class Cell {
        int value;
        boolean seen = false;

        public Cell(int v) {
            this.value = v;
        }
    }

    @ToString
    class Row {
        Cell[] cells = new Cell[5];
    }

    @ToString
    class Bingo {
        Row[] rows = new Row[5];

        boolean processNumber(int num) {
            for (Row r : rows) {
                for (Cell c : r.cells) {
                    if (c.value == num) {
                        c.seen = true;
                    }
                }
            }
            return hasBingo();
        }

        boolean hasBingo() {
            // check rows
            for (Row r : rows) {
                //System.out.println("ROW: " + r);
                if (Arrays.stream(r.cells).allMatch(c -> c.seen)) {
                    return true;
                }
            }

            // check cols
            for (int i = 0; i < 5; i++) {
                boolean bingo = true;
                for (Row r : rows) {
                    if (!r.cells[i].seen) {
                        bingo = false;
                        break;
                    }
                }
                if (bingo) {
                    return true;
                }
            }
            return false;
        }

        int sumUnmarked() {
            int v = 0;
            for (Row r : rows) {
                for (Cell c : r.cells) {
                    //System.out.println(v + " " + c.value + " " + c.seen);
                    v += c.seen ? 0 : c.value;
                }
            }
            return v;
        }

        void printBoard() {
            for (Row r : rows) {
                for (Cell c : r.cells) {
                    System.out.printf("%02d%s", c.value, (c.seen? "!" : " "));
                }
                System.out.println();
            }
        }
    }

    private int[] parseBoards(List<String> input, List<Bingo> bingos) {
        int[] nums = Arrays.stream(input.get(0).split(",")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i < input.size(); i += 6) {
            Bingo b = new Bingo();
            for (int x = 1; x <= 5; x++) {
                Row r = new Row();
                int c = 0;
                for (int v : Arrays.stream(input.get(i + x).trim().split("\\s+")).mapToInt(Integer::parseInt).toArray()) {
                    r.cells[c++] = new Cell(v);
                }
                b.rows[x - 1] = r;
            }
            bingos.add(b);
        }
        return nums;
    }

    @Override
    public Integer part1(List<String> input) {
        List<Bingo> bingos = new ArrayList<>();

        int[] nums = parseBoards(input, (List<Bingo>) bingos);

        for (int n : nums) {
            int max = 0;
            for (Bingo b : bingos) {
                if (b.processNumber(n)) {
                    max = Math.max(b.sumUnmarked(), max);
                }
            }
            if (max > 0) return max * n;
        }
        return 0;
    }

    @Override
    public Integer part2(List<String> input) {
        List<Bingo> bingos = new ArrayList<>();

        int[] nums = parseBoards(input, bingos);

        for (int n : nums) {
            List<Bingo> remaining = new ArrayList<>(bingos);
            for (Bingo b : remaining) {
                if (b.processNumber(n)) { // bingo!
                    if (bingos.size() == 1) { // last one has bingo
                        return bingos.get(0).sumUnmarked() * n;
                    }
                    bingos.remove(b);
                }
            }
        }
        return 0;
    }
}

