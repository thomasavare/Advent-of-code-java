import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Queue;

public class Day7_1 {
    static Queue<ArrayList<BigInteger>> queue;

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        String content = ReadFile.readFile("inputs/input-aoc-7-1.txt");
        formatQueue(content);
    }

    public static void formatQueue(String content) { // return Queue<ArrayList<Integer>>
        String[] lines = content.split("\n");
        for (String line : lines) {
            String[] tmp = line.split(":\\s+");
            System.err.println(tmp[0] + " : " + tmp[1]);
//            BigInteger token1 = BigInteger.parseInt(tmp[0]);
            String[] tmp1 = tmp[1].split("\\s+");
            ArrayList<BigInteger> arr = new ArrayList<BigInteger>(tmp1.length);
            arr.add(new BigInteger(tmp[0]));
            for ( String number: tmp1) {
                arr.add(new BigInteger(number));
//                System.err.print("[" + number + "] ");
            }
        }
    }
}