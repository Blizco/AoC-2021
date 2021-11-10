package com.buildfunthings.aoc.days;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import com.buildfunthings.aoc.common.Day;

import javafx.scene.effect.Effect;

public class Day22 implements Day<Integer> {

    /*
     * Implement a GameState object; it contains the stats for both players (in a
     * Player object), a list of attacks performed by the wizard and a list of
     * effects on the Player.
     * 
     * After a turn the state is evaluated, if the GameState is final the game is
     * over.
     * 
     * There is a queue with solvable GameState objects. The solver takes a state
     * from the queue and applies the effects, then it performs an attack.
     * 
     * On a turn for the boss it applies the effects and attacks. The new game state
     * is added to the queue.
     * 
     * On a turn for the wizard create GameState for each of the spells and performs
     * each one; it applies the effects and attacks. This means that each
     * combination of magic is evaluated. The resulting Game state is added to the
     * queue.
     */

    class GameState {
        Player me;
        Player boss;

        // List of ongoing attacks, can be one off or effects
        List<Attack> attacks = new ArrayList<>();

    }

    class Attack {
        String name;
        //         SENDER  RECEIVER Kill?
        BiFunction<Player, Player,  Boolean> func;
        int lifetime = 1;

        public Attack(String name, BiFunction<Player, Player, Boolean> func, int lifetime) {
            this.name = name;
            this.func = func;
            this.lifetime = lifetime;
        }

        
    }
    
    class Player {
        int mana = 10;
        int health = 100;

    }
    
    public GameState newGameState() {
        GameState gs = new GameState();

        Player p = new Player();

        BiFunction<Player, Player, Attack> missile = (s, r) -> new Attack("Massive Missile", (sender, receiver) -> {
            --receiver.health;
            return receiver.health <= 0;
        }, 1);
        
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
