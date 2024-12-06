import java.util.ArrayList;

public class Day2_2 {
    final static String fileName = "inputs/input-aoc-2-1.txt";

    static ArrayList<ArrayList<Integer>> levels = new ArrayList<>();

    public static void main(String[] args) {
        Day2_2.run();
    }

    static void run() {
        String text = ReadFile.readFile(Day2_2.fileName);
        parseInput(text);
        int count = 0;
        for (ArrayList<Integer> level : levels) {
            for (int i = 0; i < level.size(); i++) {
                ArrayList<Integer> tmp = (ArrayList<Integer>)level.clone();
                tmp.remove(i);
                if (isSafe(tmp)) {
                    count++;
                    break;
                }
            }
        }
        System.out.println("Safe reports: " + count + "\n");
    }

    static void parseInput(String text) {
        String[] lines = text.split("\n");
        for (String line : lines) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (String s : line.split(" ")) {
                tmp.add(Integer.parseInt(s)); // Alternative: isSafe(tmp) here
            }
            levels.add(tmp);
        }
    }

    static boolean isSafe(ArrayList<Integer> level) {
        boolean increasing = true;
        boolean decreasing = true;
        boolean delta = true;
        for (int i = 1; i < level.size(); i++) {
            Integer tmp = level.get(i) - level.get(i - 1);
            if (tmp >= 0) {
                decreasing = false;
            }
            if (tmp <= 0) {
                increasing = false;
            }
            if (Math.abs(tmp) < 1 || Math.abs(tmp) > 3) {
                delta = false;
            }
        }
        return (increasing || decreasing) && delta;
    }

}
