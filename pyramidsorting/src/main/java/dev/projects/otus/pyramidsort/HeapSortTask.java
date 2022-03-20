package dev.projects.otus.pyramidsort;

import dev.projects.otus.testsystem.ITask;

import java.util.List;
import java.util.Random;

public class HeapSortTask extends AbstractPyramidSort implements ITask {

    private int[] array = null;

    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        int size = Integer.parseInt(inArgs.get(0));

        array = (new Random(System.currentTimeMillis()))
                .ints(size, 0, 10000)
                .toArray();

        for(int root = (array.length/2 - 1); root >= 0; root--) {
            moveMaxToRoot(root, array.length);
        }

        for(int index = array.length - 1; index > 0; index--) {
            swap(0, index);
            moveMaxToRoot(0, index);
        }

        return true;
    }

    private void moveMaxToRoot(int root, int size) {
        int L = 2*root + 1, R = 2*root + 2;

        int X = root;

        if ((L < size) && (array[L] > array[X])) {
            X = L;
        }

        if ((R < size) && (array[R] > array[X])) {
            X = R;
        }

        if (X == root) return;

        swap(X, root);
        moveMaxToRoot(X ,size);
    }

    private void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
