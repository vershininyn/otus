package dev.projects.otus.quickandmergesort;

import dev.projects.otus.testsystem.ITask;

import java.util.List;
import java.util.Random;

public class HoareQuickSortTask extends AbstractPivotTask implements ITask {
    private int[] array = null;

    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        int size = Integer.parseInt(inArgs.get(0));

        array = (new Random(System.currentTimeMillis()))
                .ints(size, 0, 10000)
                .toArray();

        quickSort(0, array.length - 1);

        return true;
    }

    private void quickSort(int low, int high) {
        if ((low < 0) || (high < 0) || (low >= high)) return;

        int pivot = partition(low, high);
        quickSort(low, pivot);
        quickSort(pivot + 1, high);
    }

    private int partition(int low, int high) {
        int pivot = array[(int) Math.floor((high + low) / 2)];

        int i = low - 1, j = high + 1;

        while (true) {
            do {
                i++;
            } while (array[i] < pivot);

            do {
                j--;
            } while (array[j] > pivot);

            if (i >= j) return j;

            swap(i, j);
        }
    }

    private void swap(int left, int right) {
        int temp = array[right];
        array[right] = array[left];
        array[left] = temp;
    }
}
