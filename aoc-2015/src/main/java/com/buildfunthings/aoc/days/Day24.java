package com.buildfunthings.aoc.days;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.buildfunthings.aoc.common.Day;

public class Day24 implements Day<Long> {
    AtomicLong shortets = new AtomicLong(0); 
    List<int[]> all = new ArrayList<>();

    public static int[] remove(int[] arr, int index) {
  
      // If the array is empty
      // or the index is not in array range
      // return the original array
      if (arr == null
          || index < 0
          || index >= arr.length) {
  
          return arr;
      }
  
      // return the resultant array
      return IntStream.range(0, arr.length)
          .filter(i -> i != index)
          .map(i -> arr[i])
          .toArray();
    }
    
    static int[] add(int[] a, int e) {
        a  = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }

    static int[][] cloneArray(int[][] source) {
        return Arrays.stream(source)
            .map((int[] row) -> row.clone())
            .toArray((int length) -> new int[length][]);
    }
    /** Wrapper function for the search */
    public  void findSubarraySums(int goal, int[] array) {
        // Search the whole array with an empty starting set
        search(goal, new ArrayDeque<Integer>(), array, 0);
    }

    /** Helper for printing an answer */
    private void printAnswer(Deque<Integer> xs) {
        all.add(xs.stream().mapToInt(x -> x).toArray());
        return;
        // // Print the sum
        // int sum = 0;
        // for (int x : xs) sum += x;
        // System.out.printf("%d =", sum);
        // // Print the elements
        // for (int x : xs) {
        //     System.out.printf(" %d", x);
        // }
        // System.out.println();
    }

    private void search(int n, Deque<Integer> xs, int[] array, int i) {
        // Base case: we've reached zero!
        if (n == 0) {
            // add answer to list of possibilities
            printAnswer(xs);
            return;
        }
        // Base case: solution not found
        if (n < 0 || i >= array.length) return;
        // optim: if a shorter first basket exists, stop this one
        // ensure current int is not in one of the other baskets
        
        // Recursive case: try searching with and without current element
        // with:
        xs.addLast(array[i]);
        search(n-array[i], xs, array, i+1);
        // without:
        xs.removeLast();
        search(n, xs, array, i+1);
    }
    
    @Override
    public Long part1(List<String> input) {
        int[] numbers = input.stream().mapToInt(s -> Integer.parseInt(s)).toArray();
        int sum = Arrays.stream(numbers).sum();
        int size = sum / 3;

        findSubarraySums(size, numbers);

        // all contains all combinations that count to the size
        List<int[]> sorted=  all.stream().sorted((x1, x2) -> x1.length - x2.length).collect(Collectors.toList());

        // for (int[] x : sorted) {
        //     System.out.println(Arrays.toString(x));
        // }

        int minSize = 99;

        List<int[][]> sleds = new ArrayList<>();

        // from small to large
        for (int[] a : sorted) {
            List<int[]> buckets = new ArrayList<>();
            buckets.add(a); // bucket 1
            //System.out.println(Arrays.toString(a));
            //System.out.println(Arrays.stream(arr).anyMatch(s -> s.equals(stringToSearch)));
            if (a.length > minSize) {
                break;                    
            }
            for (int[] b : sorted) {
                // THIS IS SOOO DIRTY
                List<Integer> l = new ArrayList<>();
                for (int[] d : buckets) {
                    for (int i : d) {
                        l.add(i);
                    }
                }
                int[] z = l.stream().mapToInt(x->x).toArray();
                //System.out.println("B: " + b.length);
                if (Arrays.stream(z).distinct()
                    .filter(x -> Arrays.stream(b).anyMatch(y -> y == x)).toArray().length == 0) {
                    buckets.add(b);
                    //System.out.print(".");
                    //System.out.println("Buckets: " + buckets.size());
                    if (buckets.size() == 3) {
                        //System.out.print("!");
                        // for (int[] x : buckets) {
                        //     System.out.println(Arrays.toString(x));
                        // }
                        if (buckets.get(0).length < minSize) {
                            minSize = buckets.get(0).length;
                            
                        }
                        sleds.add(buckets.toArray(new int[0][]));
                        buckets.clear();
                        continue;
                    }
                }
            }
        }

        // List<Long> results = sleds.stream().map(x -> Arrays.stream(x[0]).reduce(1, (a, b) -> a * b))
        //         .collect(Collectors.toList());
        long min = Long.MAX_VALUE;

        // System.out.println(results.stream().min(Integer::compare).get());
        //System.out.println(sleds.size());
        for (int[][] x : sleds) {
            //System.out.println(Arrays.deepToString(x));
            long v = 1;
            for (int i = 0; i < x[0].length; i++) {
                v *= x[0][i];
            }
            if (v < min)
                min = v;
        }
        return min;
        //        return results.stream().min(Integer::compare).get();
    }

    @Override
    public Long part2(List<String> input) {
        int[] numbers = input.stream().mapToInt(s -> Integer.parseInt(s)).toArray();
        int sum = Arrays.stream(numbers).sum();
        int size = sum / 4;

        findSubarraySums(size, numbers);

        // all contains all combinations that count to the size
        List<int[]> sorted=  all.stream().sorted((x1, x2) -> x1.length - x2.length).collect(Collectors.toList());

        // for (int[] x : sorted) {
        //     System.out.println(Arrays.toString(x));
        // }

        int minSize = 99;

        List<int[][]> sleds = new ArrayList<>();

        // from small to large
        for (int[] a : sorted) {
            List<int[]> buckets = new ArrayList<>();
            buckets.add(a); // bucket 1
            //System.out.println(Arrays.toString(a));
            //System.out.println(Arrays.stream(arr).anyMatch(s -> s.equals(stringToSearch)));
            if (a.length > minSize) {
                break;                    
            }
            for (int[] b : sorted) {
                // THIS IS SOOO DIRTY
                List<Integer> l = new ArrayList<>();
                for (int[] d : buckets) {
                    for (int i : d) {
                        l.add(i);
                    }
                }
                int[] z = l.stream().mapToInt(x->x).toArray();
                //System.out.println("B: " + b.length);
                if (Arrays.stream(z).distinct()
                    .filter(x -> Arrays.stream(b).anyMatch(y -> y == x)).toArray().length == 0) {
                    buckets.add(b);
                    System.out.print(".");
                    //System.out.println("Buckets: " + buckets.size());
                    if (buckets.size() == 4) {
                        System.out.print("!");
                        // for (int[] x : buckets) {
                        //     System.out.println(Arrays.toString(x));
                        // }
                        if (buckets.get(0).length < minSize) {
                            minSize = buckets.get(0).length;
                            
                        }
                        sleds.add(buckets.toArray(new int[0][]));
                        buckets.clear();
                        continue;
                    }
                }
            }
        }

        // List<Long> results = sleds.stream().map(x -> Arrays.stream(x[0]).reduce(1, (a, b) -> a * b))
        //         .collect(Collectors.toList());
        long min = Long.MAX_VALUE;

        // System.out.println(results.stream().min(Integer::compare).get());
        //System.out.println(sleds.size());
        for (int[][] x : sleds) {
            //System.out.println(Arrays.deepToString(x));
            long v = 1;
            for (int i = 0; i < x[0].length; i++) {
                v *= x[0][i];
            }
            if (v < min)
                min = v;
        }
        return min;
        
    }
 




    
}
