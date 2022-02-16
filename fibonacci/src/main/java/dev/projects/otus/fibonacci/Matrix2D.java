package dev.projects.otus.fibonacci;

import java.math.BigInteger;

public class Matrix2D {
    private final BigInteger[] data = new BigInteger[]{new BigInteger("1", 10), new BigInteger("1", 10), new BigInteger("1", 10), new BigInteger("0", 10)};

    public Matrix2D() {

    }

    public BigInteger getValue(int row, int column) {
        return data[getIndex(row, column)];
    }

    public void setValue(int row, int column, BigInteger value) {
        data[getIndex(row, column)] = value;
    }

    public Matrix2D multiply(Matrix2D other) {
        Matrix2D resultMatrix = new Matrix2D();

        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < 2; column++) {
                BigInteger value = new BigInteger("0",10);

                for (int rIndex = 0; rIndex < 2; rIndex++) {
                    value = value.add(getValue(row, rIndex).multiply(other.getValue(rIndex, column)));
                }

                resultMatrix.setValue(row, column, value);
            }
        }

        return resultMatrix;
    }

    private int getIndex(int row, int column) {
        return 2 * row + column;
    }
}
