package dev.projects.otus.numberexp;

import dev.projects.otus.testsystem.ITask;

import java.util.List;

public class IterativeNumberExp extends AbstractNumberExp implements ITask {
    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        double number = 1.0, multi = Double.parseDouble(inArgs.get(0));
        long exp = Long.parseLong(inArgs.get(1));

        for(long expIndex = 0L; expIndex < exp; expIndex++) {
            number *= multi;
        }

        double correctResult = Double.parseDouble(outArgs.get(0));

        return Math.abs(number - correctResult) <= 1.0E-10;
    }
}
