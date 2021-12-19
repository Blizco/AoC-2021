package nl.arjenwiersma.aoc.days;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import nl.arjenwiersma.aoc.common.Day;

public class Day10 implements Day<Long> {

    @Override
    public Long part1(List<String> input) {
        long result = 0L;
        // loop over de input
        Stack<Character> haakjes = new Stack<>();

        // all regels in de input
        for (String in : input) {
            // all characters in de regel
            for (Character c : in.toCharArray()) {
                boolean ok = true;

                switch (c) {
                    case '(' -> haakjes.add(')');
                    case '[' -> haakjes.add(']');
                    case '{' -> haakjes.add('}');
                    case '<' -> haakjes.add('>');

                    case ')', ']', '}', '>' -> {
                        char p = haakjes.pop();
                        if (c != p) {
                            result += switch (c) {
                                case ')' -> 3;
                                case ']' -> 57;
                                case '}' -> 1197;
                                case '>' -> 25137;
                                default -> 0;
                            };
                            ok = false;
                        }}}

                if (!ok) break;
            }
        }
        return result;
    }

    /**
     * Bepaal of een regel de juiste sluit haken heeft
     * voor de openings haken.
     */
    public boolean validLine(String line) {
        Stack<Character> haakjes = new Stack<>();

        for (Character c : line.toCharArray()) {
            switch (c) {
                case '(' -> haakjes.add(')');
                case '[' -> haakjes.add(']');
                case '{' -> haakjes.add('}');
                case '<' -> haakjes.add('>');

                case ')', ']', '}', '>' -> {
                    char p = haakjes.pop();
                    if (c != p) {
                        return false;
                    }}}
        }

        return true;
    }

    @Override
    public Long part2(List<String> input) {
        List<String> incomplete = input.stream().filter(this::validLine).toList();

        List<Long> scores = new ArrayList<>();
        for (String line : incomplete) {
            long lineScore = 0L;
            Stack<Character> haakjes = new Stack<>();

            for (Character c : line.toCharArray()) {
                switch (c) {
                    case '(' -> haakjes.add(')');
                    case '[' -> haakjes.add(']');
                    case '{' -> haakjes.add('}');
                    case '<' -> haakjes.add('>');

                    case ')', ']', '}', '>' -> {
                        haakjes.pop();
                    }}
            }

            // openings haakjes in volgorde staan
            while (!haakjes.isEmpty()) {
                char c = haakjes.pop();

                lineScore = (lineScore * 5) + switch (c) {
                    case ')' -> 1;
                    case ']' -> 2;
                    case '}' -> 3;
                    case '>' -> 4;
                    default  -> 0;
                };
            }
            scores.add(lineScore);
        }

        scores.sort(Comparator.naturalOrder());
        return scores.get(scores.size() / 2);
    }

}

