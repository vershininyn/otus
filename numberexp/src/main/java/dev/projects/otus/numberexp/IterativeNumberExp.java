package dev.projects.otus.numberexp;

import dev.projects.otus.testsystem.ITask;

import java.util.List;

public class IterativeNumberExp implements ITask {

    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        if ((inArgs == null)
                || (inArgs.isEmpty())
                || (inArgs.size() != 2)) throw new IllegalArgumentException("Unacceptable input args");

        if ((outArgs == null)
                || (outArgs.isEmpty())
                || (outArgs.size() != 1)) throw new IllegalArgumentException("Unacceptable output args");

        double number = 1.0, multi = Double.parseDouble(inArgs.get(0));
        long exp = Long.parseLong(inArgs.get(1));

        for(long expIndex = 0L; expIndex < exp; expIndex++) {
            number *= multi;
        }

        double correctResult = Double.parseDouble(outArgs.get(0));

        return Math.abs(number - correctResult) <= 1.0E-10;
    }
}
