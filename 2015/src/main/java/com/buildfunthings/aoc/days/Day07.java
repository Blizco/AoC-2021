package com.buildfunthings.aoc.days;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntBinaryOperator;

import com.buildfunthings.aoc.common.Day;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

public class Day07 implements Day<Integer> {
    enum Op {
        AND((x, y) -> (x & y)),
        OR((x, y) -> (x | y)),
        NOT((x, y) -> (~x & 0xffff)),
        RSHIFT((x, y) -> (x >> y)),
        LSHIFT((x, y) -> (x << y)),
        ASSIGNX((x, y) -> (x));

        private final IntBinaryOperator func;
        
        Op(IntBinaryOperator func) {
            this.func = func;
        }
    }

    @AllArgsConstructor
    @RequiredArgsConstructor
    @ToString
    @EqualsAndHashCode
    public class Wire {
        @NonNull
        String name;
        int value = -1;
    }

    
    @AllArgsConstructor
    @RequiredArgsConstructor
    @ToString
    @EqualsAndHashCode
    public class Gate {
        @NonNull
        String name;
        Wire left;
        Wire right;
        Wire result;
        Op op;

        public boolean allWiresHaveValue() {
            boolean valid = true;
            if (left != null && left.value == -1)
                valid = false;
            if (right != null && right.value == -1)
                valid = false;
            return valid;
        }

        public void perform() {
            if (op == null)
                return;
            result.value = op.func.applyAsInt(left != null ? left.value : 0, right != null ? right.value : 0);
        }
        
        public void fire() {
            if (allWiresHaveValue()) {
                perform();
            } else {
                if (left != null && !left.name.equals("")) {
                    Gate g = getGate(left.name);
                    g.fire();
                }
                if (right != null && !right.name.equals("")) {
                    Gate g = getGate(right.name);
                    g.fire();
                }
            }
        }
    }

    Map<String, Wire> wires = new HashMap<>();
    Map<String, Gate> gates = new HashMap<>();

    public boolean isDigit(String input) {
        return Character.isDigit(input.charAt(0));
    }

    public Wire getWire(String name) {
        Wire result = isDigit(name) ?
            new Wire("", Integer.parseInt(name))
            : wires.getOrDefault(name, new Wire(name));
        return result;
    }

    public Gate getGate(String resultName) {
        Gate result = isDigit(resultName) ? new Gate(resultName)
                : gates.getOrDefault(resultName, new Gate(resultName));
        return result;
    }

    public void storeWires(Wire... wires) {
        for (Wire w : wires) {
            if (w != null) {
                this.wires.put(w.name, w);
            }
        }
    }

    public void createCircuit(List<String> input) {
        for (String i : input) {
            String[] inst = i.split(" ");

            Wire left = null, right = null, result = null;
            Op op = null;

            switch (inst.length) {
            case 3: // ASSIGN
                left = getWire(inst[0]);
                result = getWire(inst[2]);

                op = Op.ASSIGNX;
                break;
            case 4: // NOT
                left = getWire(inst[1]);
                result = getWire(inst[3]);
                op = Op.NOT;
                break;
            case 5: // operation
                left = getWire(inst[0]);
                right = getWire(inst[2]);
                op = Op.valueOf(inst[1]);
                result = getWire(inst[4]);
                break;
            default:
                System.out.println("Unknown case detected!");
            }

            Gate g = getGate(result.name);

            g.left = left;
            g.right = right;
            g.result = result;
            g.op = op;

            gates.put(g.result.name, g);
            storeWires(left, right, result);
        }
    }

    int fireWire(String name) {
        Gate g = getGate(name);
        while (g.result.value == -1) {
            g.fire();
        }
        return g.result.value;
    }
    
    @Override
    public Integer part1(List<String> input) {
        createCircuit(input);
        return fireWire("a");
    }

    @Override
    public Integer part2(List<String> input) {
        wires.clear();
        gates.clear();
        
        createCircuit(input);
        int value = fireWire("a");

        wires.clear();
        gates.clear();

        createCircuit(input);

        Gate b = getGate("b");
        b.result.value = value;
        b.op = null;
        
        return fireWire("a");
    }

}
