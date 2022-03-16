package dev.projects.otus.simplesort.shellsort;

import java.util.ArrayList;
import java.util.List;

public class KPowerOfTwoGapShellSortStrategy implements IGapShellSortStrategy {

    @Override
    public List<Integer> computeGaps(int N) {
        List<Integer> result = new ArrayList<>(512);

        int k = 1;

        while(true) {
            int value = (int)Math.floor(N/Math.pow(2.0,k));
            result.add(value);

            if (value == 1) break;
            k++;
        }

        return result;
    }
}
