package dev.projects.otus.dynamicarray;

public class FactorArray<T> implements IArray<T> {

    private Object[] array;
    private int factor;
    private int size;

    public FactorArray(int factor, int initLength) {
        this.factor = factor;
        array = new Object[initLength];
        size = 0;
    }

    public FactorArray() {
        this(50, 10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size() == array.length)
            resize();
        array[size] = item;
        size++;
    }

    @Override
    public void add(T item, int index) {
        // end of array
        if (size() == index + 1) {
            add(item);

            return;
        }

        //between
        if ((index > 0) && (index < size() - 1)) {
            Object[] newArray = new Object[size() + 1];
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index, newArray, index + 1, size() - 1);

            array = newArray;
            array[index] = item;
            size++;

            return;
        }

        //start of array
        Object[] newArray = new Object[size() + 1];
        System.arraycopy(array, 0, newArray, 1, size());

        array = newArray;
        array[0] = item;
        size++;

        return;
    }

    @Override
    public T remove(int index) {
        // end of array
        if (size() == index + 1) {
            Object[] newArray = new Object[size() - 1];
            System.arraycopy(array, 0, newArray, 0, index);

            T deleted = (T)array[size() - 1];
            array = newArray;
            size--;

            return deleted;
        }

        //between
        if ((index > 0) && (index < size() - 1)) {
            Object[] newArray = new Object[size() - 1];

            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index + 1, newArray, index, size() - 2);

            T deleted = (T)array[index];
            array = newArray;
            size--;

            return deleted;
        }

        //start of array
        Object[] newArray = new Object[size() - 1];
        System.arraycopy(array, 1, newArray, 0, size() - 1);

        T deleted = (T)array[index];
        array = newArray;
        size--;

        return deleted;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T)array[index];
    }

    @Override
    public T[] asArray() {
        return (T[])(array);
    }

    private void resize() {
        Object[] newArray = new Object[array.length + array.length * factor / 100];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}
