package co.edu.uniquindio.poo.pilas;

import java.util.EmptyStackException;

public class Stack<T> {

    private Node<T> top; // the head of the linked list
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // Adds an element on top
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(top); // 1. new node points to the old top
        top = newNode;        // 2. top now is the new node
        size++;
    }

    // Removes and returns the top element
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = top.getData();
        top = top.getNext(); // top moves down one node
        size--;
        return data;
    }

    // Returns the top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getData();
    }

    // Places the 'other' stack on top of this stack
    public void concatenate(Stack<T> other) {
        if (other == this) {
            throw new IllegalArgumentException("Cannot concatenate a stack with itself");
        }
        if (other.isEmpty()) {
            return; // edge case: nothing to add
        }

        // 1. Walk to the LAST node of 'other' (its bottom)
        Node<T> current = other.top;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        // 2. Link the bottom of 'other' to the top of this stack
        current.setNext(this.top);

        // 3. The top of 'other' becomes the new top of this stack
        this.top = other.top;

        // 4. Update size
        this.size += other.size;

        // 5. Empty 'other' so both stacks don't share the same nodes
        other.top = null;
        other.size = 0;
    }

    public void print() {
        Node<T> current = top;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
