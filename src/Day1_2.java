import java.util.ArrayList;
import java.util.HashMap;

public class Day1_2 {
    final static String fileName = "inputs/input-aoc-1-2.txt";

    static ArrayList<Integer> left = new ArrayList<Integer>();
    static ArrayList<Integer> right = new ArrayList<Integer>();

    public static void main(String[] args) {
        Day1_2.run(fileName);
    }

    public static void run(String fileName) {
        String text = ReadFile.readfile(fileName);
        parseInput(text);
        int d = similarityScore(left, right);
        System.out.println(d);
    }

    public static void parseInput(String text) {
        String[] newString = text.split("\\n");
        for (int i = 0; i < newString.length; i++) {
            String[] tmp = newString[i].split("\\s+");
            left.add(Integer.parseInt(tmp[0]));
            right.add(Integer.parseInt(tmp[1]));
        }
    }

    public static int similarityScore(ArrayList<Integer> left, ArrayList<Integer> right) {
        HashMap<Integer, Integer> count = count(right);

        int total = 0;

        for (int i = 0; i < left.size(); i++) {
            total += left.get(i) * count.getOrDefault(left.get(i), 0);
        }

        return total;
    }

    public static HashMap<Integer, Integer> count(ArrayList<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (Integer i : list) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map;
    }
}
