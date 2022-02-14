package dev.projects.otus.fibonacci;

import dev.projects.otus.testsystem.ITask;

import java.util.List;

public class GoldenRatioFibonacciTask extends AbstractFibonacciTask implements ITask {
    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        Long fiboNumber = Long.parseLong(inArgs.get(0));
        Double correctResult = Double.valueOf(outArgs.get(0));

        double phi = 0.5*(1.0 + Math.sqrt(5.0)), powerOfPhi = Math.pow(phi, fiboNumber),
                fibo = Math.floor((1.0/Math.sqrt(5.0))*powerOfPhi + 0.5);

        return Math.abs(fibo - correctResult) <= 1.0E-07;
    }
}
