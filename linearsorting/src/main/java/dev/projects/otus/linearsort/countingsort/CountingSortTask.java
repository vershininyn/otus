package dev.projects.otus.linearsort.countingsort;

import dev.projects.otus.linearsort.AbstractLinearSortTask;
import dev.projects.otus.testsystem.ITask;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CountingSortTask extends AbstractLinearSortTask implements ITask {
    private char[] source = null, output = null;

    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        int size = Integer.parseInt(inArgs.get(0));

        Random rnd = new Random(System.currentTimeMillis());

        source = new char[size];
        output = new char[size];

        for (int charIndex = 0; charIndex < size; charIndex++) {
            source[charIndex] = (char)(rnd.nextInt(26) + 'a');
        }

        int[] count = new int[256];
        Arrays.fill(count, 0);

        for (int i = 0; i < size; i++) {
            count[source[i]] += 1;
        }

        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }

        for (int i = size - 1; i >= 0 ; i--) {
            output[count[source[i]] - 1] = source[i];
            count[source[i]] -= 1;
        }

        return true;
    }
}
