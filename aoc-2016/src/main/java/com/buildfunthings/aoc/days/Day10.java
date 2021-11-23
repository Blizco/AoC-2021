package com.buildfunthings.aoc.days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.buildfunthings.aoc.common.Day;

import lombok.ToString;

public class Day10 implements Day<Integer> {
    @ToString
    class Container {
        List<Integer> ints = new ArrayList<>();
        Integer[] instr = new Integer[2];
        
        Integer min() {
            Integer min = ints.stream().min(Integer::compare).get();
            ints.remove(min);
            return min;
        }

        Integer max() {
            Integer max = ints.stream().max(Integer::compare).get();
            ints.remove(max);
            return max;
        }

        void addIntruction(Integer low, Integer high) {
            instr[0] = low;
            instr[1] = high;
        }

        boolean canProcess() {
            return ints.size() == 2;
        }
    }

    private void parse(List<String> input, Map<Integer, Container> bots) {
        for (String in : input) {
            String[] parts = in.split(" ");
            if (in.startsWith("value")) {
                // value 61 goes to bot 49
                Integer botId = Integer.parseInt(parts[5]);
                Integer value = Integer.parseInt(parts[1]);

                Container b = bots.getOrDefault(botId, new Container());
                b.ints.add(value);
                bots.put(botId, b);
            } else if (in.startsWith("bot")) {
                // bot 49 gives low to bot 118 and high to bot 182
                Integer botId = Integer.parseInt(parts[1]);
                Integer lowId = Integer.parseInt(parts[6]);
                if ("output".equals(parts[5])) {
                    lowId = (lowId + 1) * -1;
                }
                Integer highId =  Integer.parseInt(parts[11]);
                if ("output".equals(parts[10])) {
                    highId = (highId + 1) * -1;
                }

                bots.putIfAbsent(lowId, new Container());
                bots.putIfAbsent(highId, new Container());
                
                Container b = bots.getOrDefault(botId, new Container());
                b.addIntruction(lowId, highId);
                bots.put(botId, b);
            } else {
                System.out.println("Unhandled: " + in);
            }
        }
    }
    
    @Override
    public Integer part1(List<String> input) {
        // outputs are * -1
        Map<Integer, Container> bots = new HashMap<>();

        parse(input, bots);

        while (true) {
            for (Integer b : bots.keySet()) {
                if (b < 0)
                    continue;

                Container c = bots.get(b);

                if (c.canProcess()) {
                    if (c.ints.contains(61) && c.ints.contains(17))
                        return b;
                    
                    Container low = bots.getOrDefault(c.instr[0], new Container());
                    Container high = bots.getOrDefault(c.instr[1], new Container());

                    low.ints.add(c.min());
                    high.ints.add(c.max());
                }
            }
        }
    }



    @Override
    public Integer part2(List<String> input) {
            // outputs are * -1
        Map<Integer, Container> bots = new HashMap<>();

        parse(input, bots);

        while (true) {
            for (Integer b : bots.keySet()) {
                if (b < 0)
                    continue;

                Container c = bots.get(b);

                if (c.canProcess()) {
                    
                    Container low = bots.getOrDefault(c.instr[0], new Container());
                    Container high = bots.getOrDefault(c.instr[1], new Container());

                    low.ints.add(c.min());
                    high.ints.add(c.max());

                    // if (c.instr[0] < 0 || c.instr[1] < 0)
                    //     System.out.println(c.instr[0] + " " + low + " " + c.instr[1] + " " + high);
                }
            }


            if (bots.get(-1).ints.size()  == 1&& bots.get(-2).ints.size() == 1 && bots.get(-3).ints.size() == 1) {
                return bots.get(-1).ints.get(0) * bots.get(-2).ints.get(0) * bots.get(-3).ints.get(0);
            }
        }
    }
    
}

