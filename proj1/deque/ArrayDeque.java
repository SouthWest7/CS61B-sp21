package deque;

import java.lang.reflect.Array;

public class ArrayDeque <T>{
    private T[] items;
    private int size;
    private int front;
    private int rear;

    public ArrayDeque() {
        int capacity = 4;
        items = (T[]) new Object[capacity];
        front = 0;
        rear = front + 1;
        size = 0;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[front] = item;
        size++;
        front = (front - 1) % items.length;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[rear] = item;
        size++;
        front = (rear + 1) % items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int current = (front + 1) % items.length;
        while (current != rear) {
            System.out.print(items[current] + " ");
            current = (current + 1) % items.length;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T data = items[(front + 1) % items.length];

        front = (front + 1) % items.length;
        size--;

        if (size < items.length / 4 && size > 4) {
            resize(items.length / 2);
        }

        return data;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T data = items[(rear - 1) % items.length];

        rear = (rear - 1) % items.length;
        size--;

        if (size < items.length / 4 && size > 4) {
            resize(items.length / 2);
        }

        return data;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        return items[(front + 1 + index) % items.length];
    }

    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        for (int i = 1, current = (front + 1) % items.length;
             i <= size && current != rear;
             i++, current = (current + 1) % items.length) {
            newItems[i] = items[current];
        }
        front = 0;
        rear = size + 1;
        items = newItems;
    }

}
