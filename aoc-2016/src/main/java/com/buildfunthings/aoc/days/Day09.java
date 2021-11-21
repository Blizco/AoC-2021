package com.buildfunthings.aoc.days;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.buildfunthings.aoc.common.Day;

public class Day09 implements Day<Long> {

    public Long decompress(String string, Boolean recurse) {
        char[] chars = string.toCharArray();

        boolean marker = false;
        int l = 0;
        int r = 0;
        long counter = 0L;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < chars.length;) {

            if (chars[i] == '(' && marker == false) {
                temp = new StringBuilder();
                i++;
                marker = true;
            } else if (chars[i] == ')' && marker == true) {
                r = Integer.parseInt(temp.toString());
                i++;
                marker = false;

                counter += r * (recurse ? decompress(string.substring(i, i+l) , true)
                                : l );
                i += l;
            } else {
                if (marker) {
                    if (chars[i] == 'x') {
                        l = Integer.parseInt(temp.toString());
                        temp = new StringBuilder();
                    } else {
                        temp.append(chars[i]);
                    }
                } else {
                    counter++;                    
                }
                i++;
            }
        }

        return counter;
    }

    @Override
    public Long part1(List<String> input) {
        Long l = 0L;

        for (String in : input) {
            l += decompress(in, false);
        }

        return l;
    }

    @Override
    public Long part2(List<String> input) {
        Long l = 0L;

        for (String in : input) {
            l += decompress(in, true);
        }

        return l;
    }
}
