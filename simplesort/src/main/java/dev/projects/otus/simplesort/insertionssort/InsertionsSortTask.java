package dev.projects.otus.simplesort.insertionssort;

import dev.projects.otus.simplesort.AbstractSortTask;
import dev.projects.otus.testsystem.ITask;

import java.util.List;
import java.util.Random;

public class InsertionsSortTask extends AbstractSortTask implements ITask {
    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        int size = Integer.parseInt(inArgs.get(0));

        int[] array = (new Random(System.currentTimeMillis()))
                .ints(size, 0, 10000)
                .toArray();

        for (int i = 0; i < size; i++) {
            int j = i;

            while((j > 0) && (array[j - 1] > array[j] )) {
                int temp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = temp;
                j--;
            }
        }

        return true;
    }
}
