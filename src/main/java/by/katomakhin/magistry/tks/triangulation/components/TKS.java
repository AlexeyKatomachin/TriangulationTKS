package by.katomakhin.magistry.tks.triangulation.components;

public class TKS {
    private int[][] matrix;
    private String[] matrixCoefficients;

    public TKS(int[][] matrix, String[] matrixCoefficients) {
        this.matrix = matrix;
        this.matrixCoefficients = matrixCoefficients;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public String[] getMatrixCoefficients() {
        return matrixCoefficients;
    }

    public void setMatrixCoefficients(String[] matrixCoefficients) {
        this.matrixCoefficients = matrixCoefficients;
    }

    public void setEmptyMatrix() {
        this.matrix = new int[1][1];
        this.matrix[0][0] = 1;
        this.matrixCoefficients = new String[1];
        this.matrixCoefficients[0] = "f";
    }

    public int getNumOfFirsNotNullElement(int rowNum) {
        for (int i = 0; i < matrix[rowNum].length; i++) {
            if (matrix[rowNum][i] != 0) {
                return i;
            }
        }
        return 0;
    }
}
