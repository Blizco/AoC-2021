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
    
	@Override
	public String part1(List<String> input) {
        Sue target = new Sue(0);
        target.addProp("children", 3);
        target.addProp("cats", 7);
        target.addProp("samoyeds", 2);
        target.addProp("pomeranians", 3);
        target.addProp("akitas", 0);
        target.addProp("vizslas", 0);
        target.addProp("goldfish", 5);
        target.addProp("trees", 3);
        target.addProp("cars", 2);
        target.addProp("perfumes", 1);
        
        for (String s : input) {
            //System.out.println(s);
            Matcher m = p.matcher(s);

            if (m.find()) {
                Sue possible = new Sue(Integer.parseInt(m.group(1)));
                for (int i = 2; i <= m.groupCount(); i += 2) {
                    possible.addProp(m.group(i), Integer.parseInt(m.group(i+1)));
                }
                if (possible.isEqualToSue(target)) {
                    return String.valueOf(possible.nr);
                }
            }
        }
		return null;
	}

	@Override
	public String part2(List<String> input) {
        Sue target = new Sue(0);
        target.addProp("children", 3);
        target.addProp("cats", 7);
        target.addProp("samoyeds", 2);
        target.addProp("pomeranians", 3);
        target.addProp("akitas", 0);
        target.addProp("vizslas", 0);
        target.addProp("goldfish", 5);
        target.addProp("trees", 3);
        target.addProp("cars", 2);
        target.addProp("perfumes", 1);
        
        for (String s : input) {
            //System.out.println(s);
            Matcher m = p.matcher(s);

            if (m.find()) {
                Sue possible = new Sue(Integer.parseInt(m.group(1)));
                for (int i = 2; i <= m.groupCount(); i += 2) {
                    possible.addProp(m.group(i), Integer.parseInt(m.group(i+1)));
                }
                if (possible.isEqualToSuePart2(target)) {
                    return String.valueOf(possible.nr);
                }
            }
        }
		return null;
	}

    // mvn exec:java -Dexec.mainClass="com.buildfunthings.aoc.days.Day16"
    public static void main(String[] args) {
        Day16 d = new Day16();
        List<String> input = new ArrayList<>() {{
                add("Sue 1: cars: 2, akitas: 0, goldfish: 5");
                add("Sue 2: akitas: 9, children: 3, samoyeds: 9");
            }
        };
        d.part1(input);
    }
    
}
