package nl.arjenwiersma.aoc.utils;

import java.util.ArrayList;
import java.util.List;

public record Coord(int x, int y) {
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coord other = (Coord) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    public List<Coord> coordsBetween(Coord coord) {
        int stepX = Integer.compare(coord.x, x);
        int stepY = Integer.compare(coord.y, y);

        int dx = x;
        int dy = y;

        List<Coord> coords = new ArrayList<>();
        while ((dx <= coord.x && stepX > 0)
                ||
                (dx >= coord.x && stepX < 0)
                ||
                (dy <= coord.y && stepY > 0)
                ||
                (dy >= coord.y && stepY < 0)
        ) {
            coords.add(new Coord(dx, dy));
            dx += stepX;
            dy += stepY;
        }
        return coords;
    }

    // flags: out of board / wel of niet diagonaal
    public List<Coord> getNeighbors() {
        List<Coord> neighbors = new ArrayList<>();

        for (int[] neighbor : new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 },
                { 1, 0 }, { 1, 1 } }) {
            neighbors.add(new Coord(x + neighbor[1], y + neighbor[0]));
        }

        return neighbors;
    }
}
