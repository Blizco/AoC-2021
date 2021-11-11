package com.buildfunthings.aoc.days;

import java.util.List;

import com.buildfunthings.aoc.common.Day;

public class Day02 implements Day<String> {

    public int getNumber(int start, String input) {
        int pos = start;
        for (char c : input.toCharArray()) {
            switch (c) {
                case 'U' -> pos = ((pos - 3) > 0) ? pos - 3 : pos;
                case 'D' -> pos = ((pos + 3) <= 9) ? pos + 3 : pos;
                case 'L' -> pos = (pos % 3 == 1) ? pos  : pos - 1;
                case 'R' -> pos = (pos % 3 == 0) ? pos : pos + 1;
            }
        }
        return pos;
    }

    class Keypad {
        String keypad = "--1---234-56789-ABC---D--";
        int x;
        int y;

        public char getNumberDiamond(String input) {
            for (char c : input.toCharArray()) {
                switch (c) {
                case 'U' -> y = isValidMove(x, y - 1) ? (y-1) : y;
                case 'D' -> y = isValidMove(x, y + 1) ? (y+1) : y;
                case 'L' -> x = isValidMove(x -1 , y) ? (x-1) : x;
                case 'R' -> x = isValidMove(x +1 , y) ? (x+1) : x;
                }
            }
            return keypad.charAt(x + y * 5);
        }
        
        public boolean isValidMove(int x, int y) {
            if (x >= 0 && x < 5 && y >= 0 && y < 5) {
                char c = keypad.charAt(x + y * 5);
                return (c != '-');
            }
            return false;
        }
    }

    

    
    @Override
    public String part1(List<String> input) {
        StringBuilder sb = new StringBuilder();
        int num = 5;
        for (String i : input) {
            num = getNumber(num, i);
            sb.append(num);
        }
        return sb.toString(); 
    }

   
    @Override
    public String part2(List<String> input) {
        Keypad k = new Keypad();
        k.x = 0;
        k.y = 2;
        StringBuilder sb = new StringBuilder();
        for (String i : input) {
            sb.append(k.getNumberDiamond(i));
        }
        return sb.toString(); 
    }
    
}
