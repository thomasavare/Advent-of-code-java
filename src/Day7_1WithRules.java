import java.util.ArrayDeque;
import java.util.Arrays;

public class Day7_1WithRules {
    static String fileName = "inputs/test-7-1.txt";

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        String content = ReadFile.readFile(fileName);
        System.out.println(count(content));
    }

    public static long count(String content) {// return Queue<ArrayList<Integer>>
        String[] lines = content.split("\n");
        long count = 0;
        for (String line : lines) {
            String[] tmp = line.split(":\\s+");
//            System.err.println(tmp[0] + " : " + tmp[1]);
            long result = Long.parseLong(tmp[0]);
            long[] intArray = stringToLongArray(tmp[1]);
            if (TreeSearch(intArray, result)) {
                count += result;
            }
        }
        return count;
    }

    public static long[] stringToLongArray(String input) {
        return Arrays.stream(input.split("\\s+")).mapToLong(string -> Long.parseLong(string)).toArray();
    }

    public static boolean TreeSearch(long[] input, long result) {
        Node71WithRules root = new Node71WithRules(input[0]);
        ArrayDeque<Node71WithRules> stack = new ArrayDeque<>();
        stack.push(root);

        int i = -1;
        while (!stack.isEmpty()) {
            Node71WithRules node = stack.pop();
            i = node.depth;

            if (node.depth <= input.length - 1) {
                node.addChild = node.insertAdd(input[node.depth]);
                stack.push(node.addChild);

                node.multChild = node.insertMult(input[node.depth]);
                stack.push(node.multChild);

                if (node.addChild.getSum() == result) {
                    return true;
                }
                if (node.multChild.getSum() == result) {
                    return true;
                }
            }
        }
        return false;
    }
}