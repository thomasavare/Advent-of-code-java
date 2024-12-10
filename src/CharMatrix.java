import java.util.Arrays;

public class CharMatrix {
    static char[][] cmatrix;
    static int rows;
    static int cols;

    public CharMatrix(char[][] matrix) {
        cmatrix = matrix;
    }

    public CharMatrix(String text) {
        String[] tMat = text.split("\n");
        rows = tMat.length;
        cols = tMat[0].length();
        cmatrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cmatrix[i][j] = tMat[i].charAt(j);
            }
        }
    }

    public void transpose() {
        char [][] tmp = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tmp[i][j] = cmatrix[j][i];
            }
        }
        cmatrix = tmp;
    }

    public void flipMatrix() {
        char [][] tmp = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tmp[i][j] = cmatrix[i][cols - j - 1];
            }
        }
        cmatrix = tmp;
    }

    public char[] getRow(int row) {
        return cmatrix[row];
    }

    public char[] getCol(int col) {
        char[] column = new char[cols];
        for (int i = 0; i < cols; i++) {
            column[i] = cmatrix[i][col];
        }
        return column;
    }

    public static char[] getSubDiag(int rank) {
        int startRow;
        int startCol;

        if (rank > 0) {
            startRow = 0;
            startCol = rank;
        } else {
            startRow = -rank;
            startCol = 0;
        }

        System.err.print("rank: " + rank + ", startRow: " + startRow + ", startCol: " + startCol);
        
        char[] diag = new char[rows - Math.abs(rank) + 4];

        for (int i = 0; startRow < rows && startCol < cols; i++) {
            diag[i] = cmatrix[startRow][startCol];
            startRow++;
            startCol++;
        }
//        System.err.print(", diag: " + Arrays.toString(diag));
        return diag;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            s.append("[");
            for (int j = 0; j < cols; j++) {
//            System.err.println(Arrays.toString(cmatrix[i]));
            s.append(cmatrix[i][j]).append(" ");
            }
            s.append("]\n");
        }
        s.append("shape :").append(rows).append("x").append(cols).append("\n");
        return s.toString();
    }
}