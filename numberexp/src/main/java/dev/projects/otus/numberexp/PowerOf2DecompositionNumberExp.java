package dev.projects.otus.numberexp;

import dev.projects.otus.testsystem.ITask;

import java.util.List;

public class PowerOf2DecompositionNumberExp implements ITask {
    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        if ((inArgs == null)
                || (inArgs.isEmpty())
                || (inArgs.size() != 2)) throw new IllegalArgumentException("Unacceptable input args");

        if ((outArgs == null)
                || (outArgs.isEmpty())
                || (outArgs.size() != 1)) throw new IllegalArgumentException("Unacceptable output args");

        double number = Double.parseDouble(inArgs.get(0)), p = 1.0;
        long exp = Long.parseLong(inArgs.get(1));

        while(exp > 1) {
            exp = exp / 2;
            number *= number;

            if (exp % 2 == 1) {
                p *= number;
            }
        }

        double correctPowerOf2 = Double.parseDouble(outArgs.get(0));

        return Math.abs(p - correctPowerOf2) <= 1.0E-07;
    }
}
