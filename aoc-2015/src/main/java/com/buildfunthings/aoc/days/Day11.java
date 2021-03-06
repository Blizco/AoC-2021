package com.buildfunthings.aoc.days;

import java.util.List;
import java.util.regex.Pattern;

import com.buildfunthings.aoc.common.Day;

public class Day11 implements Day<String> {

    boolean containsStraight(String candidate) {
        return Pattern.matches(".*(abc|bcd|cde|def|efg|fgh|pqr|qrs|rst|stu|tuv|uvw|vwx|wxy|xyz).*", candidate);
    }

    boolean noForbiddenChars(String candidate) {
        return !Pattern.matches(".*[iol].*", candidate);
    }

    boolean containsTwoPairs(String candidate) {
        return Pattern.matches(".*(.)\\1.*(.)\\2.*", candidate);
    }

    boolean isValid(String candidate) {
        return containsStraight(candidate) &&
                noForbiddenChars(candidate) &&
                containsTwoPairs(candidate);
    }

    String increment(String candidate) {
        return Long.toString(Long.parseLong(candidate, 36) + 1, 36).replace('0', 'a');
    }
        
	@Override
	public String part1(List<String> input) {

        String password = increment(input.get(0));

        while (!isValid(password)) {
            password = increment(password);
        }

        return password;
	}

	@Override
	public String part2(List<String> input) {
        String password = increment(input.get(0));

        while (!isValid(password)) {
            password = increment(password);
        }

        password = increment(password);
        while (!isValid(password)) {
            password = increment(password);
        }
        return password;
	}
    
}
