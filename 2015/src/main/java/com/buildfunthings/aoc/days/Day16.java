package com.buildfunthings.aoc.days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.buildfunthings.aoc.common.Day;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

public class Day16 implements Day {

    @ToString
    @RequiredArgsConstructor
    class Sue {
        @NonNull
        int nr;
        Map<String, Integer> props = new HashMap<>();

        boolean isEqualToSue(Sue other) {
            // The current Sue has the same keys for its values
            for (String k : props.keySet()) {
                if (props.get(k) != other.props.get(k)) {
                    return false;
                }
            }
            
            return true;
        }

        boolean isEqualToSuePart2(Sue target) {
            // The current Sue has the same keys for its values
            for (String k : props.keySet()) {
                switch (k) {
                case "cats":
                case "trees":
                    if (props.get(k) <= target.props.get(k)) {
                        return false;
                    }
                    break;
                case "pomeranians":
                case "goldfish":
                    if (props.get(k) > target.props.get(k)) {
                        return false;
                    }
                    break;
                default:
                    if (props.get(k) != target.props.get(k)) {
                        return false;
                    }
                }
            }
            
            return true;
        }
        
        void addProp(String key, Integer value) {
            props.put(key, value);
        }
    }

    Pattern p = Pattern.compile("^Sue (.*?): (.+): (.+), (.+): (.+), (.+): (.+)");

    List<Sue> parseSue(List<String> input) {
        List<Sue> output = new ArrayList<>();
        for (String s : input) {
            //System.out.println(s);
            Matcher m = p.matcher(s);

            if (m.find()) {
                Sue possible = new Sue(Integer.parseInt(m.group(1)));
                for (int i = 2; i <= m.groupCount(); i += 2) {
                    possible.addProp(m.group(i), Integer.parseInt(m.group(i+1)));
                }
                output.add(possible);
            }
        }

        return output;
    }

    Sue target = new Sue(0) {{
        addProp("children", 3);
        addProp("cats", 7);
        addProp("samoyeds", 2);
        addProp("pomeranians", 3);
        addProp("akitas", 0);
        addProp("vizslas", 0);
        addProp("goldfish", 5);
        addProp("trees", 3);
        addProp("cars", 2);
        addProp("perfumes", 1);
    }};
    
	@Override
	public String part1(List<String> input) {

        List<Sue> sues = parseSue(input);
        
        for (Sue s : sues) {
            if (s.isEqualToSue(target)) {
                return String.valueOf(s.nr);
            }
        }        
		return null;
	}

	@Override
	public String part2(List<String> input) {        
        List<Sue> sues = parseSue(input);
        
        for (Sue s : sues) {
            if (s.isEqualToSuePart2(target)) {
                return String.valueOf(s.nr);
            }
        }
		return null;
	}    
}
