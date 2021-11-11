package com.buildfunthings.aoc.days;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import com.buildfunthings.aoc.common.Day;

public class Day08 implements Day<Integer> {

    public int countLength(Stream<String> stream, Function<String, String> mapper) {
        return stream.map(mapper).mapToInt(s -> s.length()).sum();        
    }
    
    Function<String, String> nop = s -> s;
    
    @Override
    public Integer part1(List<String> input) {
        int codeLiteral = countLength(input.stream(), nop);
        int inMemory = countLength(input.stream(),
                                   nop
                                   .andThen(s -> s.replaceAll("^\"", ""))
                                   .andThen(s -> s.replaceAll("\"$", ""))
                                   .andThen(s -> s.replaceAll("\\\\", "@"))
                                   .andThen(s -> s.replaceAll("@\\\"", "#"))
                                   .andThen(s -> s.replaceAll("@@", "!"))
                                   .andThen(s -> s.replaceAll("@x..", "%"))
                                   );

        return codeLiteral - inMemory;
    }

    @Override
    public Integer part2(List<String> input) {
        int codeLiteral = countLength(input.stream(), nop);
        int encoded = countLength(input.stream(),
                                  nop
                                  .andThen(s -> s.replaceAll("^\"", "@@@"))
                                  .andThen(s -> s.replaceAll("\"$", "@@@"))
                                  .andThen(s -> s.replaceAll("\"", "@@"))
                                  .andThen(s -> s.replaceAll("\\\\", "@@"))
                                  );

        return encoded - codeLiteral;
    }
}
