package deque;

import java.util.Iterator;

public class LinkedListDeque <T> implements Deque<T> {
    private class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<T> sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node<T>(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    private class LinkedListIterator<T> implements Iterator<T> {
        private LinkedListDeque<T>.Node<T> current;

        LinkedListIterator() {
            current = (LinkedListDeque<T>.Node<T>) sentinel.next;
        }

        @Override
        public boolean hasNext() {
            return current != sentinel;
        }

        @Override
        public T next() {
            T data = current.data;
            current = current.next;

            return data;
        }
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<T>(item);
        newNode.next = sentinel.next;
        newNode.next.prev = newNode;
        newNode.prev = sentinel;
        sentinel.next = newNode;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> newNode = new Node<T>(item);
        newNode.prev = sentinel.prev;
        newNode.next = sentinel;
        sentinel.prev = newNode;
        newNode.prev.next = newNode;
        size++;
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
        Node<T> current = sentinel.next;
        while (current != sentinel) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T data = sentinel.next.data;

        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;

        return data;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T data = sentinel.prev.data;

        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;

        return data;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<T> current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }

    private T getRecursiveHelper(int index, Node<T> current) {
        if (index == 0) {
            return current.data;
        }

        return getRecursiveHelper(index - 1, current.next);
    }
}
