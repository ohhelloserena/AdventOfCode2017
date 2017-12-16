import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static List<String> result;
    public static List<String> result2;
    public static int count;

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

        result = new ArrayList<>();
        result2 = new ArrayList<>();
        count = 0;

        //partOne(list);

        partTwo(list);
    }

    public static void partOne(List<Integer> list) {
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
                    boolean doesContain = result.contains(str);

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

        System.out.println("part 2");

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
                    boolean doesContain = result.contains(str);

                    if (!doesContain) {
                        partTwo(listCopy);
                    } else {
                        count++;

                        if (count == 2) {
                            System.out.println("Part 2: " + count);
                            break;
                        } else {
                            partTwo(listCopy);
                        }

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


