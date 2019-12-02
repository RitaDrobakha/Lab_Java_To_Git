package Lab_2;

import java.util.ArrayList;
import java.util.Arrays;

public class Matrix {
    protected int[][] array;
    protected float determinant;

    @Override
    public String toString() {
        return "Lab_2.Matrix{" +
                "array=" + Arrays.toString(array) +
                ", determinant=" + determinant +
                '}';
    }

    public Matrix() {
    }

    public Matrix(int[][] array, float determinant) {
        this.array = array;
        this.determinant = determinant;
    }

    public int[][] getArray() {
        return array;
    }

    public void setArray(int[][] array) {
        this.array = array;
    }

    public float getDeterminant() {
        return determinant;
    }

    public void setDeterminant(float determinant) {
        this.determinant = determinant;
    }

    protected float calculateDeterminant (int[][] array) {
        return ((array[0][0] * array[1][1]) - (array[0][1] * array[1][0]));
    }
}
