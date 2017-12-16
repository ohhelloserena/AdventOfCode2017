import javax.swing.tree.TreeNode;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //System.out.println("Hello World!");

        Scanner sc = new Scanner(new File("src/test_input"));
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        String[] arr = lines.toArray(new String[0]);

        // Part 1

        List<String> children = new ArrayList<>();
        List<String> parents = new ArrayList<>();
        String root = "";

        for (int i = 0; i < arr.length; i++) {
            String program = arr[i];
            String arrow = "-> ";
           

            if (program.contains(arrow)) {
                String parentSubstring = program.substring(0, program.indexOf(" ("));
                parents.add(parentSubstring);

                String childrenSubstring = program.substring(program.indexOf(arrow) + arrow.length(), program.length());
                String[] child = childrenSubstring.split(", ");

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

        for (int m = 0; m < arr.length; m++) {

            
        }

        

        
    }
}

