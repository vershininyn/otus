package dev.projects.otus.quickandmergesort;

import dev.projects.otus.testsystem.TestSystem;

import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        File directory = Path.of("/home/dev/projects/java/jotus/otus/quickandmergesort/src/main/resources").toFile();

        LomutoQuickSortTask lomutoQuickSortTask = new LomutoQuickSortTask();
        TestSystem.runTests(directory, lomutoQuickSortTask);

        HoareQuickSortTask hoareQuickSortTask = new HoareQuickSortTask();
        TestSystem.runTests(directory, hoareQuickSortTask);

        MergeSortTask mergeSortTask = new MergeSortTask();
        TestSystem.runTests(directory, mergeSortTask);
    }
}
