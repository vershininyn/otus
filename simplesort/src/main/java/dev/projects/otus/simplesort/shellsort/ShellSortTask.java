package dev.projects.otus.simplesort.shellsort;

import dev.projects.otus.simplesort.AbstractSortTask;
import dev.projects.otus.testsystem.ITask;

import java.util.List;
import java.util.Random;

public class ShellSortTask extends AbstractSortTask implements ITask {
    private IGapShellSortStrategy gapStrategy = null;

    public ShellSortTask(IGapShellSortStrategy gapStrategy) {
        this.gapStrategy = gapStrategy;
    }

    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        int size = Integer.parseInt(inArgs.get(0));

        int[] array = (new Random(System.currentTimeMillis()))
                .ints(size, 0, 10000)
                .toArray();

        List<Integer> gaps = gapStrategy.computeGaps(size);

        for(Integer gap: gaps) {
            for (int offset = 0; offset < gap; offset++) {
                for (int i = offset; i < size; i += gap) {
                    int temp = array[i], j = 0;

                    for (j = i; (j >= gap) && (array[j - gap] > temp); j -= gap){
                        array[j] = array[j - gap];
                    }

                    array[j] = temp;
                }
            }
        }


        return true;
    }
}
