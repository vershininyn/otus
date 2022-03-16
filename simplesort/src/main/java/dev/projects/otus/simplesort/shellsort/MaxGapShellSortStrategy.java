package dev.projects.otus.simplesort.shellsort;

import java.util.ArrayList;
import java.util.List;

public class MaxGapShellSortStrategy implements IGapShellSortStrategy {

    @Override
    public List<Integer> computeGaps(int N) {
        List<Integer> result = new ArrayList<>(512);

        int h = N;

        while (true) {
            h = (int) (Math.max(1.0, (int)(Math.floor((5*h - 1)/(11)))));
            result.add(h);

            if (h == 1) break;
        }

        return result;
    }
}
