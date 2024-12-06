
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.SubmissionPublisher;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3_2 {
    final static String fileName = "inputs/input-aoc-3-2.txt";

    static int total = 0;

    public static void main(String[] args) {
        Day3_2.run();
    }

    public static void run() {
        String text = ReadFile.readFile(fileName);
        String regex = "mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\)";
        Matcher matcher = parseInputForMacth(text,regex);
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

    public static Matcher parseInputForMacth(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(text);
    }
}
