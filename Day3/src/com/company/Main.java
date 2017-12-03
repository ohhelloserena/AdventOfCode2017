package com.company;

public class Main {

    public static void main(String[] args) {

        int input = 277678;
        int product = 0;
        int factor = 0;

        // Part 1

        // calculate number in right bottom corner of spiral
        for (int i = 1; i < input; i++) {
            if (i * i == input || i * i > input) {
                factor = i;
                product = i * i;
                break;
            }
        }

        int diff = product - input;     // number of steps to backtrack, if any
        int steps = factor - 1 - diff;

        System.out.println("Part 1: " + steps);
    }
}
