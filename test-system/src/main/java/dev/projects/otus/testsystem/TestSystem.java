package dev.projects.otus.testsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class TestSystem {

    public static void runTests(File directory, ITask task) throws Exception {
        if ((directory == null)
                || (!directory.exists())
                || (!directory.isDirectory())) throw new IllegalArgumentException("Unacceptable directory");

        if (task == null) throw new IllegalArgumentException("Unacceptable task");

        int fileCounter = 0;

        String pathToTestDirectory = directory.getAbsolutePath();

        System.out.println("<<< ---------- >>>");

        while (true) {
            Path inFilePath = Path.of(pathToTestDirectory + File.separator + "test." + fileCounter + ".in"),
                    outFilePath = Path.of(pathToTestDirectory + File.separator + "test." + fileCounter + ".out");

            File inFile = inFilePath.toFile(), outFile = outFilePath.toFile();

            if ((!inFile.exists()) || (!outFile.exists())) break;

            try (
                    BufferedReader inReader = new BufferedReader(new FileReader(inFile));
                    BufferedReader outReader = new BufferedReader(new FileReader(outFile));
            ) {
                List<String> inArgs = inReader.lines().collect(Collectors.toList()),
                        outArgs = outReader.lines().collect(Collectors.toList());

                boolean result = task.run(inArgs, outArgs);

                System.out.println("Task["+fileCounter+"] = " + result);
            }

            fileCounter++;
        }

        System.out.println("<<< ---------- >>>");
    }

}
