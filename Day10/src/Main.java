

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static int currentPos = 0;
    public static int skipSize = 0;
    public static List<Integer> circularList;

    public static void main(String[] args) {
        List<Integer> inputLengths = new ArrayList<>();
        circularList = new ArrayList<>();

        String str = "187,254,0,81,169,219,1,190,19,102,255,56,46,32,2,216";
        //String str ="";

        String[] split = str.split(",");

        for (String s : split) {
            inputLengths.add(Integer.parseInt(s));
        }

        // Part 1 -------

        setCircularList();

        doKnotHash(inputLengths);

        int partOneAnswer = circularList.get(0) * circularList.get(1);
        System.out.println("Part 1: " + partOneAnswer);

        // Part 2 -------

        setCircularList();

        char[] circularCharArr = str.toCharArray();
        List<Integer> asciiList = new ArrayList<>();

        for (char c : circularCharArr) {
            int ascii = (int) c;
            asciiList.add(ascii);
        }

        asciiList.add(17);
        asciiList.add(31);
        asciiList.add(73);
        asciiList.add(47);
        asciiList.add(23);

        // reset variables
        skipSize = 0;
        currentPos = 0;

        for (int i = 0; i < 64; i++) {
            doKnotHash(asciiList);
        }

        List<Integer> denseHash = doDenseHash(circularList);
        String hex = convertToHex(denseHash);
    }

    public static void doKnotHash(List<Integer> inputLengths) {
        int currentLength;
        int index;
        List<Integer> sublist = new ArrayList<>();

        for (int j = 0; j < inputLengths.size(); j++) {
            sublist.clear();

            currentLength = inputLengths.get(j);
            int subLen = currentPos + currentLength;

            if (subLen > circularList.size()) {
                for (int m = currentPos; m < circularList.size(); m++) {
                    sublist.add(circularList.get(m));
                    currentLength--;
                }

                for (int m = 0; m < currentLength; m++) {
                    sublist.add(circularList.get(m));
                }

                Collections.reverse(sublist);
            } else {
                Collections.reverse(circularList.subList(currentPos, currentPos + currentLength));
            }

            if (subLen > circularList.size()) {
                index = 0;
                currentLength = inputLengths.get(j);

                for (int m = currentPos; m < circularList.size(); m++) {
                    circularList.set(m, sublist.get(index));
                    index++;
                    currentLength--;
                }

                for (int m = 0; m < currentLength; m++) {
                    circularList.set(m, sublist.get(index));
                    index++;
                }
            }
            currentPos = (currentPos + inputLengths.get(j) + skipSize) % circularList.size();
            skipSize++;
        }
    }

    public static void setCircularList() {
        circularList.clear();

        for (int i = 0; i < 256; i++) {
            circularList.add(i);
        }
    }

    public static List<Integer> doDenseHash(List<Integer> circularList) {
        List<Integer> denseHash = new ArrayList<>();

        for (int j = 1; j < circularList.size(); j+=16) {
            int output = circularList.get(j-1);
            int max = j + 15;

            for (int i = j; i < max; i++) {
                output = output ^ circularList.get(i);
            }
            denseHash.add(output);
        }
        return denseHash;
    }

    public static String convertToHex(List<Integer> denseHash) {
        String hex = "";

        for (int d : denseHash) {
            String str = Integer.toHexString(d);

            if (str.length() == 1) {
                str = "0" + str;
            }

            hex += str;
        }

        System.out.println("Part 2: " + hex);
        return hex;
    }


}
