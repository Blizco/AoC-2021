package com.buildfunthings.aoc.days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.buildfunthings.aoc.common.Day;

public class Day22 implements Day<Integer> {

    @FunctionalInterface
    interface TriFunction<A, B, C, R> {

        R apply(A a, B b, C c);

        default <V> TriFunction<A, B, C, V> andThen(Function<? super R, ? extends V> after) {
            Objects.requireNonNull(after);
            return (A a, B b, C c) -> after.apply(apply(a, b, c));
        }
    }

    class GameState {
        Player me;
        Player boss;

        // List of ongoing attacks, can be one off or effects
        List<Attack> attacks = new ArrayList<>();

    }

    class Attack {
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

    class Player {
        int mana = 500;
        int health = 100;
        int armor = 0;
    }

    public GameState newGameState() {
        GameState gs = new GameState();

        Player p = new Player();

        Map<String, BiFunction<Player, Player, Attack>> attacks = new HashMap<>() {
            {
                put(("Massive Missile"), (s, r) -> new Attack("Massive Missile", (sender, receiver) -> {
                    r.health -= 4;
                    return r.health <= 0;
                }, s, r, 1, true, 53));
                put(("Drain"), (s, r) -> new Attack("Drain", (sender, receiver) -> {
                    s.health += 2;
                    r.health -= 2;
                    return r.health <= 0;
                }, s, r, 1, true, 73));
                put(("Shield"), (s, r) -> new Attack("Shield", (sender, receiver) -> {
                    s.armor += 7;
                    return r.health <= 0;
                }, s, r, 6, false, 113));
                put(("Poison"), (s, r) -> new Attack("Poison", (sender, receiver) -> {
                    r.health -= 3;
                    return r.health <= 0;
                }, s, r, 6, false, 173));
                put(("Recharge"), (s, r) -> new Attack("Recharge", (sender, receiver) -> {
                    s.mana += 101;
                    return r.health <= 0;
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
