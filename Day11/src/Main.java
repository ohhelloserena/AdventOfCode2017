

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String str = "";

        Scanner sc = new Scanner(new File("src/input"));

        while (sc.hasNextLine()) {
            str = sc.nextLine();
        }

        String[] input = str.split(",");

        int x = 0;
        int y = 0;
        int z = 0;

        int distance;
        int maxDistance = 0;

        for (String i : input) {

            if (i.equals("n")) {
                y++;
                z--;

            } else if (i.equals("s")) {
                y--;
                z++;

            } else if (i.equals("ne")) {
                x++;
                z--;

            } else if (i.equals("nw")) {
                x--;
                y++;

            } else if (i.equals("sw")) {
                x--;
                z++;

            } else if (i.equals("se")) {
                x++;
                y--;

            }

            distance = calculateDistance(x, y, z);

            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }

        distance = calculateDistance(x, y, z);

        System.out.println("Part 1: steps = " + distance);
        System.out.println("Part 2: max steps = " + maxDistance);

    }

    public static int calculateDistance(int x, int y, int z) {
        return (Math.abs(x) + Math.abs(y) + Math.abs(z)) / 2;

    }






}
