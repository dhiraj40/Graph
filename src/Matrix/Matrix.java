package Matrix;

import java.util.ArrayList;

public class Matrix {
    int rowCount;
    int colCount;
    int[][] matrix;
    public Matrix(int rowCount, int colCount) {
        this.rowCount = rowCount;
        this.colCount = colCount;
        matrix = new int[rowCount][colCount];
    }

    public Matrix(int rowCount,int colCount,int[] arr){
        this.rowCount = rowCount;
        this.colCount = colCount;

        matrix = new int[rowCount][colCount];
        int k = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                this.matrix[i][j] = arr[k++];
            }
        }
    }

    public Matrix(int[][] matrix){
        this.rowCount = matrix.length;
        this.colCount = matrix[0].length;
        this.matrix = matrix;
    }
    
    public Matrix rotateByPos90Degree(){
        int[][] arr = new int[colCount][rowCount];
        for (int i = 0; i < colCount; i++) {
            for (int j = 0; j < rowCount; j++) {
                arr[i][j] = this.matrix[rowCount-j-1][i];
            }
        }
        return new Matrix(arr);
    }
    
    public void printMatrix(){
        System.out.println("\nMatrix : ");
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();            
        }
    }
}
