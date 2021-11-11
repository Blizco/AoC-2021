package com.buildfunthings.aoc.days;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.buildfunthings.aoc.common.Day;

public class Day22 implements Day<Integer> {
    enum AttackEnum {
        MASSIVE_MISSILE(true, 53, 4, 0, 1);

        int cost; // cost of the attack in mana
        int armor; // armor change from attack
        int damage; // damage done by the attack
        int lifetime; // how many turns does it stay?
        boolean instant; // is the attack instant or on the next turn

        private AttackEnum(boolean instant, int cost, int damage, int armor, int lifetime) {
            this.cost = cost;
            this.armor = armor;
            this.damage = damage;
            this.instant = instant;
            this.lifetime = lifetime;
        }

    }

    class Attack {
        int turns; // counter how many times this attack has been played
        AttackEnum type; // what attack is it?

        boolean isActive() {
            return false;
        }
    }

    class Game implements Cloneable {

        // Player stats
        // Boss stats
        // List of attacks ()
        @Override
        protected Game clone() throws CloneNotSupportedException {
            return (Game) super.clone();
        }

    }

    
    @Override
    public Integer part1(List<String> input) {
        Queue<Integer> q = new PriorityQueue<>();

        return 0;
    }

    @Override
    public Integer part2(List<String> input) {
        return 0;
    }
}
