package com.buildfunthings.aoc.days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import com.buildfunthings.aoc.common.Day;

public class Day19 implements Day<Integer> {

    private Map<String, List<String>> conversions = new HashMap<>();
    private Map<String, String> reversed = new HashMap<>();
    private String medicine;

    private void addConversion(String from, String to) {
        if (conversions.containsKey(from)) {
            conversions.get(from).add(to);
        } else {
            List<String> targets = new ArrayList<>() {
                {
                    add(to);
                }
            };
            conversions.put(from, targets);
        }
        reversed.put(to, from);
    }

    private void readInput(List<String> input) {

        for (String s : input) {
            if (s.isEmpty()) {
                break;
            }
            String[] elems = s.split("=>");

            addConversion(elems[0].trim(), elems[1].trim());
        }

        medicine = input.get(input.size() - 1);
    }

    private void reset() {
        conversions.clear();
        reversed.clear();
    }

    @Override
    public Integer part1(List<String> input) {
        reset();
        readInput(input);

        Set<String> gens = new HashSet<>();
        for (String c : conversions.keySet()) {
            List<String> replacements = conversions.get(c);

            int pos = -1;
            do {
                pos = medicine.indexOf(c, pos + 1);
                if (pos == -1) {
                    break;
                }

                for (String r : replacements) {
                    String mod = medicine.substring(0, pos) + r + medicine.substring(pos + c.length());
                    gens.add(mod);
                }
            } while (pos >= 0);
        }

        return gens.size();
    }

    @Override
    public Integer part2(List<String> input) {
        reset();
        readInput(input);

        PriorityQueue<SearchNode> q = new PriorityQueue<>();
        q.add(new SearchNode(medicine.length(), 0, medicine));

        while (true) {
            SearchNode n = q.poll();
            if (n == null) {
                System.out.println("FAILED");
                System.exit(0);
            }

            if (n.attempt.equals("e")) {
                return n.iteration;
            }

            MedicineIter mi = new MedicineIter(n.attempt);
            for (String at : mi) {
                q.add(new SearchNode(at.length(), n.iteration + 1, at));
            }

        }
    }

    class MedicineIter implements Iterable<String> {
        String med;

        public MedicineIter(String med) {
            this.med = med;
        }

        public Iterator<String> iterator() {
            List<String> items = new ArrayList<>();

            for (String k : reversed.keySet()) {
                int pos = med.indexOf(k);
                while (pos >= 0) {
                    items.add(med.substring(0, pos) + reversed.get(k) + med.substring(pos + k.length()));
                    pos = med.indexOf(k, pos + 1);
                }
            }

            return new Iterator<String>() {
                @Override
                public boolean hasNext() {
                    return !items.isEmpty();
                }

                @Override
                public String next() {
                    return items.remove(0);
                }
            };
        }
    }

    class SearchNode implements Comparable<SearchNode> {
        int length;
        int iteration;
        String attempt;

        public SearchNode(int length, int iteration, String attempt) {
            this.length = length;
            this.iteration = iteration;
            this.attempt = attempt;
        }

        @Override
        public int compareTo(SearchNode o) {
            if (length == o.length) {
                return 0;
            } else if (length > o.length) {
                return 1;
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return "SearchNode [attempt=" + attempt + ", iteration=" + iteration + ", length=" + length + "]";
        }

    }
}
