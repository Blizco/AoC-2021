package com.buildfunthings.aoc.days;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.buildfunthings.aoc.common.Day;
import com.google.common.collect.Sets;

public class Day21 implements Day<Integer> {
    class Item {
        String description;
        int cost;
        int damage;
        int armor;

        public Item(String description, int cost, int damage, int armor) {
            this.description = description;
            this.cost = cost;
            this.damage = damage;
            this.armor = armor;
        }

        @Override
        public String toString() {
            return "Item [armor=" + armor + ", cost=" + cost + ", damage=" + damage + ", description=" + description
                    + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getEnclosingInstance().hashCode();
            result = prime * result + ((description == null) ? 0 : description.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Item other = (Item) obj;
            if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
                return false;
            if (description == null) {
                if (other.description != null)
                    return false;
            } else if (!description.equals(other.description))
                return false;
            return true;
        }

        private Day21 getEnclosingInstance() {
            return Day21.this;
        }

    }

    Set<Item> shopWeapons = new HashSet<Item>() {
        {
            add(new Item("Dagger", 8, 4, 0));
            add(new Item("Shortsword", 10, 5, 0));
            add(new Item("Warhammer", 25, 6, 0));
            add(new Item("Longsword", 40, 7, 0));
            add(new Item("Greataxe", 74, 8, 0));
        }
    };

    Set<Item> shopArmor = new HashSet<Item>() {
        {
            add(new Item("Nop", 0, 0, 0));
            add(new Item("Leather", 13, 0, 1));
            add(new Item("Chainmail", 31, 0, 2));
            add(new Item("Splintmail", 53, 0, 3));
            add(new Item("Bandedmail", 75, 0, 4));
            add(new Item("Platemail", 102, 0, 5));

        }
    };

    Set<Item> shopRings = new HashSet<Item>() {
        {
            add(new Item("Nop", 0, 0, 0));
            add(new Item("Damage +1", 25, 1, 0));
            add(new Item("Damage +2", 50, 2, 0));
            add(new Item("Damage +3", 100, 3, 0));
            add(new Item("Defense +1", 20, 0, 1));
            add(new Item("Defense +2", 40, 0, 2));
            add(new Item("Defense +3", 80, 0, 3));
        }
    };

    int getValue(String input) {
        String[] elems = input.split(": ");

        return Integer.valueOf(elems[1]);
    }

    boolean isValidCombo(List<Item> items) {
        Item ring1 = items.get(2);
        Item ring2 = items.get(3);

        if (ring1.description.equals("Nop") || ring2.description.equals("Nop")) {
            return true;
        }

        return !ring1.equals(ring2);
    }

    class Game {
        int bossHp;
        int bossDamage;
        int bossArmor;

        int playerHp;
        int playerDamage;
        int playerArmor;

        boolean playerTurn = true;

        public Game(int bossHp, int bossDamage, int bossArmor, int playerHp, int playerDamage, int playerArmor) {
            this.bossHp = bossHp;
            this.bossDamage = bossDamage;
            this.bossArmor = bossArmor;
            this.playerHp = playerHp;
            this.playerDamage = playerDamage;
            this.playerArmor = playerArmor;
        }

        public void playTurn() {
            if (playerTurn) {
                int d = Math.max(1, playerDamage - bossArmor);
                bossHp = bossHp - d;
                playerTurn = !(bossHp > 0);

                // System.out.println(String.format("The player deals %d-%d = %d damage; the
                // boss goes down to %d hit points.", playerDamage, bossArmor, d, bossHp));
            } else {
                int d = Math.max(1, bossDamage - playerArmor);
                playerHp = playerHp - d;
                playerTurn = playerHp > 0;
                // System.out.println( String.format("The boss deals %d-%d = %d damage; the
                // player goes down to %d hit points.", bossDamage, playerArmor, d, playerHp));
            }
        }

        public boolean play() {
            while (bossHp > 0 && playerHp > 0) {
                playTurn();
            }
            return playerTurn;
        }
    }

    public Game newGame(int bossHp, int bossDamage, int bossArmor, int playerHp, int playerDamage, int playerArmor) {
        return new Game(bossHp, bossDamage, bossArmor, playerHp, playerDamage, playerArmor);
    }

    @Override
    public Integer part1(List<String> input) {
        // BOSS stats
        int hp = getValue(input.get(0));
        int damage = getValue(input.get(1));
        int armor = getValue(input.get(2));

        // My stats: 100 hp
        Set<List<Item>> res = Sets.cartesianProduct(new ArrayList<Set<Item>>() {
            {
                add(shopWeapons);
                add(shopArmor);
                add(shopRings);
                add(shopRings);
            }
        });

        List<Integer> winning = new ArrayList<>();
        // Simulate the game
        for (List<Item> items : res) {
            if (isValidCombo(items)) {
                int playerHp = 100;
                int playerArmor = items.stream().mapToInt(e -> e.armor).sum();
                int playerDamage = items.stream().mapToInt(e -> e.damage).sum();
                int gold = items.stream().mapToInt(e -> e.cost).sum();

                Game g = new Game(hp, damage, armor, playerHp, playerDamage, playerArmor);
                if (g.play()) {
                    // System.out.println(items + " won, cost: " + gold);
                    winning.add(gold);
                }
            }
        }
        int lowest = winning.stream().min(Integer::compare).get();
        // System.out.println("Lowest gold was: " + lowest);
        return lowest;
    }

    @Override
    public Integer part2(List<String> input) {
        // BOSS stats
        int hp = getValue(input.get(0));
        int damage = getValue(input.get(1));
        int armor = getValue(input.get(2));

        // My stats: 100 hp
        Set<List<Item>> res = Sets.cartesianProduct(new ArrayList<Set<Item>>() {
            {
                add(shopWeapons);
                add(shopArmor);
                add(shopRings);
                add(shopRings);
            }
        });

        List<Integer> losing = new ArrayList<>();
        // Simulate the game
        for (List<Item> items : res) {
            if (isValidCombo(items)) {
                int playerHp = 100;
                int playerArmor = items.stream().mapToInt(e -> e.armor).sum();
                int playerDamage = items.stream().mapToInt(e -> e.damage).sum();
                int gold = items.stream().mapToInt(e -> e.cost).sum();

                Game g = new Game(hp, damage, armor, playerHp, playerDamage, playerArmor);
                if (!g.play()) {
                    // System.out.println(items + " won, cost: " + gold);
                    losing.add(gold);
                }
            }
        }
        int most = losing.stream().max(Integer::compare).get();
        // System.out.println("Most gold was: " + most);
        return most;
    }
}
