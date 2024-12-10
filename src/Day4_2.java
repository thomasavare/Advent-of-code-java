public class Day4_2 {
    static String fileName = "inputs/input-aoc-4-1.txt";

    static char[][] kernel1 = {
            {'M', 0, 'M'},
            {0, 'A', 0},
            {'S', 0, 'S'}};
    static char[][] kernel2 = {
            {'M', 0, 'S'},
            {0, 'A', 0},
            {'M', 0, 'S'}};
    static char[][] kernel3 = {
            {'S', 0, 'M'},
            {0, 'A', 0},
            {'S', 0, 'M'}};
    static char[][] kernel4 = {
            {'S', 0, 'S'},
            {0, 'A', 0},
            {'M', 0, 'M'}};
    static char[][][] kernels = {kernel1, kernel2, kernel3, kernel4};


    public static void main(String[] args) {
        run();

    }

    public static void run() {
        String content = ReadFile.readFile(fileName);
        new CharMatrix(content);
        int count = applyCountKernel();
        System.out.println(count);
    }

    public static int applyCountKernel() {
        int count = 0;
        for (int i = 0; i < CharMatrix.rows - 2; i++) {
            for (int j = 0; j < CharMatrix.cols - 2; j++) {
                if (CharMatrix.cmatrix[i + 1][j + 1] != 'A') {
                    continue;
                }
                for (char[][] kernel : kernels) {
                    if (verifyKernel(i, j, kernel)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    static boolean verifyKernel(int row, int col, char[][] kernel) {
        boolean expr3 = kernel[0][0] == CharMatrix.cmatrix[row][col];
        boolean expr2 = kernel[0][2] == CharMatrix.cmatrix[row][col + 2];
        boolean expr1 = kernel[1][1] == CharMatrix.cmatrix[row + 1][col + 1];
        boolean expr4 = kernel[2][0] == CharMatrix.cmatrix[row + 2][col];
        boolean expr5 = kernel[2][2] == CharMatrix.cmatrix[row + 2][col + 2];
        return expr1 && expr2 && expr3 && expr4 && expr5;
    }
}
