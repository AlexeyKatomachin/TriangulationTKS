package by.katomakhin.magistry.tks.triangulation.input;

import java.util.Scanner;

public class InputMatrix {
    Scanner in;

    public InputMatrix() {
        in = new Scanner(System.in);
    }

    public int[][] inputMatrix() {
        return input2XMatrix(inputRow(), inputColumn());
    }

    public String[] getMatrixCoefficients(int numSourceColumn, int[][] matrix) {
        String[] matrixCoefficients = new String[matrix[0].length];
        for (int i = 0, j = 1; i < matrix[0].length; i++, j++) {
            if (i == numSourceColumn - 1) {
                matrixCoefficients[i] = "f";
                j--;
            } else {
                matrixCoefficients[i] = "p" + j;
            }
        }
        return matrixCoefficients;
    }

    private int[][] input2XMatrix(int row, int column) {
        int[][] matrix = new int[column][row];

        for (int i = 0; i < column; i++) {
            System.out.println("Введите элементы " + (i + 1) + "-й строки:");
            for (int j = 0; j < row; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        return matrix;
    }

    private int inputRow() {
        System.out.println("Введите размер строк");
        return in.nextInt();
    }

    private int inputColumn() {
        System.out.println("Введите размер столбцов");
        return in.nextInt();
    }
}
