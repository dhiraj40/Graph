package Matrix;

public class TempMain {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12};
        Matrix matrix = new Matrix(4,3,arr);
        matrix.printMatrix();
        matrix.rotateByPos90Degree().printMatrix();
    }
}
