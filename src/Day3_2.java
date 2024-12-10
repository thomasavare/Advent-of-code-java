import java.util.regex.Matcher;

public class Day3_2 {
    final static String fileName = "inputs/input-aoc-3-2.txt";

    static int total = 0;

    public static void main(String[] args) {
        Day3_2.run();
    }

    public static void run() {
        String text = ReadFile.readFile(fileName);

        String regex = "mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\)";
        Matcher matcher = Day3_1.parseInputForMacth(text,regex);
        boolean mult = true;

        while (matcher.find()) {
            String sub = text.substring(matcher.start(), matcher.end());
            if (sub.equals("don't()")) {
                mult = false;
            }
            else if (sub.equals("do()")) {
                mult = true;
            }
            else if (mult) {
                String[] tmp = (sub.substring(4, sub.length() - 1)).split(",");
                total += Integer.parseInt(tmp[0]) * Integer.parseInt(tmp[1]);
            }
        }

        System.out.println("Puzzle Result: " + total);
    }
}
