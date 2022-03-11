package dev.projects.otus.dynamicarray;

public interface IArray<T> {
    int size();

    void add(T item); // at end of array
    void add(T item, int index);

    T remove(int index);

    T get(int index);

    default boolean isEmpty() {
        return size() == 0;
    }

    T[] asArray();
}
