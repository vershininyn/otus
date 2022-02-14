package dev.projects.otus.fibonacci;

import dev.projects.otus.testsystem.TestSystem;

import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        File directory = Path.of("/home/dev/projects/java/jotus/otus/fibonacci/src/main/resources/4.Fibo").toFile();

        RecursiveFibonacciTask recursiveTask = new RecursiveFibonacciTask();
        TestSystem.runTests(directory, recursiveTask);

        IterativeFibonacciTask iterativeTask = new IterativeFibonacciTask();
        TestSystem.runTests(directory, iterativeTask);

        GoldenRatioFibonacciTask goldenTask = new GoldenRatioFibonacciTask();
        TestSystem.runTests(directory, goldenTask);
    }
}
