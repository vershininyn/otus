package dev.projects.otus.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class Matrix2DTests {
    @Test
    public void matrix2DTests() {
        Matrix2D m = new Matrix2D(), m1 = new Matrix2D();

        Matrix2D result = m.multiply(m1);

        Assertions.assertEquals(new BigInteger("2", 10), result.getValue(0,0));
        Assertions.assertEquals(new BigInteger("1", 10), result.getValue(0,1));
        Assertions.assertEquals(new BigInteger("1", 10), result.getValue(1,0));
        Assertions.assertEquals(new BigInteger("1", 10), result.getValue(1,1));
    }
}
