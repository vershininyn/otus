package dev.projects.otus.dynamicarray;

import java.util.Arrays;

public class MatrixArray<T> implements IArray<T> {

    private int size;
    private int vector;
    private IArray<IArray<T>> array;

    public MatrixArray(int vector) {
        this.vector = vector;
        array = new SingleArray<>();
        size = 0;
    }

    public MatrixArray() {
        this(10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size == array.size() * vector)
            array.add(new VectorArray<T>(vector));
        array.get(size / vector).add(item);
        size++;
    }

    @Override
    public void add(T item, int index) {
        int row = index / vector,
                column = index % vector;

        // add new row?
        if (array.get(row).size() >= vector) {
            array.add(new VectorArray<T>(vector));
        }

        array.get(row).add(item, column);
        size++;
    }

    @Override
    public T remove(int index) {
        int row = index / vector,
                column = index % vector;

        T deleted = array.get(row).remove(column);
        size--;

        if (array.get(row).size() <= 0) {
            array.remove(row);
        }

        return deleted;
    }

    @Override
    public T get(int index) {
        return array.get(index / vector).get(index % vector);
    }

    @Override
    public T[] asArray() {
        Object[] result = new Object[array.size()*vector];

        Arrays.fill(result, null);

        int row = 0, index = 0;

        while(row < array.size()) {
            IArray<T> currentArray = array.get(row);
            int column = 0;

            while(column < currentArray.size()) {
                result[index] = currentArray.get(column);

                column++;
                index++;
            }

            row++;
        }

        return (T[])(result);
    }
}
