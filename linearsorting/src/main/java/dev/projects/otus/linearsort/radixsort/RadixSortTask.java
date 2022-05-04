package dev.projects.otus.linearsort.radixsort;

import dev.projects.otus.linearsort.AbstractLinearSortTask;
import dev.projects.otus.testsystem.ITask;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class RadixSortTask extends AbstractLinearSortTask implements ITask {
    private int[] array = null;

    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        int size = Integer.parseInt(inArgs.get(0));

        array = (new Random(System.currentTimeMillis()))
                .ints(size, 0, 1000)
                .toArray();

        radixSort();

        return true;
    }

    private void radixSort() {
        int max = Arrays.stream(array).max().getAsInt();

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(exp);
        }
    }

    private void countSort(int exp) {
        int dim = array.length;

        int[] output = new int[dim], count = new int[256];

        Arrays.fill(count, 0);

        for (int i = 0; i < dim; i++) {
            count[(array[i] / exp) % 10] += 1;
        }

        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }

        for (int i = dim - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10] -= 1;
        }

        System.arraycopy(output, 0, array, 0, dim);
    }
}
