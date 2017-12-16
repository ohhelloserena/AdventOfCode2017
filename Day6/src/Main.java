import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

public class Main {

    public static List<String> result;
    public static List<String> result2;
    public static int count;
    public static String str;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("src/input"));
        List<String> lines = new ArrayList<String>();

        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        String[] arr = lines.toArray(new String[0]);
        arr = arr[0].split("\t");


        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < arr.length; i++) {
            list.add(Integer.parseInt(arr[i]));
        }


/*
        list.add(0);
        list.add(2);
        list.add(7);
        list.add(0);
        */


        result = new ArrayList<>();
        result2 = new ArrayList<>();
        count = 0;
        str = "";

        //partOne(list);
        partTwo(list);
    }

    public static void partOne(List<Integer> list) {
        boolean doesContain = false;
        int max;
        int originalMax;
        int val;
        int index;
        int newVal;
        String str;

        List<Integer> listCopy = new ArrayList<>(list);
        result.add(listCopy.toString());

        max = Collections.max(list) + 1;
        originalMax = max;
        index = listCopy.indexOf(Collections.max(list));

        for (int k = index; k < listCopy.size(); k++) {

            if (max == originalMax) {
                listCopy.set(k, 0);
                max--;
            } else {
                val = listCopy.get(k);
                newVal = val + 1;
                max--;
                listCopy.set(k, newVal);

                if (max == 0) {
                    str = listCopy.toString();
                    doesContain = result.contains(str);

                    if (!doesContain) {
                        partOne(listCopy);
                    } else {
                        System.out.println("Part 1: " + result.size());
                        break;
                    }
                }
            }

            if (k == listCopy.size() - 1) {
                k = -1;
                continue;
            }
        }
    }


    public static void partTwo(List<Integer> list) {
        boolean doesContain = false;
        int max;
        int originalMax;
        int val;
        int index;
        int newVal;
        String str;

        List<Integer> listCopy = new ArrayList<>(list);
        result2.add(listCopy.toString());

        max = Collections.max(list) + 1;
        originalMax = max;
        index = listCopy.indexOf(Collections.max(list));

        for (int k = index; k < listCopy.size(); k++) {

            if (max == originalMax) {
                listCopy.set(k, 0);
                max--;
            } else {
                val = listCopy.get(k);
                newVal = val + 1;
                max--;
                listCopy.set(k, newVal);

                if (max == 0) {
                    str = listCopy.toString();
                    doesContain = result2.contains(str);

                    if (!doesContain) {
                        partTwo(listCopy);
                    } else {
                        int start = result2.indexOf(str);
                        int end = result2.size();
                        int diff = end - start;

                        System.out.println("Part 2: " + diff);
                        break;
                    }
                }
            }

            if (k == listCopy.size() - 1) {
                k = -1;
                continue;
            }
        }
    }

}


