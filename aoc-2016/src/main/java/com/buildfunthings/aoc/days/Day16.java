package com.buildfunthings.aoc.days;

import com.buildfunthings.aoc.common.Day;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Day16 implements Day<String> {
    public String curve(String input) {
        String b = new StringBuffer(input).reverse().toString();
        String tr = b.chars().map(x -> x == '1' ? '0' : '1')
                .collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append)
                .toString();

        return input + "0" + tr;
    }

    private String createChecksum(String s) {
        do {
            List<List<Integer>> cs = Lists.partition(s.chars().boxed().toList(), 2);
            var check = cs.stream().map(x -> Objects.equals(x.get(0), x.get(1)) ? '1' : '0').collect(Collectors.toList());
            s = check.stream().collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append).toString();
        } while (s.length() % 2 == 0);
        return s;
    }

    public String checksum(String start, int disksize) {
        String garbage = start;
        while (garbage.length() <= disksize) {
            garbage = curve(garbage);
        }
        String filler = garbage.substring(0, disksize);

        return createChecksum(filler);
    }


    @Override
    public String part1(List<String> input) {
        String in = input.get(0);
        return checksum(in, 272);
    }

    @Override
    public String part2(List<String> input) {
        String in = input.get(0);
        return checksum(in, 35651584);
    }


}