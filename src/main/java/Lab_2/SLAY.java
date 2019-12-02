package Lab_2;

import Lab_2.Matrix;
import Lab_2.MyAnnotation;
import Lab_2.MyInterface;

import java.util.Arrays;

@MyAnnotation
public class SLAY extends Matrix implements MyInterface {
    private int[] freeMember = new int[2];
    private Matrix matrix = new Matrix();

    @Override
    public String toString() {
        return "Lab_2.SLAY{" +
                "freeMember=" + Arrays.toString(freeMember) +
                ", matrix=" + matrix +
                ", array=" + Arrays.toString(array) +
                ", determinant=" + determinant +
                '}';
    }

    public SLAY() {

    }

    public SLAY(int[] freeMember, int[][] array) {
        this.freeMember = freeMember;
        this.matrix.array = array;
    }

    public SLAY(int[][] array, int[] freeMember) {
        this.matrix.array = array;
        this.freeMember = freeMember;
    }

    public Matrix getMatrix() {
        System.out.println("Getter: getMatrix");
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }


    public int[] getFreeMember() {
        System.out.println("Getter: getFreeMember");
        return freeMember;
    }

    public void setFreeMember(int[] freeMember) {
        this.freeMember = freeMember;
    }

    @MyAnnotation
    private void solutionArray () {
        float x = calculateDeterminant(matrix.array);
        int[][] arrayX1 = {{matrix.array[0][0], matrix.array[1][0]}, {freeMember[0], freeMember[1]}};
        float x1 = calculateDeterminant(arrayX1)/x;
        int[][] arrayX2 = {{freeMember[0], freeMember[1]}, {matrix.array[0][1], matrix.array[1][1]}};
        float x2 = calculateDeterminant(arrayX2)/x;
        System.out.println("x1 = " + x1);
        System.out.println("x2 = " + x2);
    }

}
