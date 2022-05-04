package dev.projects.otus.linearsort.bucketsort;

import java.util.LinkedList;
import java.util.List;

public class Bucket
        extends LinkedList<Integer>
        implements List<Integer> {

    @Override
    public boolean add(Integer aInteger) {
        super.add(aInteger);

        quickSort(0, size() - 1);

        return true;
    }

    private void quickSort(int low, int high) {
        if ((low < 0) || (high < 0) || (low >= high)) return;

        int pivot = partition(low, high);
        quickSort(low, pivot);
        quickSort(pivot + 1, high);
    }

    private int partition(int low, int high) {
        int pivot = get((int) Math.floor((high + low) / 2));

        int i = low - 1, j = high + 1;

        while (true) {
            do {
                i++;
            } while (get(i) < pivot);

            do {
                j--;
            } while (get(j) > pivot);

            if (i >= j) return j;

            swap(i, j);
        }
    }

    private void swap(int left, int right) {
        int temp = get(right);
        set(right, get(left));
        set(left, temp);
    }
}
