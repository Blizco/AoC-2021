package com.buildfunthings.aoc.days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.buildfunthings.aoc.common.Day;

public class Day13 implements Day<Integer> {    
    int magic = 0;

    public class Coord implements Comparable<Coord> {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (!(obj instanceof Coord)) {
                return false;
            }

            Coord c = (Coord) obj;

            return x == c.x && y == c.y;
        }

        
        @Override
        public int compareTo(Coord o) {
            int cmp = Integer.compare(x, o.x);
            if (cmp == 0)
                cmp = Integer.compare(y, o.y);
            return cmp;
        }

        @Override
        public String toString() {
            return x + "," + y;
        }

         @Override
         public int hashCode() {
             int result = 17;

             result = 31 * result + x;
             result = 31 * result + y;
             
             return result;
         }
        
    }


    public boolean isOpen(int x, int y) {
        return Integer.bitCount(x * x + 3 * x + 2 * x * y + y + y * y + magic) % 2 == 0;
    }


    private Coord[] getNeighbors(Coord last) {
        List<Coord> cs = new ArrayList<>();
        for (int x : new int[] {-1,1}) {
            if (last.x + x >= 0) {
                cs.add(new Coord(last.x + x, last.y));
            }
        }
        for (int y : new int[] {-1,1}) {
            if (last.y + y >= 0) {
                cs.add(new Coord(last.x, last.y + y));
            }
        }
        return cs.toArray(new Coord[0]);
    }

    public List<List<Coord>> findPathsTo(int x, int y) {
        List<List<Coord>> valid = new ArrayList<>();
        PriorityQueue<List<Coord>> paths = new PriorityQueue<>((a,b)-> (a.size() - b.size()));

        paths.add(new ArrayList<Coord>() {{
            add(new Coord(1,1));
            }
        });

        while (!paths.isEmpty()) {
            List<Coord> current = paths.poll();
            //System.out.println(current);
            // Take the last coordinate from the path
            Coord last = current.get(current.size() - 1);
            // find all neighbors that are not in the path already
            Coord[] neighbors = getNeighbors(last);
            for (Coord n : neighbors) {
                if (isOpen(n.x, n.y) && !current.contains(n)) {
                    // if open, create a new path and add to queue
                    List<Coord> newPath = new ArrayList<>(current);
                    newPath.add(n);
                    paths.add(newPath);

                    if (n.x == x && n.y == y) {
                        // if coordinate is target coordinate, add to list of valid paths
                        valid.add(newPath);
                    }
                }
            }
        }
        return valid;
    }

    public List<List<Coord>> pathsOfNSteps(int steps) {
        List<List<Coord>> valid = new ArrayList<>();
        PriorityQueue<List<Coord>> paths = new PriorityQueue<>((a,b)-> (a.size() - b.size()));

        paths.add(new ArrayList<Coord>() {{
            add(new Coord(1,1));
            }
        });

        while (!paths.isEmpty()) {
            List<Coord> current = paths.poll();
            //System.out.println(current);
            // Take the last coordinate from the path
            Coord last = current.get(current.size() - 1);
            // find all neighbors that are not in the path already
            Coord[] neighbors = getNeighbors(last);
            boolean dead = true;
            for (Coord n : neighbors) {
                if (isOpen(n.x, n.y) && !current.contains(n)) {
                    // if open, create a new path and add to queue
                    List<Coord> newPath = new ArrayList<>(current);
                    newPath.add(n);
                    if ((newPath.size()-1) == steps) {
                        valid.add(newPath);
                    } else {
                        paths.add(newPath);
                    }
                    dead = false;
                }
            }
            if (dead) { // If there is a dead end (and less then N steps) add it to the list
                valid.add(current);
            }
        }
        return valid;
    }

    
    @Override
    public Integer part1(List<String> input) {
        magic = Integer.parseInt(input.get(0));

        var valid = findPathsTo(31, 39);
        return valid.stream().mapToInt(x -> x.size()).min().getAsInt() - 1;
    }


    @Override
    public Integer part2(List<String> input) {
        magic = Integer.parseInt(input.get(0));

        var valid = pathsOfNSteps(50);
        Map<Coord,Integer> unique = new HashMap<>();

        for (List<Coord> cl : valid) {
            for (Coord c : cl) {
                unique.merge(c, Integer.valueOf(1), Integer::sum);
            }
        }

        return unique.size();
    }
    
}
