public class Day4_1 {
    static String fileName = "inputs/input-aoc-4-1.txt";

    static char[] match1 = {'X', 'M', 'A', 'S'};
    static char[] match2 = {'S', 'A', 'M', 'X'};

    public static void main(String[] args) {
        Day4_1.run();
    }

    public static void run() {
        String content = ReadFile.readFile(fileName);
        CharMatrix cmatrix = new CharMatrix(content);
        int hor = horizontal(cmatrix);
        int ver = vertical(cmatrix);
        int diag1 = diagonal();
        cmatrix.flipMatrix();
        int diag2 = diagonal();
        System.out.println("rows: " + CharMatrix.rows + ", cols: " + CharMatrix.cols);
        System.out.println("Horizontal: " + hor);
        System.out.println("Vertical: " + ver);
        System.out.println("Diagonal: " + diag1);
        System.out.println("Other Diag: " + diag2);
        System.out.println("Total: " + (hor + ver + diag1 + diag2));
    }

    public static int horizontal(CharMatrix cmatrix) {
        int count = 0;
        for (int i = 0; i < CharMatrix.rows; i++) {
            char[] row = cmatrix.getRow(i);
            for (int j = 0; j < CharMatrix.cols - 3; j++) {
                if (isMatch(row, match1, j)) {
                    count++;
                }
                else if (isMatch(row, match2, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int vertical(CharMatrix cmatrix) {
        cmatrix.transpose();
        int count = horizontal(cmatrix);
        cmatrix.transpose();
        return count;
    }

    public static int diagonal() {
        int count = 0;
        for (int i = -CharMatrix.rows; i < CharMatrix.cols + 1; i++) {
            char[] subDiag = CharMatrix.getSubDiag(i);
            for (int j = 0; j < subDiag.length - 3; j++) {
                if (isMatch(subDiag, match1, j)) {
                    count++;
                }
                if (isMatch(subDiag, match2, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isMatch(char[] array, char[] match, int begin) {
        boolean isMatch = true;
        for (int k = 0; k < 4; k++) {
            if (array[begin + k] != match[k]) {
                isMatch = false;
                break;
            }
        }
        return isMatch;
    }
}
