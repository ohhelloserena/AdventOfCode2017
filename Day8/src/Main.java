import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static List<String> inputLines = new ArrayList<String>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/input"));

        while (sc.hasNextLine()) {
            inputLines.add(sc.nextLine());
        }
        
        getLargestRegisterValue(inputLines);
    }

    public static void getLargestRegisterValue(List<String> inputLines) {
        Map<String, Integer> registerMap = new HashMap<>();
        String [] splitInstruction;
        int max = 0;

        // set registers with initial value of 0
        for (String i : inputLines) {
            splitInstruction = i.split(" ");
            String reg = splitInstruction[0];
            registerMap.put(reg, 0);
        }

        // iterate thru the instructions
        for (String i : inputLines) {
            splitInstruction = i.split(" ");

            String aStr = splitInstruction[4];
            int a = registerMap.get(aStr);
            String inequality = splitInstruction[5];
            int b = Integer.parseInt(splitInstruction[6]);

            String regToBeChanged = splitInstruction[0];
            int regValueToBeChanged = registerMap.get(regToBeChanged);
            String modifier = splitInstruction[1];
            int modifierValue = Integer.parseInt(splitInstruction[2]);

            if (inequality.equals("<")) {
                if (a < b) {
                    int newVal = calculateValue(regValueToBeChanged, modifierValue, modifier);
                    registerMap.put(regToBeChanged, newVal);

                    if (newVal > max) {
                        max = newVal;
                    }
                }
            } else if (inequality.equals("<=")) {
                if (a <= b) {
                    int newVal = calculateValue(regValueToBeChanged, modifierValue, modifier);
                    registerMap.put(regToBeChanged, newVal);

                    if (newVal > max) {
                        max = newVal;
                    }
                }
            } else if (inequality.equals(">")) {
                if (a > b) {
                    int newVal = calculateValue(regValueToBeChanged, modifierValue, modifier);
                    registerMap.put(regToBeChanged, newVal);

                    if (newVal > max) {
                        max = newVal;
                    }
                }
            } else if (inequality.equals(">=")) {
                if (a >= b) {
                    int newVal = calculateValue(regValueToBeChanged, modifierValue, modifier);
                    registerMap.put(regToBeChanged, newVal);

                    if (newVal > max) {
                        max = newVal;
                    }
                }
            } else if (inequality.equals("==")) {
                if (a == b) {
                    int newVal = calculateValue(regValueToBeChanged, modifierValue, modifier);
                    registerMap.put(regToBeChanged, newVal);

                    if (newVal > max) {
                        max = newVal;
                    }
                }
            } else if (inequality.equals("!=")) {
                if (a != b) {
                    int newVal = calculateValue(regValueToBeChanged, modifierValue, modifier);
                    registerMap.put(regToBeChanged, newVal);

                    if (newVal > max) {
                        max = newVal;
                    }
                }
            } else {
                continue;
            }
        }
        System.out.println("Part 1: "+ Collections.max(registerMap.values()));
        System.out.println("Part 2: " + max);
    }

    public static int calculateValue(int registerValue, int modifierValue, String modifier) {
        if (modifier.equals("dec")) {
            return registerValue - modifierValue;
        } else {
            return registerValue + modifierValue;
        }
    }

}
