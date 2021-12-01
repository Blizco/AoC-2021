package com.buildfunthings.aoc.days;

import java.util.List;

import com.buildfunthings.aoc.common.Day;

public class Day23 implements Day<Integer> {

    public int runProgram(int[] reg, List<String> input) {
        for (int ip = 0; ip < input.size(); ) {
            String inst = input.get(ip);
            if (inst.isEmpty())
                continue;
            String op = inst.substring(0, 3);
            switch (op) {
            case "hlf" -> {
                int r = "a".equals(inst.substring(4, 5)) ? 0 : 1;
                reg[r] = reg[r] / 2;
                ip++;
            }
            case "tpl" -> {
                int r = "a".equals(inst.substring(4, 5)) ? 0 : 1;
                reg[r] = reg[r] * 3;
                ip++;
            }
            case "inc" -> {
                int r = "a".equals(inst.substring(4, 5)) ? 0 : 1;
                reg[r] = reg[r] + 1;
                ip++;
            }
            case "jmp" -> {
                int r = Integer.parseInt(inst.substring(4));
                ip += r;
            }
            case "jie" -> {
                int r = "a".equals(inst.substring(4, 5)) ? 0 : 1;
                int off = Integer.parseInt(inst.substring(8));
                if (reg[r] % 2 == 0)
                    ip += off;
                else
                    ip += 1;
            }
            case "jio" -> {
                int r = "a".equals(inst.substring(4, 5)) ? 0 : 1;
                int off = Integer.parseInt(inst.substring(8));
                if (reg[r] == 1)
                    ip += off;
                else
                    ip += 1;
            }
            default -> {
                System.out.println("UNHANDLED: " + op);
            }
            }
            //            System.out.println("[" + inst + "] a: " + reg[0] + " b:" + reg[1] + " ip: " + ip);
        }
        
        return reg[1];        
    }
    
    @Override
    public Integer part1(List<String> input) {
        int[] reg = { 0, 0 }; // 0 = a, 1 = b
        return runProgram(reg, input);
    }

    @Override
    public Integer part2(List<String> input) {
        int[] reg = { 1, 0 }; // 0 = a, 1 = b
        return runProgram(reg, input);
    }
    
}
