import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("src/input"));
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        String[] arr = lines.toArray(new String[0]);

        // Part 1

        int validCount = 0;

        for (int i = 0; i < arr.length; i++) {
            String[] line = arr[i].split(" ");
            validCount++;

            for (int j = 0; j < line.length; j++) {
                boolean isValid = true;
                for (int m = j + 1; m < line.length; m++) {

                    if (line[j].equals(line[m])) {
                        isValid = false;
                        validCount--;
                        break;
                    }
                }

                if (!isValid) {
                    break;
                } else {
                    continue;
                }
            }
        }
        System.out.println("Part 1: " + validCount);


        // Part 2

        validCount = 0;

        for (int i = 0; i < arr.length; i++) {
            String[] line = arr[i].split(" ");
            validCount++;

            for (int j = 0; j < line.length; j++) {
                boolean isValid = true;

                for (int m = j + 1; m < line.length; m++) {
                    char[] lineJ = line[j].toCharArray();
                    Arrays.sort(lineJ);

                    char[] lineM = line[m].toCharArray();
                    Arrays.sort(lineM);

                    if (Arrays.equals(lineJ, lineM)) {
                        isValid = false;
                        validCount--;
                        break;
                    }
                }

                if (!isValid) {
                    break;
                } else {
                    continue;
                }
            }
        }
        System.out.println("Part 2: " + validCount);


    }
}
