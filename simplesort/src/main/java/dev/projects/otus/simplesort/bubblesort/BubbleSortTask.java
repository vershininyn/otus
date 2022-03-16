package dev.projects.otus.simplesort.bubblesort;

import dev.projects.otus.simplesort.AbstractSortTask;
import dev.projects.otus.testsystem.ITask;

import java.util.List;
import java.util.Random;

public class BubbleSortTask extends AbstractSortTask implements ITask {
    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        int size = Integer.parseInt(inArgs.get(0));

        int[] array = (new Random(System.currentTimeMillis()))
                .ints(size, 0, 10000)
                .toArray();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return true;
    }
}
