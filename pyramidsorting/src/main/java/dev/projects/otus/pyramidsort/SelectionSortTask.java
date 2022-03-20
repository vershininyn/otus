package dev.projects.otus.pyramidsort;

import dev.projects.otus.testsystem.ITask;

import java.util.List;
import java.util.Random;

public class SelectionSortTask extends AbstractPyramidSort implements ITask {

    private int[] array = null;

    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        int size = Integer.parseInt(inArgs.get(0));

        array = (new Random(System.currentTimeMillis()))
                .ints(size, 0, 10000)
                .toArray();

        moveMaxToRoot(0, array.length);

        for(int index = array.length - 1; index > 0; index--) {
            swap(0, index);
            moveMaxToRoot(0, index);
        }

        return true;
    }

    private void moveMaxToRoot(int root, int size) {
        for (int index = root + 1; index < size; index++){
            if (array[root] < array[index]) {
                swap(root, index);
            }
        }
    }

    private void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
