package by.katomakhin.magistry.tks.triangulation;

import by.katomakhin.magistry.tks.triangulation.algorithm.AlgorithmTriangulation;
import by.katomakhin.magistry.tks.triangulation.components.TKS;
import by.katomakhin.magistry.tks.triangulation.input.InputMatrix;
import by.katomakhin.magistry.tks.triangulation.output.OutputMatrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new InputMatrix().inputMatrix();
        System.out.println("Введенная матрица: ");
        OutputMatrix.printMatrix(matrix);
        System.out.println("Введите номер источникового столбца: ");
        String[] matrixCoefficients = new InputMatrix().getMatrixCoefficients(new Scanner(System.in).nextInt(), matrix);
        System.out.println("Введенная матрица с коэффицентами: ");
        TKS tks = new TKS(matrix, matrixCoefficients);
        OutputMatrix.printMatrixWithCoefficients(tks.getMatrix(), tks.getMatrixCoefficients());
        AlgorithmTriangulation.triangulate(tks);
        System.out.println("Триангулированная матрица с коэффицентами: ");
        OutputMatrix.printMatrixWithCoefficients(tks.getMatrix(), tks.getMatrixCoefficients());
    }
}
