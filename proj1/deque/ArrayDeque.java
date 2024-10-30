package deque;

import java.util.Iterator;

public class ArrayDeque <T> implements Deque<T>, Iterable<T> {
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

    private class ArrayDequeIterator implements Iterator<T> {
        private int pos;

        public ArrayDequeIterator() {
            pos = (front + 1) % items.length;
        }

        @Override
        public boolean hasNext() {
            return pos != rear;
        }

        @Override
        public T next() {
            T data = get(pos);
            pos = (pos + 1) % items.length;
            return data;
        }
    }

    public ArrayDequeIterator iterator() {
        return new ArrayDequeIterator();
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[front] = item;
        size++;
        front = (front - 1 + items.length) % items.length;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[rear] = item;
        size++;
        rear = (rear + 1) % items.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int current = front = (front - 1 + items.length) % items.length;
        while (current != rear) {
            System.out.print(items[current] + " ");
            current = (current + 1) % items.length;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        int index = (front + 1) % items.length;
        T data = items[index];
        items[index] = null;

        front = index;
        size--;

        if (size < items.length / 4 && size > 4) {
            resize(items.length / 2);
        }

        return data;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        int index = (rear - 1 + items.length) % items.length;
        T data = items[index];
        items[index] = null;

        rear = index;
        size--;

        if (size < items.length / 4 && size > 4) {
            resize(items.length / 2);
        }

        return data;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        return items[(front + 1  + index) % items.length];
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof ArrayDeque)) {
            return false;
        }
        if (o == this) {
            return true;
        }
        ArrayDeque<T> other = (ArrayDeque<T>) o;
        if (size != other.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (get(i) != other.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        for (int i = 1, current = (front + 1 + items.length) % items.length;
             i <= size;
             i++, current = (current + 1) % items.length) {
            newItems[i] = items[current];
        }
        front = 0;
        rear = size + 1;
        items = newItems;
    }

}
