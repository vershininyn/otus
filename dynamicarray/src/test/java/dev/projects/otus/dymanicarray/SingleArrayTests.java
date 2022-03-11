package dev.projects.otus.dymanicarray;

import dev.projects.otus.dynamicarray.SingleArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingleArrayTests {
    @Test
    public void singleArrayAddTest() {
        SingleArray sArray = new SingleArray();

        Assertions.assertTrue(sArray.isEmpty());

        sArray.add(Double.valueOf(5.0));
        sArray.add(Double.valueOf(5.0));
        sArray.add(Double.valueOf(5.0));

        Assertions.assertEquals(3, sArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),
                Double.valueOf(5.0),
                Double.valueOf(5.0)}, sArray.asArray());

        sArray.add(Double.valueOf(6.0), 1);

        Assertions.assertEquals(4, sArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),
                Double.valueOf(6.0),
                Double.valueOf(5.0),
                Double.valueOf(5.0)}, sArray.asArray());

        sArray.add(Double.valueOf(6.0), 0);

        Assertions.assertEquals(5, sArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(6.0),
                Double.valueOf(5.0),
                Double.valueOf(6.0),
                Double.valueOf(5.0),
                Double.valueOf(5.0)}, sArray.asArray());
    }

    @Test
    public void singleArrayRemoveTest() {
        SingleArray sArray = new SingleArray();

        Assertions.assertTrue(sArray.isEmpty());

        sArray.add(Double.valueOf(5.0));
        sArray.add(Double.valueOf(5.0));
        sArray.add(Double.valueOf(5.0));

        Assertions.assertEquals(3, sArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),
                Double.valueOf(5.0),
                Double.valueOf(5.0)}, sArray.asArray());

        sArray.remove(0);

        Assertions.assertEquals(2, sArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),
                Double.valueOf(5.0)}, sArray.asArray());

        sArray.add(Double.valueOf(5.0));

        sArray.remove(1);

        Assertions.assertEquals(2, sArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0),
                Double.valueOf(5.0)}, sArray.asArray());

        sArray.remove(1);

        Assertions.assertEquals(1, sArray.size());
        Assertions.assertArrayEquals(new Double[]{Double.valueOf(5.0)}, sArray.asArray());
    }
}
