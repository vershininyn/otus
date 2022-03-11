package dev.projects.otus.dymanicarray;

import dev.projects.otus.dynamicarray.SingleArray;
import dev.projects.otus.dynamicarray.VectorArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VectorArrayTests {
    @Test
    public void vectorArrayAddTest() {
        VectorArray vArray = new VectorArray(5);

        vArray.add(Double.valueOf(5.0));
        vArray.add(Double.valueOf(5.0));
        vArray.add(Double.valueOf(5.0));

        Assertions.assertEquals(3, vArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),
                Double.valueOf(5.0),
                Double.valueOf(5.0),
                null,
                null}, vArray.asArray());

        vArray.add(Double.valueOf(6.0), 1);

        Assertions.assertEquals(4, vArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),
                Double.valueOf(6.0),
                Double.valueOf(5.0),
                Double.valueOf(5.0),
                null}, vArray.asArray());

        vArray.add(Double.valueOf(6.0), 0);

        Assertions.assertEquals(5, vArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(6.0),
                Double.valueOf(5.0),
                Double.valueOf(6.0),
                Double.valueOf(5.0),
                Double.valueOf(5.0)}, vArray.asArray());
    }

    @Test
    public void vectorArrayRemoveTest() {
        VectorArray vArray = new VectorArray(5);

        vArray.add(Double.valueOf(5.0));
        vArray.add(Double.valueOf(5.0));
        vArray.add(Double.valueOf(5.0));

        Assertions.assertEquals(3, vArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),
                Double.valueOf(5.0),
                Double.valueOf(5.0),
                null,
                null}, vArray.asArray());

        vArray.remove(0);

        Assertions.assertEquals(2, vArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),
                Double.valueOf(5.0),
                null,
                null}, vArray.asArray());

        vArray.remove(1);

        Assertions.assertEquals(1, vArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),null,null}, vArray.asArray());

        vArray.remove(2);

        Assertions.assertEquals(1, vArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),null}, vArray.asArray());
    }
}
