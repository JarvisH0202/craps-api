package com.jarvis.craps;

import java.util.Arrays;

public class CrapsService {

    public int[] rollDice() {
        int[] results = new int[11];
        for (int i = 0; i < 10000; i++) {
            int die1 = (int)(Math.random() * 6) + 1;
            int die2 = (int)(Math.random() * 6) + 1;
            int sum = die1 + die2;
            results[sum - 2]++;
        }
        return results;
    }

    public int[] sortResults(int[] results) {
        int[] sorted = Arrays.copyOf(results, results.length);
        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = 0; j < sorted.length - 1 - i; j++) {
                if (sorted[j] > sorted[j + 1]) {
                    int temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        return sorted;
    }

    public double[] getProbabilities(int[] results) {
        double[] probabilities = new double[results.length];
        int total = 10000;
        for (int i = 0; i < results.length; i++) {
            probabilities[i] = ((double) results[i] / total) * 100;
        }
        return probabilities;
    }
}
