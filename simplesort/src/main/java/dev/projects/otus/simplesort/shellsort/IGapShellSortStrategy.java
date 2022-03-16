package dev.projects.otus.simplesort.shellsort;

import java.util.List;

public interface IGapShellSortStrategy {
    List<Integer> computeGaps(int N);
}
