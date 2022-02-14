package dev.projects.otus.numberexp;

import dev.projects.otus.testsystem.TestSystem;

import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        File directory = Path.of("/home/dev/projects/java/jotus/otus/numberexp/src/main/resources/3.Power").toFile();

        IterativeNumberExp iterativeTask = new IterativeNumberExp();
        TestSystem.runTests(directory, iterativeTask);

        PowerOf2DecompositionNumberExp powerOf2Task = new PowerOf2DecompositionNumberExp();
        TestSystem.runTests(directory, powerOf2Task);

        PowerOf2MultiplicationNumberExp powerOf2MultiplicationTask = new PowerOf2MultiplicationNumberExp();
        TestSystem.runTests(directory, powerOf2MultiplicationTask);
    }
}
