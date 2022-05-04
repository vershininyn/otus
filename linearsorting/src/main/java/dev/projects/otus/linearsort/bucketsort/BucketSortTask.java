package dev.projects.otus.linearsort.bucketsort;

import dev.projects.otus.linearsort.AbstractLinearSortTask;
import dev.projects.otus.testsystem.ITask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BucketSortTask extends AbstractLinearSortTask implements ITask {
    private int[] array = null;

    private List<Bucket> listOfBuckets = null;

    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        int size = Integer.parseInt(inArgs.get(0));

        array = (new Random(System.currentTimeMillis()))
                .ints(size, 0, 10000)
                .toArray();

        listOfBuckets = new ArrayList<>(size);

        for (int bucketIndex = 0; bucketIndex < size; bucketIndex++) {
            listOfBuckets.add(new Bucket());
        }

        List<Integer> result = bucketSort();

        return true;
    }

    private List<Integer> bucketSort() {
        int max = Arrays.stream(array).max().getAsInt(),
                size = array.length;

        for (int index = 0; index < size; index++) {
            int bucketIndex = (array[index]*size)/(max + 1);

            listOfBuckets.get(bucketIndex).add(array[index]);
        }

        List<Integer> result = new ArrayList<>(size);

        for(int bucketIndex = 0; bucketIndex < size; bucketIndex++){
            Bucket bucket = listOfBuckets.get(bucketIndex);

            for(Integer bucketValue: bucket) {
                result.add(bucketValue);
            }
        }

        return result;
    }
}
