package dev.projects.otus.fibonacci;

import dev.projects.otus.testsystem.ITask;

import java.util.ArrayList;
import java.util.List;

public class IterativeFibonacciTask extends AbstractFibonacciTask implements ITask {
    private List<Long> startFibo = new ArrayList<>(3);

    {
        startFibo.add(0L);
        startFibo.add(1L);
        startFibo.add(1L);
    }

    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        Long fiboNumber = Long.parseLong(inArgs.get(0));
        Double correctResult = Double.valueOf(outArgs.get(0));

        double a = 1.0, b = 1.0, f = (fiboNumber <= 2) ? (startFibo.get(fiboNumber.intValue())) : (0.0);

        for (long index = 3; index <= fiboNumber; index++) {
            f = a + b;
            a = b;
            b = f;
        }

        return Math.abs(f - correctResult) <= 1.0E-07;
    }
}
