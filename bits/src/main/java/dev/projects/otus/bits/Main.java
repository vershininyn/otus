package dev.projects.otus.bits;

import dev.projects.otus.testsystem.TestSystem;

import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        File directory = Path.of("/home/dev/projects/java/jotus/otus/bits/src/main/resources/2.Bitboard - Конь").toFile();

        HorseBitboardTask horseTask = new HorseBitboardTask();
        TestSystem.runTests(directory, horseTask);

        directory = Path.of("/home/dev/projects/java/jotus/otus/bits/src/main/resources/1.Bitboard - Король").toFile();

        KingBitboardTask kingTask = new KingBitboardTask();
        TestSystem.runTests(directory, kingTask);
    }
}
