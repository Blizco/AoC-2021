package nl.arjenwiersma.aoc.utils;

import static nl.arjenwiersma.aoc.utils.SlidingWindowSpliterator.windowed;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class SlidingWindowSpliteratorTest {

    @Test
    public void shouldApplySlidingWindow() {
        var source = List.of(1,2,3,4);
        
        var result = windowed(source, 3)
          .map(s -> s.collect(Collectors.toList()))
          .collect(Collectors.toList());

        assertEquals(List.of(1,2,3), result.get(0));
        assertEquals(List.of(2,3,4), result.get(1));
    }

    @Test
    public void shouldApplySlidingWindowToString() {
        List<String> source = Arrays.stream("Arjen".split("")).toList();
        
        var result = windowed(source, 3)
          .map(s -> s.collect(Collectors.toList()))
          .collect(Collectors.toList());

        assertEquals(List.of("A","r","j"), result.get(0));
        assertEquals(List.of("r","j","e"), result.get(1));
        assertEquals(List.of("j","e","n"), result.get(2));
    }
    
}
