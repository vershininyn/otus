package dev.projects.otus.dymanicarray;

import dev.projects.otus.dynamicarray.FactorArray;
import dev.projects.otus.dynamicarray.SingleArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorArrayTests {
    @Test
    public void factorArrayAddTest() throws Exception {
        FactorArray fArray = new FactorArray<>(100, 2);

        Assertions.assertTrue(fArray.isEmpty());

        fArray.add(Double.valueOf(5.0));
        fArray.add(Double.valueOf(5.0));
        fArray.add(Double.valueOf(5.0));

        Assertions.assertEquals(3, fArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),
                Double.valueOf(5.0),
                Double.valueOf(5.0),
                null}, fArray.asArray());

        fArray.add(Double.valueOf(6.0), 1);

        Assertions.assertEquals(4, fArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),
                Double.valueOf(6.0),
                Double.valueOf(5.0),
                Double.valueOf(5.0)}, fArray.asArray());

        fArray.add(Double.valueOf(6.0), 0);

        Assertions.assertEquals(5, fArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(6.0),
                Double.valueOf(5.0),
                Double.valueOf(6.0),
                Double.valueOf(5.0),
                Double.valueOf(5.0)}, fArray.asArray());
    }

    @Test
    public void factorArrayRemoveTest() throws Exception {
        FactorArray fArray = new FactorArray<>(100, 2);

        Assertions.assertTrue(fArray.isEmpty());

        fArray.add(Double.valueOf(5.0));
        fArray.add(Double.valueOf(5.0));
        fArray.add(Double.valueOf(5.0));

        Assertions.assertEquals(3, fArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),
                Double.valueOf(5.0),
                Double.valueOf(5.0),
                null}, fArray.asArray());

        fArray.remove(0);

        Assertions.assertEquals(2, fArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),
                Double.valueOf(5.0)}, fArray.asArray());

        fArray.add(Double.valueOf(5.0));

        fArray.remove(1);

        Assertions.assertEquals(2, fArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),
                Double.valueOf(5.0)}, fArray.asArray());

        fArray.remove(1);

        Assertions.assertEquals(1, fArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0)}, fArray.asArray());
    }
}
