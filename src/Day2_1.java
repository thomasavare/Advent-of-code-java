import java.util.ArrayList;

public class Day2_1 {
    final static String fileName = "inputs/input-aoc-2-1.txt";

    static ArrayList<ArrayList<Integer>> levels = new ArrayList<>();

    public static void main(String[] args) {
        Day2_1.run(fileName);
    }

    static void run(String fileName) {
        String text = ReadFile.readFile(fileName);
        parseInput(text);
        int count = 0;
        for (ArrayList<Integer> level : levels) {
            System.out.println(level);
            boolean safe = isSafe(level);
            System.out.println(safe + "\n");
            count += safe ? 1 : 0;
        }
        System.out.println(count);
    }

    static void parseInput(String text) {
        String[] lines = text.split("\n");
//        ArrayList<ArrayList<Integer>> levels = new ArrayList<>(lines.length);

        for (int i = 0; i < lines.length; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (String s: lines[i].split(" ")) {
                tmp.add(Integer.parseInt(s));
                // Alternative: isSafe(tmp) here
            }
            levels.add(tmp);
        }
    }

    static boolean isSafe(ArrayList<Integer> level) {
//        ArrayList<Integer> tmp = new ArrayList<>(level.size() - 1);
        boolean safe = true;
        boolean increasing = true;
        boolean decreasing = true;
        boolean delta = true;
        for (int i = 1; i < level.size(); i++) {
//            tmp.add(level.get(i) - level.get(i - 1));
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
        System.out.println("Increasing: " + increasing + ", decreasing: " + decreasing + ", delta: " + delta);
        return (increasing || decreasing) && delta;
    }

    public static boolean increasing(Integer prec, Integer next) {
            return true;
        }
}
