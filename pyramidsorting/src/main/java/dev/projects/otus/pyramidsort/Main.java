package dev.projects.otus.pyramidsort;

import dev.projects.otus.testsystem.TestSystem;

import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        File directory = Path.of("/home/dev/projects/java/jotus/otus/pyramidsorting/src/main/resources").toFile();

        SelectionSortTask task = new SelectionSortTask();
        TestSystem.runTests(directory, task);

        HeapSortTask heapTask = new HeapSortTask();
        TestSystem.runTests(directory, heapTask);
    }
}
