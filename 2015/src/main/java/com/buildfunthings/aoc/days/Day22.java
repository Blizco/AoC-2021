package com.buildfunthings.aoc.days;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import com.buildfunthings.aoc.common.Day;
import com.google.common.collect.ImmutableList;

public class Day22 implements Day<Integer> {

    class GameState implements Cloneable {
        Player me;
        Player boss;

        // List of attacks, past and present, can be one off or effects
        ImmutableList<Attack> attacks;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public GameState addAttack(Attack a) throws CloneNotSupportedException {
            GameState newGS = (GameState) this.clone();
            // Add the attack to the list and return the object
            newGS.attacks = ImmutableList.<Attack>builder().addAll(newGS.attacks).add(a).build();
            return newGS;
        }
    }

    public class Attack {
        String name;
        // SENDER RECEIVER Return: Kill?
        BiFunction<Player, Player, Boolean> func;
        Player sender;
        Player receiver;
        int cost;
        int lifetime = 1; // How many turns? 1 means only a single attack
        boolean instant = false; // Do immediate damage, or delayed?

        public Attack(String name, BiFunction<Player, Player, Boolean> func, Player send, Player recv, int lifetime,
                boolean instant, int cost) {
            this.name = name;
            this.func = func;
            this.lifetime = lifetime;
            this.instant = instant;
            this.sender = send;
            this.receiver = recv;
            this.cost = cost;
        }

    }

    public class Player implements Cloneable {
        int mana = 500;
        int health = 100;
        int armor = 0;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public GameState newGameState() {
        GameState gs = new GameState();

        Player p = new Player();

        Map<String, BiFunction<Player, Player, Attack>> attacks = new HashMap<>() {
            {
                put(("Massive Missile"), (s, r) -> new Attack("Massive Missile", (sender, receiver) -> {
                    receiver.health -= 4;
                    return receiver.health <= 0;
                }, s, r, 1, true, 53));
                put(("Drain"), (s, r) -> new Attack("Drain", (sender, receiver) -> {
                    sender.health += 2;
                    receiver.health -= 2;
                    return receiver.health <= 0;
                }, s, r, 1, true, 73));
                put(("Shield"), (s, r) -> new Attack("Shield", (sender, receiver) -> {
                    sender.armor += 7;
                    return receiver.health <= 0;
                }, s, r, 6, false, 113));
                put(("Poison"), (s, r) -> new Attack("Poison", (sender, receiver) -> {
                    receiver.health -= 3;
                    return receiver.health <= 0;
                }, s, r, 6, false, 173));
                put(("Recharge"), (s, r) -> new Attack("Recharge", (sender, receiver) -> {
                    sender.mana += 101;
                    return receiver.health <= 0;
                }, s, r, 5, false, 229));
            }
        };

        return gs;
    }

    @Override
    public Integer part1(List<String> input) {

        return null;
    }

    @Override
    public Integer part2(List<String> input) {
        return null;
    }

}
