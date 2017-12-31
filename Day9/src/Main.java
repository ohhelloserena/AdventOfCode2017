import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static char[] input;


    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/input"));

        while (sc.hasNextLine()) {
            input = sc.nextLine().toCharArray();
        }

        // tests for Part 1

        /*
        char[] test1 = "{{<a!>},{<a!>},{<a!>},{<ab>}}".toCharArray();
        char[] test2 = "{{<!!>},{<!!>},{<!!>},{<!!>}}".toCharArray();
        char[] test3 = "{{<ab>},{<ab>},{<ab>},{<ab>}}".toCharArray();
        char[] test4 = "{<a>,<a>,<a>,<a>}".toCharArray();
        char[] test5 = "{}".toCharArray();
        char[] test6 = "{{{}}}".toCharArray();
        char[] test7 = "{{},{}}".toCharArray();
        char[] test8 = "{{{},{},{{}}}}".toCharArray();

        System.out.println("test 1: " + findGroupScore(test1) + ", expected: 1 + 2 = 3");
        System.out.println("test 2: " + findGroupScore(test2) + ", expected: 1 + 2 + 2 + 2 + 2 = 9");
        System.out.println("test 3: " + findGroupScore(test3) + ", expected:  + 2 + 2 + 2 + 2 = 9");
        System.out.println("test 4: " + findGroupScore(test4) + ", expected: 1");
        System.out.println("test 5: " + findGroupScore(test5) + ", expected: 1");
        System.out.println("test 6: " + findGroupScore(test6) + ", expected: 1 + 2 + 3 = 6");
        System.out.println("test 7: " + findGroupScore(test7) + ", expected: 1 + 2 + 2 = 5");
        System.out.println("test 8: " + findGroupScore(test8) + ", expected: 1 + 2 + 3 + 3 + 3 + 4 = 16");
        */

        // tests for Part 2

        /*
        char[] test9 = "<>".toCharArray();
        char[] test10 = "<random characters>".toCharArray();
        char[] test11 = "<<<<>".toCharArray();
        char[] test12 = "<{!>}>".toCharArray();
        char[] test13 = "<!!>".toCharArray();
        char[] test14 = "<!!!>>".toCharArray();
        char[] test15 = "<{o\"i!a,<{i<a>".toCharArray();

        System.out.println("test 9: " + countGarbage(test9) + ", expected: 0");
        System.out.println("test 10: " + countGarbage(test10) + ", expected: 17");
        System.out.println("test 11: " + countGarbage(test11) + ", expected: 3");
        System.out.println("test 12: " + countGarbage(test12) + ", expected: 2");
        System.out.println("test 13: " + countGarbage(test13) + ", expected: 0");
        System.out.println("test 14: " + countGarbage(test14) + ", expected: 0");
        System.out.println("test 15: " + countGarbage(test15) + ", expected: 10");
        */

        System.out.println("Part 1: " + findGroupScore(input));

        System.out.println("Part 2: " + countGarbage(input));
    }

    /**
     * Part 1 - Returns total score for all groups in the given input.
     *
     * @param input
     * @return
     */
    public static int findGroupScore(char[] input) {
        int count = 0;
        boolean isGarbage = false;
        Stack s = new Stack();
        s.push(Character.toString(input[0]));

        for (int i = 1; i < input.length; i++) {
            String symbol = Character.toString(input[i]);

            if (symbol.equals("!")) {
                i++;
            } else if (symbol.equals("{") && !isGarbage) {
                s.push(symbol);
            } else if (symbol.equals("}") && !isGarbage && s.size() > 0) {
                count += s.size();
                s.pop();
            } else if (symbol.equals("<")) {
                isGarbage = true;
            } else if (symbol.equals(">")) {
                isGarbage = false;
            } else {
                continue;
            }
        }
        return count;
    }

    /**
     * Part 2 - Returns the number of non-canceled characters within the garbage in the given input.
     *
     * @param input
     * @return
     */
    public static int countGarbage(char[] input) {
        int count = 0;
        boolean isGarbage = false;

        for (int i = 0; i < input.length; i++) {
            String symbol = Character.toString(input[i]);

            if (symbol.equals("!")) {
                i++;
            } else if (symbol.equals("<")) {
                if (!isGarbage) {
                    isGarbage = true;
                } else {
                    count++;
                }
            } else if (symbol.equals(">")) {
                isGarbage = false;
            } else if (isGarbage) {
                count++;
            }
        }
        return count;
    }


}
