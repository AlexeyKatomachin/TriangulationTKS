package by.katomakhin.magistry.tks.triangulation.components;

public class ElementToConnectivity {
    private int rowNum;
    private int element;

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public ElementToConnectivity getElement(int[] row, int rowNum) {
        if (row[rowNum] > 0) {
            this.setElement(-1);
            this.setRowNum(rowNum);
        } else {
            this.setElement(1);
            this.setRowNum(rowNum);
        }
        return this;
    }
}
