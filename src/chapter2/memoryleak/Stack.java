package chapter2.memoryleak;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    private void ensureCapacity() {
        if (size == elements.length)
            elements = Arrays.copyOf(elements, size * 2 + 1);
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null; // prevents memory leak
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Stack clone() throws CloneNotSupportedException {
        try {
            Stack result = (Stack) super.clone();
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        String[] words = {"spring", "framework", "com"};
        Stack<String> stack = new Stack<>();
        for (String arg : words)
            stack.push(arg);
        while (!stack.isEmpty())
            System.out.print(stack.pop().toUpperCase() + ".");
    }
}
