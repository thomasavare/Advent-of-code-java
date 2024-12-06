import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3_1 {
    final static String fileName = "inputs/input-aoc-3-1.txt";

    static int total = 0;

    public static void main(String[] args) {
        Day3_1.run();
    }

    public static void run() {
        String text = ReadFile.readFile(fileName);
        Matcher matcher = parseInputForMacth(text,"mul\\(\\d+,\\d+\\)");
        while (matcher.find()) {
            String[] sub = text.substring(matcher.start() + 4, matcher.end() - 1).split(",");
            total += Integer.parseInt(sub[0]) * Integer.parseInt(sub[1]);
        }
        System.out.println("Puzzle Result: " + total);
    }

    public static Matcher parseInputForMacth(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(text);
    }
}
