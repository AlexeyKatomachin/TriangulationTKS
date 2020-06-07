package by.katomakhin.magistry.tks.triangulation.output;

public class OutputMatrix {
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public static void printMatrixWithCoefficients(int[][] matrix, String[] matrixCoefficients) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (i < matrixCoefficients.length) {
                System.out.print(matrixCoefficients[i] + "\t");
            } else {
                System.out.print("1\t");
            }
        }
        System.out.println("");
        printMatrix(matrix);
    }
}
