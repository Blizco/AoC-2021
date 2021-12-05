package nl.arjenwiersma.aoc.coolfinds;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

record Point(int x, int y) {

    static List<Integer> range(int start, int end) {
        Stream<Integer> xs;
        if (end > start) {
            xs = IntStream.rangeClosed(start, end).boxed();
        } else {
            xs = IntStream.rangeClosed(end, start)
                    .boxed()
                    .sorted(Collections.reverseOrder());
        }
        return xs.collect(Collectors.toList());
    }

    public List<Point> cover(Point end) {
        var result = new ArrayList<Point>();
        if (this.x == end.x) {
            int min = Math.min(this.y, end.y);
            int max = Math.max(this.y, end.y);
            for (int i = min; i <= max; i++) {
                result.add(new Point(this.x, i));
            }
        } else if (this.y == end.y) {
            int min = Math.min(this.x, end.x);
            int max = Math.max(this.x, end.x);
            for (int i = min; i <= max; i++) {
                result.add(new Point(i, this.y));
            }
        }
        else { // part 2
            var xs = range(this.x, end.x);
            var ys = range(this.y, end.y);
            for (int i = 0; i < xs.size(); i++) {
                result.add(new Point(xs.get(i), ys.get(i)));
            }
        }
        return result;
    }
}

/**
 * Very cool implementation using Java 17 from here: https://www.reddit.com/r/adventofcode/comments/r9824c/comment/hnbya8a/
 */
public class Day05 {

    static List<Point>getPoints(String segment) {
        var ends = Arrays.stream(segment.split(" -> "))
                .map(s -> s.split(","))
                .map(coords -> new Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1])))
                .collect(Collectors.toList());
        System.out.println(ends);
        return ends.get(0).cover(ends.get(1));
    }

    public static void main(String[] args) throws IOException {
        var counter = new HashMap<Point, Integer>();
        Files.readAllLines(Path.of("src/test/resources/input-05.txt")).stream()
                // mag getPoints over each line
                .map(Day05::getPoints)
                // Stream all the lists together
                .flatMap(List::stream)
                // foreach Point in the stream update the counter values
                .forEach(point -> counter.merge(point, 1, Integer::sum));
        var overlappingPoints = counter.values().stream().filter(count -> count > 1).count();
        System.out.println(overlappingPoints);
    }

}