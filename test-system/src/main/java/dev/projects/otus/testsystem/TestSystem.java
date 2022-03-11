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

                if ((inArgs == null)
                        || (inArgs.isEmpty())
                        || (inArgs.size() != task.getInputArgumentSize())) throw new IllegalArgumentException("Unacceptable input args");

                if ((outArgs == null)
                        || (outArgs.isEmpty())
                        || (outArgs.size() != task.getOutputArgumentSize())) throw new IllegalArgumentException("Unacceptable output args");

                long startTime = System.currentTimeMillis();
                boolean result = task.run(inArgs, outArgs);
                long endTime = System.currentTimeMillis();

                System.out.println("Task["+fileCounter+"]= " + result + ",time= "+(endTime - startTime) + "ms");
            }

            fileCounter++;
        }

        System.out.println("<<< ---------- >>>");
    }
}
