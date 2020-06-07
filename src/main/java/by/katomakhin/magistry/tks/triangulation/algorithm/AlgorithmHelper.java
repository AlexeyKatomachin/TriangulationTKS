package by.katomakhin.magistry.tks.triangulation.algorithm;

import by.katomakhin.magistry.tks.triangulation.components.ElementToConnectivity;
import by.katomakhin.magistry.tks.triangulation.components.TKS;
import com.sun.istack.internal.NotNull;

import static java.lang.Math.abs;

public class AlgorithmHelper {
    public static boolean checkModSumRow(int[] row) {
        if (row == null) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < row.length; i++) {
            count += abs(row[i]);
        }
        if (count > 3) {
            return true;
        }
        return false;
    }

    public static boolean checkOneElementInRow(int[] row) {
        int count = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0) {
                count++;
            }
        }
        if (count != 1) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkEmptyRow(int[] row) {
        int count = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0) {
                count++;
            }
        }
        if (count != 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void addConnectivityComponent(@NotNull TKS tks) {
        int[][] newMatrix = new int[tks.getMatrix().length + 1][tks.getMatrix()[0].length + 1];
        String[] newMatrixCoefficients = new String[tks.getMatrixCoefficients().length + 1];
        for (int i = 0; i < tks.getMatrix().length; i++) {
            for (int j = 0; j < tks.getMatrix()[i].length; j++) {
                newMatrix[i][j] = tks.getMatrix()[i][j];
            }
            newMatrix[i][tks.getMatrix()[0].length] = 0;
        }
        for (int i = 0; i < (newMatrix[0].length - 1); i++) {
            newMatrix[tks.getMatrix().length][i] = 0;
        }
        newMatrix[tks.getMatrix().length][tks.getMatrix()[0].length] = 1;
        for (int i = 0; i < tks.getMatrixCoefficients().length; i++) {
            newMatrixCoefficients[i] = tks.getMatrixCoefficients()[i];
        }
        newMatrixCoefficients[tks.getMatrixCoefficients().length] = "1";
        tks.setMatrix(newMatrix);
        tks.setMatrixCoefficients(newMatrixCoefficients);
    }

    public static void addElementsToConnectivityComponent(@NotNull ElementToConnectivity columnNumWithSize1,
                                                          @NotNull ElementToConnectivity columnNumWithSize2,
                                                          @NotNull int[][] matrix) {
        matrix[matrix.length - 1][columnNumWithSize1.getRowNum()] = columnNumWithSize1.getElement();
        matrix[matrix.length - 1][columnNumWithSize2.getRowNum()] = columnNumWithSize2.getElement();
    }

    public static void addRows(@NotNull int[][] matrix, int rowNumTo, int rowNumFrom) {
        for (int i = 0; i < matrix[rowNumTo].length; i++) {
            matrix[rowNumTo][i] += matrix[rowNumFrom][i];
        }
    }

    public static void eqwivalentsRow(@NotNull int[][] matrix, int rowNum) {
        for (int i = 0; i < matrix[rowNum].length; i++) {
            if (matrix[rowNum][i] != 0) {
                matrix[rowNum][i] /= abs(matrix[rowNum][i]);
            }
        }
    }

    public static ElementToConnectivity getSizeOfFirstNotNullElement(int[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0) {
                return new ElementToConnectivity().getElement(row, i);
            }
        }
        return null;
    }

    public static ElementToConnectivity getSizeOfSecondNotNullElement(int[] row) {
        int count = 1;
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0) {
                if (count > 0) {
                    count--;
                    continue;
                }
                return new ElementToConnectivity().getElement(row, i);
            }
        }
        return null;
    }

    public static void removeEmptyRowAndColumn(TKS tks, int rowNum) {
        int[][] newMatrix = new int[tks.getMatrix().length - 1][tks.getMatrix()[0].length - 1];
        String[] newMatrixCoefficients = new String[tks.getMatrixCoefficients().length - 1];
        int elementNum = 0;
        for (int i = 0; i < tks.getMatrix()[rowNum].length; i++) {
            if (tks.getMatrix()[rowNum][i] != 0) {
                elementNum = i;
            }
        }
        for (int i = 0, k = 0; i < tks.getMatrix().length; i++, k++) {
            if (i == rowNum) {
                i++;
            }
            if (i >= tks.getMatrix()[0].length) {
                break;
            }
            for (int j = 0, l = 0; j < tks.getMatrix()[rowNum].length; j++, l++) {
                if (j == elementNum) {
                    j++;
                }
                if (j >= tks.getMatrix()[0].length) {
                    break;
                }
                newMatrix[k][l] = tks.getMatrix()[i][j];
            }
        }
        for (int i = 0, k = 0; i < tks.getMatrix()[0].length; i++, k++) {
            if (i == elementNum) {
                i++;
            }
            if (i >= tks.getMatrix()[0].length) {
                break;
            }
            newMatrixCoefficients[k] = tks.getMatrixCoefficients()[i];
        }
        tks.setMatrix(newMatrix);
        tks.setMatrixCoefficients(newMatrixCoefficients);
    }

    public static void removeEmptyColumn(TKS tks, int rowNum) {
        int[][] newMatrix = new int[tks.getMatrix().length - 1][tks.getMatrix()[0].length];
        for (int i = 0, k = 0; i < tks.getMatrix().length; i++, k++) {
            if (i == rowNum) {
                i++;
            }
            if (i >= tks.getMatrix()[0].length) {
                break;
            }
            for (int j = 0; j < tks.getMatrix()[rowNum].length; j++) {
                newMatrix[k][j] = tks.getMatrix()[i][j];
            }
        }
        tks.setMatrix(newMatrix);
    }
}
