package dev.projects.otus.dynamicarray;

public class SingleArray<T> implements IArray<T> {

    private Object[] array;

    public SingleArray () {
        array = new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void add(T item) {
        resize();
        array[size() - 1] = item;
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

            return;
        }

        //start of array
        Object[] newArray = new Object[size() + 1];
        System.arraycopy(array, 0, newArray, 1, size());

        array = newArray;
        array[0] = item;

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

            return deleted;
        }

        //between
        if ((index > 0) && (index < size() - 1)) {
            Object[] newArray = new Object[size() - 1];

            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index + 1, newArray, index, size() - 2);

            T deleted = (T)array[index];
            array = newArray;

            return deleted;
        }

        //start of array
        Object[] newArray = new Object[size() - 1];
        System.arraycopy(array, 1, newArray, 0, size() - 1);

        T deleted = (T)array[index];
        array = newArray;

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
        Object[] newArray = new Object[size() + 1];
        System.arraycopy(array, 0, newArray, 0, size());
//        for (int j = 0; j < size(); j ++)
//            newArray[j] = array[j];
        array = newArray;
    }
}
