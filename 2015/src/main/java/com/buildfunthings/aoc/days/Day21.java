package com.buildfunthings.aoc.days;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.buildfunthings.aoc.common.Day;

public class Day21 implements Day<Integer> {
    /*
      Create sets for Weapons, Armor and Rings

      Create a cartesian product for Weapons, Armor, Rings
      Add the cartesian product for Weapons, Armor, Rings, Rings (you can have 2 rings)

      Evaluate gameplay with the condition that all Items are unique (no double buy items), store winning solutions.

      See what product results in the lowest cost, that wins

      Weapons:    Cost  Damage  Armor
      Dagger        8     4       0
      Shortsword   10     5       0
      Warhammer    25     6       0
      Longsword    40     7       0
      Greataxe     74     8       0

      Armor:      Cost  Damage  Armor
      Leather      13     0       1
      Chainmail    31     0       2
      Splintmail   53     0       3
      Bandedmail   75     0       4
      Platemail   102     0       5

      Rings:      Cost  Damage  Armor
      Damage +1    25     1       0
      Damage +2    50     2       0
      Damage +3   100     3       0
      Defense +1   20     0       1
      Defense +2   40     0       2
      Defense +3   80     0       3
     */
    
    // https://stackoverflow.com/questions/32131987/how-can-i-make-cartesian-product-with-java-8-streams
    // https://stackoverflow.com/questions/8082595/how-do-i-generate-a-cartesian-product-in-java
    public static void main(String[] args) {
        List<Integer> aList = Arrays.asList(1, 2, 3);
        List<Integer> bList = Arrays.asList(4, 5, 6);

        Stream<List<Integer>> product = aList.stream()
                .flatMap(a -> bList.stream().flatMap(b -> Stream.of(Arrays.asList(a, b))));

        product.forEach(p -> {
            System.out.println(p);
        });

        // prints:
        // [1, 4]
        // [1, 5]
        // [1, 6]
        // [2, 4]
        // [2, 5]
        // [2, 6]
        // [3, 4]
        // [3, 5]
        // [3, 6]
    }

    @Override
    public Integer part1(List<String> input) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer part2(List<String> input) {
        // TODO Auto-generated method stub
        return null;
    }
}
