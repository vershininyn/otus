package dev.projects.otus.simplesort;

import dev.projects.otus.simplesort.bubblesort.BubbleSortTask;
import dev.projects.otus.simplesort.insertionssort.InsertionsSortTask;
import dev.projects.otus.simplesort.shellsort.KPlusOnePowerOfTwoGapShellSortStrategy;
import dev.projects.otus.simplesort.shellsort.KPowerOfTwoGapShellSortStrategy;
import dev.projects.otus.simplesort.shellsort.MaxGapShellSortStrategy;
import dev.projects.otus.simplesort.shellsort.ShellSortTask;
import dev.projects.otus.testsystem.TestSystem;

import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        File directory = Path.of("/home/dev/projects/java/jotus/otus/simplesort/src/main/resources").toFile();

        BubbleSortTask bubbleSort = new BubbleSortTask();
        TestSystem.runTests(directory, bubbleSort);

        InsertionsSortTask insertionsTask = new InsertionsSortTask();
        TestSystem.runTests(directory, insertionsTask);

        KPowerOfTwoGapShellSortStrategy powerOfTwoGapStrategy = new KPowerOfTwoGapShellSortStrategy();
        ShellSortTask shellSortTask = new ShellSortTask(powerOfTwoGapStrategy);
        TestSystem.runTests(directory, shellSortTask);

        KPlusOnePowerOfTwoGapShellSortStrategy kPlusOnePowerOfTwoGapStrategy = new KPlusOnePowerOfTwoGapShellSortStrategy();
        shellSortTask = new ShellSortTask(kPlusOnePowerOfTwoGapStrategy);
        TestSystem.runTests(directory, shellSortTask);

        MaxGapShellSortStrategy maxGapShellSortStrategy = new MaxGapShellSortStrategy();
        shellSortTask = new ShellSortTask(maxGapShellSortStrategy);
        TestSystem.runTests(directory, shellSortTask);
    }
}
