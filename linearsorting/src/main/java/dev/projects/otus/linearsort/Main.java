package dev.projects.otus.linearsort;

import dev.projects.otus.linearsort.bucketsort.BucketSortTask;
import dev.projects.otus.linearsort.countingsort.CountingSortTask;
import dev.projects.otus.linearsort.radixsort.RadixSortTask;
import dev.projects.otus.quickandmergesort.MergeSortTask;
import dev.projects.otus.simplesort.shellsort.IGapShellSortStrategy;
import dev.projects.otus.simplesort.shellsort.MaxGapShellSortStrategy;
import dev.projects.otus.simplesort.shellsort.ShellSortTask;
import dev.projects.otus.testsystem.TestSystem;

import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        File directory = Path.of("/home/dev/projects/java/jotus/otus/linearsorting/src/main/resources").toFile();

        MergeSortTask mergeSortTask = new MergeSortTask();
        TestSystem.runTests(directory, mergeSortTask);

        IGapShellSortStrategy gapStrategy = new MaxGapShellSortStrategy();
        ShellSortTask shellSortTask = new ShellSortTask(gapStrategy);
        TestSystem.runTests(directory, shellSortTask);

        CountingSortTask countingSortTask = new CountingSortTask();
        TestSystem.runTests(directory, countingSortTask);

        BucketSortTask bucketTask = new BucketSortTask();
        TestSystem.runTests(directory, bucketTask);

        RadixSortTask radixSortTask = new RadixSortTask();
        TestSystem.runTests(directory, radixSortTask);
    }
}
