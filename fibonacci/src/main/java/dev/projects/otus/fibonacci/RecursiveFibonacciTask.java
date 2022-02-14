package dev.projects.otus.fibonacci;

import dev.projects.otus.testsystem.ITask;

import java.util.List;

public class RecursiveFibonacciTask extends AbstractFibonacciTask implements ITask {
    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        Long numberOfFibo = Long.parseLong(inArgs.get(0));
        Double correctResult = Double.parseDouble(outArgs.get(0)),
                actualResult = recursiveFibo(numberOfFibo);

        return Math.abs(actualResult - correctResult) <= 1.0E-07;
    }

    private Double recursiveFibo(long N) {
        if (N <= 1) {
            return Double.valueOf(N);
        }

        return recursiveFibo(N - 1) + recursiveFibo(N - 2);
    }
}
