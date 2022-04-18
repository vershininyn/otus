package dev.projects.otus.quickandmergesort;

import dev.projects.otus.testsystem.ITask;

import java.util.List;
import java.util.Random;

public class MergeSortTask extends AbstractPivotTask implements ITask {
    private int[] array = null;

    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        int size = Integer.parseInt(inArgs.get(0));

        array = (new Random(System.currentTimeMillis()))
                .ints(size, 0, 10000)
                .toArray();

        sort(0 , array.length - 1);

        return true;
    }

    private void sort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low)/2;

            sort(low, middle);
            sort(middle + 1, high);

            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
        int n1 = middle - low + 1;
        int n2 = high - middle;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = array[low + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[middle + 1 + j];

        /* Merge the temp arrays */

        int i = 0, j = 0, k = low;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            }
            else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
}
