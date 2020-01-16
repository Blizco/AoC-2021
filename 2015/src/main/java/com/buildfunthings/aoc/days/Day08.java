package com.buildfunthings.aoc.days;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import com.buildfunthings.aoc.common.Day;

public class Day08 implements Day {

    public int countLength(Stream<String> stream, Function<String, String> mapper) {
        return stream.map(mapper).mapToInt(s -> s.length()).sum();        
    }
    
    Function<String, String> nop = s -> s;
    
	@Override
	public String part1(List<String> input) {
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

		return String.valueOf(codeLiteral - inMemory);
	}

	@Override
	public String part2(List<String> input) {
        int codeLiteral = countLength(input.stream(), nop);
        int encoded = countLength(input.stream(),
                                  nop
                                  .andThen(s -> s.replaceAll("^\"", "@@@"))
                                  .andThen(s -> s.replaceAll("\"$", "@@@"))
                                  .andThen(s -> s.replaceAll("\"", "@@"))
                                  .andThen(s -> s.replaceAll("\\\\", "@@"))
                                  );

		return String.valueOf(encoded - codeLiteral);
	}

}
