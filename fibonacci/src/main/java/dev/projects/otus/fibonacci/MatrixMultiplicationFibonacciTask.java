package dev.projects.otus.fibonacci;

import dev.projects.otus.testsystem.ITask;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class MatrixMultiplicationFibonacciTask extends AbstractFibonacciTask implements ITask {
    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        long exp = Long.parseLong(inArgs.get(0));

        List<Long> powerOf2List = accumulatePowerOf2(exp);

        Matrix2D matrixPower = new Matrix2D();

        if (exp == 0) {
            matrixPower.setValue(0,0,new BigInteger("0",10));
        }

        for (Long exponential : powerOf2List) {
            for (int index = 0; index < exponential; index++) {
                matrixPower = matrixPower.multiply(matrixPower);
            }
        }

        BigInteger correctResult = new BigInteger(outArgs.get(0), 10);

        return matrixPower.getValue(0, 0).compareTo(correctResult) == 0;
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
