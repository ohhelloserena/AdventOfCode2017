import com.sun.xml.internal.messaging.saaj.soap.FastInfosetDataContentHandler;

import javax.sound.midi.SysexMessage;
import javax.swing.tree.TreeNode;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;


public class Main {

    public static String arrow = "->";
    public static String[] arr;
    public static List<String> path;


    public static void main(String[] args) throws FileNotFoundException {

        path = new ArrayList<>();

        Scanner sc = new Scanner(new File("src/test_input"));
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        arr = lines.toArray(new String[0]);

        // Part 1

        List<String> children = new ArrayList<>();
        List<String> parents = new ArrayList<>();
        String root = "";

        for (int i = 0; i < arr.length; i++) {
            String program = arr[i];

            if (program.contains(arrow)) {
                String parentSubstring = program.substring(0, program.indexOf("(") - 1);
                parents.add(parentSubstring);
                String[] child = getSubstring(program);

                for (int j = 0; j < child.length; j++) {
                    children.add(child[j]);
                }
            }
        }

        for (int k = 0; k < parents.size(); k++) {
            if (!children.contains(parents.get(k))) {
                root = parents.get(k);
                break;
            }
        }

        System.out.println("Part 1: " + root);

        // Part 2

        List<Integer> weightList = new ArrayList<>();
        List<String> programsList = new ArrayList<>();


        String rootPath = "";


        // set weightList and programsList
        for (int m = 0; m < arr.length; m++) {
            String program = arr[m];
            String strWeight = program.substring(program.indexOf("(") + 1, program.indexOf(")"));
            String pr = program.substring(0, program.indexOf("(") - 1);
            programsList.add(pr);
            int weight = Integer.parseInt(strWeight);
            weightList.add(weight);
        }

        List<String> rootChildren = getChildren(root);
        List<Integer> sumList = new ArrayList<>();
        List<Integer> tempWeights = new ArrayList<>();

        for (String r : rootChildren) {
            int sum = 0;
            List<String> results = findAllChildren(r);
            results.add(r);

            for (String result : results) {
                String[] breakdown = result.split(",");

                for (String b : breakdown) {
                    int index = programsList.indexOf(b);
                    int weight = weightList.get(index);
                    tempWeights.add(weight);
                    sum += weight;
                }
            }
            sumList.add(sum);
            int iSum = sumList.indexOf(sum);


            if (iSum != 0) {
                int prevSum = sumList.get(iSum - 1);

                if (sum != prevSum) {
                    System.out.println(tempWeights);
                    break;
                }
            }
            results.clear();
            tempWeights.clear();
        }

        System.out.println("sumList: " + sumList.toString());


    }

    /**
     * Return the portion after the ->
     *
     * @param str
     * @return
     */
    public static String[] getSubstring(String str) {
        String arrow = "-> ";
        String childrenSubstring = str.substring(str.indexOf(arrow) + arrow.length(), str.length());
        String[] subStrings = childrenSubstring.split(", ");
        return subStrings;
    }

    /**
     * Return the children for a given program
     *
     * @param program
     * @return
     */
    public static List<String> findAllChildren(String program) {
        List<String> arrList = Arrays.asList(arr);
        List<String> tempPath = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        for (String a : arrList) {
            boolean doesMatch = a.substring(0, a.indexOf("(") - 1).contains(program);
            boolean hasChildren = a.contains(arrow);

            if (doesMatch && hasChildren) {
                String[] pathChildren = getSubstring(a);
                for (String p : pathChildren) {
                    temp.add(p);
                }
                break;
            }
        }

        if (temp.size() > 0) {
            path.addAll(temp);
            tempPath.addAll(temp);
            temp.clear();

            for (String t : tempPath) {
                findAllChildren(t);
            }
        } else {
            return path;
        }
        return path;
    }

    public static List<String> getChildren(String program) {
        List<String> arrList = Arrays.asList(arr);
        List<String> temp = new ArrayList<>();

        for (String a : arrList) {
            boolean doesMatch = a.substring(0, a.indexOf("(") - 1).contains(program);
            boolean hasChildren = a.contains(arrow);

            if (doesMatch && hasChildren) {
                String[] pathChildren = getSubstring(a);
                for (String p : pathChildren) {
                    temp.add(p);
                }
                break;
            }
        }

        return temp;
    }


}


