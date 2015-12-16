package LW_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by user on 9/15/2015.
 */

public class Matrix {
    private int sizeRow;
    private int sizeColumn;
    private int [][] matrix;
    public void inputMatrixDim() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter sizeRow : ");
            sizeRow = Integer.parseInt(br.readLine());
            System.out.println("Enter sizeColumn : ");
            sizeColumn = Integer.parseInt(br.readLine());
            System.out.println("Matrix dimension : " + sizeRow + " * " + sizeColumn);
        } catch (IOException f) {
            f.printStackTrace();
        }
        if (sizeColumn < 0 || sizeRow < 0) {
            throw new IllegalArgumentException();
        }
    }
    public void fillMatrixArg() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        matrix = new int [sizeRow][sizeColumn];
        System.out.println("Enter matrix elements : ");
        try {
            for (int i = 0; i < sizeRow; i++) {
                for (int j = 0; j < sizeColumn; j++) {
                    matrix[i][j] = Integer.parseInt(br.readLine());
                }
            }
        } catch (IOException h) {
            h.printStackTrace();
        }
    }
    public void printMatrix() {
        for (int i = 0; i < sizeRow; i++) {
            for (int j = 0; j < sizeColumn; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public int searchMaxSeries(int i) {
        int max = 0;
        int maxSeries = 0;
        int amountRepeatedElem = 1;
        for (int j = 1; j < sizeColumn - 1; j++) {
            if (matrix[i][j - 1] == matrix[i][j]) {
                amountRepeatedElem++;
                if (matrix[i][j] != matrix[i][j + 1]) {
                    if (amountRepeatedElem > maxSeries) {
                        maxSeries = amountRepeatedElem;
                    }
                    amountRepeatedElem = 1;
                    max = maxSeries;
                    maxSeries = 0;
                }
            }
        }
        return max;
    }
    public int searchMinSeries() {
        int minSeries = 10;
        int numStr = 0;
        int amountRepeatedElem = 1;
        for (int i = 0; i < sizeRow; i++) {
                amountRepeatedElem = searchMaxSeries(i);
                if (amountRepeatedElem < minSeries) {
                    minSeries = amountRepeatedElem;
                    numStr = i;
                }
        }
        System.out.println("Minimal series size = " + minSeries);
        return numStr;
    }
    public void printResult() {
        int numStr = searchMinSeries();
        System.out.println("String with minimal series : ");
        for (int j = 0; j < sizeColumn; j++) {
            System.out.print(matrix[numStr][j] + " ");
        }
    }
}