package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        /*
        String[] arr = new String[5];
        arr[0] = "0";
        arr[1] = "3";
        arr[2] = "0";
        arr[3] = "1";
        arr[4] = "-3";
        */

        // Part 1

        Scanner sc = new Scanner(new File("src/com/company/input"));
        List<String> lines = new ArrayList<String>();

        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        String[] arr = lines.toArray(new String[0]);

        int i = 0;
        int steps = 0;
        int offset;
        int incrementedOffset;

        while (i < arr.length) {
            offset = Integer.parseInt(arr[i]);
            incrementedOffset = offset + 1;
            arr[i] = Integer.toString(incrementedOffset);
            i += offset;
            steps++;
        }
        System.out.println("Part 1: " + steps);


        // Part 2

        // reset array and variables

        Scanner sc2 = new Scanner(new File("src/com/company/input"));
        List<String> lines2 = new ArrayList<String>();

        while (sc2.hasNextLine()) {
            lines2.add(sc2.nextLine());
        }

        String[] arr2 = lines2.toArray(new String[0]);

        i = 0;
        steps = 0;
        offset = 0;
        int newOffset;

        while (i < arr2.length) {
            offset = Integer.parseInt(arr2[i]);

            if (offset >= 3) {
                newOffset = offset - 1;
            } else {
                newOffset = offset + 1;
            }

            arr2[i] = Integer.toString(newOffset);
            i += offset;
            steps++;
        }
        System.out.println("Part 2: " + steps);
    }
}
