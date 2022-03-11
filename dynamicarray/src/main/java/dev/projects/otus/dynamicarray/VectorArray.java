package dev.projects.otus.dynamicarray;

public class VectorArray<T> implements IArray<T> {

    private Object[] array;
    private int vector;
    private int size;

    public VectorArray(int vector) {
        this.vector = vector;
        array = new Object[0];
        size = 0;
    }

    public VectorArray() {
        this(10);
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
        if ((size() + vector) == index + 1) {
            add(item);

            return;
        }

        //between
        if ((index > 0) && (index < size() + vector - 1)) {
            System.arraycopy(array, index, array, index + 1, size() - 1);
            array[index] = item;
            size++;

            return;
        }

        //start of array
        System.arraycopy(array, 0, array, 1, size());
        array[0] = item;
        size++;

        return;
    }

    @Override
    public T remove(int index) {
        // end of array
        if (array.length == index + 1) {
            Object[] newArray = new Object[array.length - 1];
            System.arraycopy(array, 0, newArray, 0, index);

            T deleted = (T) array[array.length - 1];
            array = newArray;

            return deleted;
        }

        //between
        if ((index > 0) && (index < array.length - 1)) {
            Object[] newArray = new Object[array.length - 1];

            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index + 1, newArray, index, array.length - 2);

            T deleted = (T) array[index];
            array = newArray;

            if (deleted != null) {
                size--;
            }

            return deleted;
        }

        //start of array
        Object[] newArray = new Object[array.length - 1];
        System.arraycopy(array, 1, newArray, 0, array.length - 1);

        T deleted = (T) array[index];
        array = newArray;

        if (deleted != null) {
            size--;
        }

        return deleted;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public T[] asArray() {
        return (T[]) array;
    }

    private void resize() {
        Object[] newArray = new Object[array.length + vector];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}
