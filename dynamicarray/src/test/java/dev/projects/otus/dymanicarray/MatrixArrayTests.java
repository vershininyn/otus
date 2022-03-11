package dev.projects.otus.dymanicarray;

import dev.projects.otus.dynamicarray.FactorArray;
import dev.projects.otus.dynamicarray.MatrixArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixArrayTests {

    @Test
    public void matrixArrayAsFlatArray() throws Exception {
        MatrixArray mArray = new MatrixArray(5);

        mArray.add(Double.valueOf(5.0));
        mArray.add(Double.valueOf(5.0));
        mArray.add(Double.valueOf(5.0));

        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),
                Double.valueOf(5.0),
                Double.valueOf(5.0),
                null,
                null}, mArray.asArray());
    }

    @Test
    public void matrixArrayAddTest() throws Exception {
        MatrixArray mArray = new MatrixArray(5);

        Assertions.assertTrue(mArray.isEmpty());

        mArray.add(Double.valueOf(5.0));
        mArray.add(Double.valueOf(5.0));
        mArray.add(Double.valueOf(5.0));

        Assertions.assertEquals(3, mArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),
                Double.valueOf(5.0),
                Double.valueOf(5.0),
                null,
                null}, mArray.asArray());

        mArray.add(Double.valueOf(6.0), 1);

        Assertions.assertEquals(4, mArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),
                Double.valueOf(6.0),
                Double.valueOf(5.0),
                Double.valueOf(5.0),
                null}, mArray.asArray());

        mArray.add(Double.valueOf(6.0), 0);

        Assertions.assertEquals(5, mArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(6.0),
                Double.valueOf(5.0),
                Double.valueOf(6.0),
                Double.valueOf(5.0),
                Double.valueOf(5.0)}, mArray.asArray());
    }

    @Test
    public void matrixArrayRemoveTest() throws Exception {
        MatrixArray mArray = new MatrixArray(5);

        Assertions.assertTrue(mArray.isEmpty());

        mArray.add(Double.valueOf(5.0));
        mArray.add(Double.valueOf(5.0));
        mArray.add(Double.valueOf(5.0));

        Assertions.assertEquals(3, mArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),
                Double.valueOf(5.0),
                Double.valueOf(5.0),
                null,
                null}, mArray.asArray());

        mArray.remove(0);

        Assertions.assertEquals(2, mArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),
                Double.valueOf(5.0),
                null,
                null,
                null}, mArray.asArray());

        mArray.add(Double.valueOf(5.0));

        mArray.remove(1);

        Assertions.assertEquals(2, mArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),
                Double.valueOf(5.0),
                null,
                null,
                null}, mArray.asArray());

        mArray.remove(1);

        Assertions.assertEquals(1, mArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0), null, null, null, null}, mArray.asArray());
    }
}
