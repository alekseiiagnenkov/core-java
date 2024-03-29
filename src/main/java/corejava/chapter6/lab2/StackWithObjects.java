package corejava.chapter6.lab2;

import corejava.chapter6.CustomStack;

import java.util.Arrays;

public class StackWithObjects<E> implements CustomStack<E> {
    private Object[] array;
    private int size;
    private final double INCREASE_NUMBER = 1.5;

    public StackWithObjects() {
        array = new Object[10];
        size = 0;
    }

    public void push(E item) {
        if (size + 1 == array.length) {
            increase();
        }
        array[size++] = item;
    }

    private void increase() {
        array = Arrays.copyOf(array, (int) (array.length * INCREASE_NUMBER));
    }

    public E pop() {
        if (size - 1 < 0) {
            throw new RuntimeException("array is empty");
        }
        return (E) array[size--];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
