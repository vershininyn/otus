package dev.projects.otus.quickandmergesort;

import dev.projects.otus.testsystem.ITask;

import java.util.List;
import java.util.Random;

public class LomutoQuickSortTask extends AbstractPivotTask implements ITask {
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
        if ((low < 0) || (low >= high)) return;

        int pivot = partition(low, high);

        quickSort(low, pivot - 1);
        quickSort(pivot + 1, high);
    }

    private int partition(int low, int high) {
        int pivot = array[high], i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (array[j] < pivot) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);

        return (i + 1);
    }

    private void swap(int left, int right) {
        int temp = array[right];
        array[right] = array[left];
        array[left] = temp;
    }
}
