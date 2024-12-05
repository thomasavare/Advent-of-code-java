import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Iterator;

public class Day1_2 {
    final static String fileName = "src/input-aoc-1.txt";

    static ArrayList<Integer> left = new ArrayList<Integer>();
    static PriorityQueue<Integer> right = new PriorityQueue<Integer>();

    public static void main(String[] args) {
        Day1_2.run(fileName);
    }

    public static void run(String fileName) {
        String text = ReadFile.readfile(fileName);
        parseInput(text);
        int d = Distance(left, right);
        System.out.println(d == 2367773);
    }

    public static void parseInput(String text) {
        String[] newString = text.split("\\n");
        for (int i = 0; i < newString.length; i++) {
            String[] tmp = newString[i].split("\\s+");
            left.add(Integer.parseInt(tmp[0]));
            right.add(Integer.parseInt(tmp[1]));
        }
    }

    public static int Distance(ArrayList<Integer> left, PriorityQueue<Integer> right) {
        Collections.sort(left);
//        Collections.sort(right);
        Iterator<Integer> literator = left.iterator();
        Iterator<Integer> riterator = right.iterator();

        int distance = 0;

        while (literator.hasNext() && riterator.hasNext()) {
            int v1 = literator.next();
            int v2 = riterator.next();
            System.out.println(v1 + " " + v2);
            distance += Math.abs(v1 - v2);
        }
        return distance;
    }

}
