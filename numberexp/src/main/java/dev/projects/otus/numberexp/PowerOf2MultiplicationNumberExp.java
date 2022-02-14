package dev.projects.otus.numberexp;

import dev.projects.otus.testsystem.ITask;

import java.util.LinkedList;
import java.util.List;

public class PowerOf2MultiplicationNumberExp implements ITask {
    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        if ((inArgs == null)
                || (inArgs.isEmpty())
                || (inArgs.size() != 2)) throw new IllegalArgumentException("Unacceptable input args");

        if ((outArgs == null)
                || (outArgs.isEmpty())
                || (outArgs.size() != 1)) throw new IllegalArgumentException("Unacceptable output args");

        double number = Double.parseDouble(inArgs.get(0)), numberPower = 1L;
        long exp = Long.parseLong(inArgs.get(1));

        List<Long> powerOf2List = accumulatePowerOf2(exp);

        for (Long exponential : powerOf2List) {
            numberPower *= powerOf2(number, exponential);
        }

        double correctResult = Double.parseDouble(outArgs.get(0));

        return Math.abs(numberPower - correctResult) <= 1.0E-07;
    }

    private double powerOf2(double number, long exp) {
        double result = number;

        for (int index = 0; index < exp; index++) {
            result = result * result;
        }

        return result;
    }

    private List<Long> accumulatePowerOf2(long exp) {
        List<Long> powerOf2List = new LinkedList<>();

        long counter = 0, denominator = 1;

        while (exp > denominator) {
            if ((exp / denominator) % 2 == 1) {
                powerOf2List.add(counter);
            }

            denominator *= 2;

            counter++;
        }

        return powerOf2List;
    }
}
