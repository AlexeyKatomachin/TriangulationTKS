package by.katomakhin.magistry.tks.triangulation.algorithm;

import by.katomakhin.magistry.tks.triangulation.components.TKS;

public abstract class AlgorithmTriangulation {

    public static void triangulate(TKS tks) {
        if (tks.getMatrix() == null) {
            System.out.println("Матрица не задана");
            return;
        }
        removeEmptyRowAndColumn(tks);
        if (tks.getMatrix().length > 0) {
            for (int i = 0; i < tks.getMatrix().length; i++) {
                if (AlgorithmHelper.checkModSumRow(tks.getMatrix()[i])) {
                    if (!AlgorithmHelper.checkOneElementInRow(tks.getMatrix()[i])) {
                        triangulateIteration(tks, i);
                    } else {
                        AlgorithmHelper.eqwivalentsRow(tks.getMatrix(), i);
                    }
                }
            }
        }
    }

    public static void removeEmptyRowAndColumn(TKS tks) {
        for (int i = 0; i < tks.getMatrix().length; i++) {
            if (AlgorithmHelper.checkEmptyRow(tks.getMatrix()[i])) {
                AlgorithmHelper.removeEmptyColumn(tks, i);
                i--;
            } else if (AlgorithmHelper.checkOneElementInRow(tks.getMatrix()[i])) {
                if ("f".equals(tks.getMatrixCoefficients()[tks.getNumOfFirsNotNullElement(i)])) {
                    tks.setEmptyMatrix();
                    break;
                }
                AlgorithmHelper.removeEmptyRowAndColumn(tks, i);
                i--;
            }
            if (tks.getMatrix().length <= i) {
                break;
            }
        }
    }

    private static void triangulateIteration(TKS tks, int rowNum) {
        if (AlgorithmHelper.checkModSumRow(tks.getMatrix()[rowNum])) {
            if (!AlgorithmHelper.checkOneElementInRow(tks.getMatrix()[rowNum])) {
                AlgorithmHelper.addConnectivityComponent(tks);
                AlgorithmHelper.addElementsToConnectivityComponent(AlgorithmHelper.getSizeOfFirstNotNullElement(tks.getMatrix()[rowNum]),
                        AlgorithmHelper.getSizeOfSecondNotNullElement(tks.getMatrix()[rowNum]), tks.getMatrix());
                AlgorithmHelper.addRows(tks.getMatrix(), rowNum, tks.getMatrix().length - 1);
                triangulateIteration(tks, rowNum);
            } else {
                AlgorithmHelper.eqwivalentsRow(tks.getMatrix(), rowNum);
            }
        }
    }
}
