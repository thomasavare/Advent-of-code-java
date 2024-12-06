import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;

public class Day1_1 {
    final static String fileName = "inputs/input-aoc-1-1.txt";

    static ArrayList<Integer> left = new ArrayList<Integer>();
    static ArrayList<Integer> right = new ArrayList<Integer>();

    public static void main(String[] args) {
        Day1_1.run(fileName);
    }

    public static void run(String fileName) {
        String text = ReadFile.readFile(fileName);
        parseInput(text);
        int d = Distance(left, right);
        System.out.println("Total distance: "+ d);
    }

    public static void parseInput(String text) {
        String[] newString = text.split("\\n");
        for (int i = 0; i < newString.length; i++) {
            String[] tmp = newString[i].split("\\s+");
            left.add(Integer.parseInt(tmp[0]));
            right.add(Integer.parseInt(tmp[1]));
        }
    }

    public static int Distance(ArrayList<Integer> left, ArrayList<Integer> right) {
        Collections.sort(left);
        Collections.sort(right);
        Iterator<Integer> literator = left.iterator();
        Iterator<Integer> riterator = right.iterator();

        int distance = 0;

        while (literator.hasNext() && riterator.hasNext()) {
            int v1 = literator.next();
            int v2 = riterator.next();
            distance += Math.abs(v1 - v2);
        }
        return distance;
    }

}
