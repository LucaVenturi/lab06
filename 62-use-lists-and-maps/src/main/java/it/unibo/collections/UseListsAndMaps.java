package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final ArrayList<Integer> numbers = new ArrayList<>();

        for (int n = 1000; n <= 2000; n++) {
            numbers.add(n);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final LinkedList<Integer> numbers2 = new LinkedList<>(numbers);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        var temp = numbers.get(numbers.size() - 1);
        numbers.set(numbers.size() - 1, numbers.get(0));
        numbers.set(0, temp);
        
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer n : numbers) {
            System.out.print(n + " ");
        }

        System.out.println();
        
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        final int N_INSERTED_ELEMS = 100_000;

        long time = System.nanoTime();

        for (int i = 0; i <= N_INSERTED_ELEMS; i++) {
            numbers.add(0, i);
        }

        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);

        System.out.println( "Adding " + N_INSERTED_ELEMS + " ints at the head of ArrayList " + time + "ns (" + millis + "ms)" );

        time = System.nanoTime();
        
        for (int i = 0; i < N_INSERTED_ELEMS; i++) {
            numbers2.addFirst(i);
        }
        
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);

        System.out.println( "Adding " + N_INSERTED_ELEMS + " ints at the head of LinkeList " + time + "ns (" + millis + "ms)" );

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        final int N_READ_ELEMS = 1_000;
        
        time = System.nanoTime();
        
        for (int i = 0; i < N_READ_ELEMS; i++) {
            numbers.get(numbers.size()/2);
        }
        
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);

        System.out.println(// NOPMD
            "Reading " + N_READ_ELEMS + " ints in the middle of ArrayList in  " + time + "ns (" + millis + "ms)"
        );

        time = System.nanoTime();
        
        for (int i = 0; i < N_READ_ELEMS; i++) {
            numbers2.get(numbers.size()/2);
        }
        
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);

        System.out.println(// NOPMD
            "Reading " + N_READ_ELEMS + " ints in the middle of LinkedList in  " + time + "ns (" + millis + "ms)"
        );
        
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String,Long> contintentsPopulation = new HashMap<>();
        contintentsPopulation.put("Africa", 1_110_635_000L);
        contintentsPopulation.put("Americas", 972_005_000L);
        contintentsPopulation.put("Antarctica", 0L);
        contintentsPopulation.put("Asia", 4_298_723_000L);
        contintentsPopulation.put("Europe", 742_452_000L);
        contintentsPopulation.put("Oceania", 38_304_000L);

        /*
         * 8) Compute the population of the world
         */
        long sum = 0;
        for (long population : contintentsPopulation.values()) {
            sum+=population;
        }
        System.out.println("World population is " + sum);
    }
}
